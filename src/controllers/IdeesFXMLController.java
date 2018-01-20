/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.jfoenix.controls.JFXListView;
import interfaces.IIdeeService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import models.Idee;
import services.IdeeService;

/**
 * FXML Controller class
 *
 * @author plazma33
 */
public class IdeesFXMLController implements Initializable {

    @FXML
    public JFXListView<Idee> public_Ideas_list_view;
    private ObservableList<Idee> Idees_list;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        IIdeeService I_tool= new IdeeService();
        
        Idees_list = FXCollections.observableArrayList(I_tool.getAll());
        public_Ideas_list_view.setItems(Idees_list);
        public_Ideas_list_view.setCellFactory(f -> new OneIdeasFXMLController());

    }    
    
}
