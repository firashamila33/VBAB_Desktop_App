/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXListView;
import interfaces.IIdeeService;
import interfaces.IUserService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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

    }

    

    @FXML
    private void show_all_ideas(ActionEvent event) {
        public_Ideas_list_view.setVisible(true);
        public_Ideas_list_view_me.setVisible(false);

    }

    @FXML
    private void show_my_ideas(ActionEvent event) {
        public_Ideas_list_view.setVisible(false);
        public_Ideas_list_view_me.setVisible(true);
    }

}
