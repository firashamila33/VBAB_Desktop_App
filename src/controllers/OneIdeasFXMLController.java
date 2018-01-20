/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import interfaces.IIdeeService;
import models.Idee;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import services.IdeeService;

/**
 * FXML Controller class
 *
 * @author plazma33
 */
public class OneIdeasFXMLController extends ListCell<Idee> {

    @FXML
    private ImageView meal_image;
    @FXML
    private Label type_row_commande;
    @FXML
    private Label name_row_commande;
    @FXML
    private Label price_row_commande;
    @FXML
    private Label quantity;
    private FXMLLoader mLLoader;

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
                mLLoader = new FXMLLoader(getClass().getResource("/gui/oneIdeasFXML.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        IIdeeService I_tool = new IdeeService();
        name_row_commande.setText(Ideas.getTitre());

    }
}
