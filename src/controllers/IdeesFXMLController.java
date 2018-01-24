/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import interfaces.IIdeeService;
import interfaces.IUserService;
import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import models.Idee;
import models.User;
import services.IdeeService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author plazma33
 */
public class IdeesFXMLController implements Initializable {

    @FXML
    public JFXListView<Idee> public_Ideas_list_view;
    private ObservableList<Idee> Idees_list;
    public User Static_User;
    @FXML
    public Label User_name;
    @FXML
    private JFXListView<Idee> public_Ideas_list_view_me;
    private ObservableList<Idee> Idees_list_me;
    @FXML
    private AnchorPane add_form_details;
    @FXML
    public JFXTextField ideat_titre;
    @FXML
    private JFXTextField idea_domaine;
    @FXML
    private JFXTextField idea_Description;
    @FXML
    private JFXTextField idea_prix;
    @FXML
    private JFXDatePicker idea_date;
    @FXML
    private AnchorPane add_forvm_details1;
    @FXML
    private JFXTextField idea_image;
    @FXML
    private JFXTextField idea_doc;
    @FXML
    private JFXButton add_btn;

    public String vari = "azaz";
    @FXML
    private JFXButton edit;
    public static Idee Idea;

    public int state_action = 0; //0 if user is going to use the form for adding and 1 if the user will edit an idea
    @FXML
    private JFXButton show_my_ideas_btn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //getting the user from database
        IUserService U_tools = new UserService();
        //setting the static user ,, in here you should be getting the static 
        //user from the user class where there will be a final static user attrebute

        Static_User = U_tools.getUserById(10);
        User_name.setText(Static_User.getNom());
        
        
        System.out.println(Static_User.getRole());
        
        IIdeeService I_tool = new IdeeService();
        
        //hiding client modules and showing the Adming unchecked ideas list
        if (Static_User.getRole().equals("Admin")) {
            public_Ideas_list_view.setVisible(false);
            add_forvm_details1.setVisible(false);
            add_form_details.setVisible(false);
            show_my_ideas_btn.setVisible(false);
            add_btn.setVisible(false);
            edit.setVisible(false);       
            //displaying all ideas to the list view
            Idees_list = FXCollections.observableArrayList(I_tool.getNonChecked());
            public_Ideas_list_view_me.setItems(Idees_list);
            public_Ideas_list_view_me.setCellFactory(f -> new OneIdeasFXMLController(2));
        }
        
        
        //showing client modules
        if (Static_User.getRole().equals("Client")) {

            //displaying all ideas to the list view
            Idees_list = FXCollections.observableArrayList(I_tool.getChecked());
            public_Ideas_list_view.setItems(Idees_list);
            public_Ideas_list_view.setCellFactory(f -> new OneIdeasFXMLController(0));

            //displaying the user ideas to the list view
            Idees_list_me = FXCollections.observableArrayList(I_tool.getIdeesByUserId(2));
            public_Ideas_list_view_me.setItems(Idees_list_me);
            public_Ideas_list_view_me.setCellFactory(f -> new OneIdeasFXMLController(1));

            public_Ideas_list_view.setVisible(true);
            public_Ideas_list_view_me.setVisible(false);
            add_form_details.setVisible(true);
            add_forvm_details1.setVisible(true);
        }

    }

    @FXML
    private void show_all_ideas(ActionEvent event) {
        public_Ideas_list_view.setVisible(true);
        public_Ideas_list_view_me.setVisible(false);
//        add_form_details.setVisible(false);
//        add_forvm_details1.setVisible(false);
        add_form_details.setVisible(true);
        add_forvm_details1.setVisible(true);

    }

    @FXML
    private void show_my_ideas(ActionEvent event) {
        public_Ideas_list_view.setVisible(false);
        public_Ideas_list_view_me.setVisible(true);
        add_form_details.setVisible(true);
        add_forvm_details1.setVisible(true);

    }

    @FXML
    private void create_new_idea(ActionEvent event) {
        add_form_details.setVisible(true);
        add_forvm_details1.setVisible(true);
        public_Ideas_list_view.setVisible(false);
        public_Ideas_list_view_me.setVisible(false);
        state_action = 0;
    }

    @FXML
    private void save_new_idea(ActionEvent event) {

        Idee i = new Idee();
        i.setTitre(ideat_titre.getText());
        i.setDomaine(idea_domaine.getText());
        i.setDescription(idea_Description.getText());
        i.setPrix(Integer.parseInt(idea_prix.getText()));
        i.setPath_doc(idea_doc.getText());
        i.setPath_img(idea_image.getText());
        //converting localdate to date type
        String date = idea_date.getValue() + " ";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        try {
            startDate = df.parse(date);
            String newDateString = df.format(startDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        i.setDate_ajout(new java.sql.Date(startDate.getTime()));
        i.setUser_id(2);
        i.setEtat("NON");
        System.out.println(i);
        //adding idea to database
        IIdeeService I_tool = new IdeeService();
        if (state_action == 0) {
            I_tool.add(i);
            public_Ideas_list_view_me.getItems().add(i);

        } else if (state_action == 1) {
            System.out.println("I editeeeeed");
            i.setId(Idea.getId());
            I_tool.update(i);
            public_Ideas_list_view_me.getItems().remove(Idea);
            public_Ideas_list_view_me.refresh();
            public_Ideas_list_view_me.getItems().add(i);
            state_action = 0;
        }

        public_Ideas_list_view_me.refresh();
        state_action = 0;

        //clearing form fields
        idea_image.setText("");
        idea_doc.setText("");
        idea_prix.setText("");
        idea_domaine.setText("");
        idea_Description.setText("");
        ideat_titre.setText("");

    }

    public void EditIdea(Idee I) {
        //filling the static idea variable with content from the row to edit
        Idea = I;

    }

    @FXML
    private void get_eit_idea_details(ActionEvent event) {
        //filling the form from static idea when button clicked
        if (Idea.getId() > 0) {
            idea_image.setText(Idea.getPath_img());
            idea_doc.setText(Idea.getPath_doc());
            idea_prix.setText(Idea.getPrix() + "");
            idea_domaine.setText(Idea.getDomaine());
            idea_Description.setText(Idea.getDescription());
            ideat_titre.setText(Idea.getTitre());
            state_action = 1;
        }

    }

}
