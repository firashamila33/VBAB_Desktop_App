/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import interfaces.IIdeeService;
import interfaces.IUserService;
import models.Idee;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import services.IdeeService;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author plazma33
 */
public class OneIdeasFXMLController extends ListCell<Idee> {

    @FXML
    private Label idea_title;
    @FXML
    private Label quantity;
    @FXML
    private Label idea_domaine;
    @FXML
    private Label idea_description;
    @FXML
    private Label idea_price;
    @FXML
    private AnchorPane row;
    private FXMLLoader mLLoader;
    @FXML
    private JFXButton edit_idea_button;
    @FXML
    private JFXButton garbage_idea_button;
    
    @FXML
    private JFXButton check_idea_button1;

    @FXML
    private ImageView unchecked_icon;
    @FXML
    private ImageView checked_icon;
    @FXML
    public JFXListView<Idee> public_Ideas_list_view;
    @FXML
    private Label username;

    private int state = 0;

    public OneIdeasFXMLController(int state) {
        this.state = state;
    }

    /**
     * Initializes the controller class.
     *
     * @param Idee
     * @param empty
     */
    @Override
    protected void updateItem(Idee Ideas, boolean empty) {
        super.updateItem(Ideas, empty);
        if (empty || Ideas == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("../gui/oneIdeaFXML.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            IIdeeService I_tool = new IdeeService();
            IUserService U_Tool = new UserService();
            idea_title.setText(Ideas.getTitre());
            idea_domaine.setText(Ideas.getDomaine());
            idea_description.setText(Ideas.getDescription());
            idea_price.setText(Ideas.getPrix() + "$");
            
            if (state == 1) {//this shows private ideas

                if (Ideas.getEtat().equals("NON")) {
                    unchecked_icon.setVisible(true);
                    checked_icon.setVisible(false);
                    edit_idea_button.setVisible(true);
                    
                    System.out.println("unchecked");
                } else if (Ideas.getEtat().equals("OK")) {
                    unchecked_icon.setVisible(false);
                    checked_icon.setVisible(true);
                    System.out.println("checked");
                    edit_idea_button.setVisible(false);
                }
                System.out.println("YEEEEES I AM IN MY IDEAS");
                
                garbage_idea_button.setVisible(true);
                check_idea_button1.setVisible(false);
                username.setVisible(false);

            } else if (state == 0) {//this shows public ideas
                unchecked_icon.setVisible(false);
                checked_icon.setVisible(false);
                System.out.println("NOOO I AM IN ALL IDEAS");
                edit_idea_button.setVisible(false);
                garbage_idea_button.setVisible(false);
                check_idea_button1.setVisible(false);
                username.setVisible(false);
                
            }else if(state==2){//this shows unchecked ideas to the Admin
                unchecked_icon.setVisible(false);
                checked_icon.setVisible(false);
                System.out.println("NOOO I AM IN ALL IDEAS");
                edit_idea_button.setVisible(false);
                unchecked_icon.setVisible(false);
                checked_icon.setVisible(false);
                username.setVisible(true);
                username.setText(U_Tool.getUserById(Ideas.getUser_id()).getUsername());
            }
            setText(null);
            setGraphic(row);
            
            
            
            garbage_idea_button.setOnAction(event -> {
                I_tool.delete(Ideas.getId());
                System.out.println("DELLEEETING the IDEA ");
                getListView().getItems().remove(Ideas);
                getListView().refresh();

            });

            edit_idea_button.setOnAction(event -> {
                FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/gui/IdeesFXML.fxml"));
                try {
                    Parent root = (Parent) fXMLLoader.load();
                    IdeesFXMLController dialogueLayoutController = fXMLLoader.<IdeesFXMLController>getController();
                    dialogueLayoutController.EditIdea(Ideas);
                    dialogueLayoutController.ideat_titre.setText("fifo");
                    dialogueLayoutController.User_name.setText("eded");
                    System.out.println("yeah I am going to edit it");
                    getListView().setVisible(false);
                   
                } catch (IOException ex) {
                    Logger.getLogger(OneIdeasFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            
            check_idea_button1.setOnAction(event -> {
                I_tool.check(Ideas.getId());
                System.out.println("CHecking the IDEA ");
                getListView().getItems().remove(Ideas);
                getListView().refresh();

            });

        }

    }

    @FXML
    private void delete_idea_btn(ActionEvent event) {

    }
}
