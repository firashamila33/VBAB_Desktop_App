/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import interfaces.IUserService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.User;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author plazma33
 */
public class LoginFXMLController implements Initializable {

    @FXML
    private JFXTextField username_idee;
    @FXML
    private JFXPasswordField mot_de_passe_idee;
    
    Stage stage;
    Parent root;
    @FXML
    private JFXButton login;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login_ideas_btn(ActionEvent event) throws IOException {
        
        if (username_idee.getText() != null && mot_de_passe_idee.getText() != null) {

            IUserService U_Tools = new UserService();
            User us = new User();
            us = U_Tools.Login_User(username_idee.getText(), mot_de_passe_idee.getText());
            if (us == null) {
                System.out.println("données invalides");
            } else {
                System.out.println("Bienvenue a l'espace idees");

                User.static_user = us;
                
                System.out.println(User.static_user); 
                
                stage = (Stage) login.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/gui/IdeesFXML.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.setResizable(true);
                stage.show();
            }

        }
    }
    
}
