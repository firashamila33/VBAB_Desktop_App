/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import interfaces.IIdeeService;
import interfaces.IUserService;
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
    private Label User_name;
    @FXML
    private JFXListView<Idee> public_Ideas_list_view_me;
    private ObservableList<Idee> Idees_list_me;
    @FXML
    private AnchorPane add_form_details;
    @FXML
    private JFXTextField ideat_titre;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //getting the user from database
        IUserService U_tools = new UserService();
        Static_User = U_tools.getUserById(10);
        User_name.setText(Static_User.getNom());

        IIdeeService I_tool = new IdeeService();

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
        add_form_details.setVisible(false);
        add_forvm_details1.setVisible(false);

    }

    

    @FXML
    private void show_all_ideas(ActionEvent event) {
        public_Ideas_list_view.setVisible(true);
        public_Ideas_list_view_me.setVisible(false);
        add_form_details.setVisible(false);
        add_forvm_details1.setVisible(false);

    }

    @FXML
    private void show_my_ideas(ActionEvent event) {
        public_Ideas_list_view.setVisible(false);
        public_Ideas_list_view_me.setVisible(true);
        add_form_details.setVisible(false);
        add_forvm_details1.setVisible(false);
    }
    @FXML
    private void create_new_idea(ActionEvent event) {
        add_form_details.setVisible(true);
        add_forvm_details1.setVisible(true);
        public_Ideas_list_view.setVisible(false);
        public_Ideas_list_view_me.setVisible(false);
    }

    @FXML
    private void save_new_idea(ActionEvent event) {
         Idee i = new Idee();
        i.setTitre(ideat_titre.getText());
        i.setDomaine(idea_domaine.getText());
        i.setDescription(idea_Description.getText());
        i.setPrix(Integer.parseInt(idea_prix.getText()));
        i.setPath_doc( idea_doc.getText());
        i.setPath_img(idea_image.getText());
        //converting localdate to date type
        String date = idea_date.getValue() + " " ;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        try {
            startDate = df.parse(date);
            String newDateString = df.format(startDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        i.setDate_ajout( new java.sql.Date(startDate.getTime()));
//        idea_date.getValue();
        i.setUser_id(2);
        i.setEtat("NON");
        System.out.println(i);
        //adding idea to database
        IIdeeService I_tool = new IdeeService();
        I_tool.add(i);
        public_Ideas_list_view_me.getItems().add(i);
        public_Ideas_list_view_me.refresh();
        
        
    }

    

}
