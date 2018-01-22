/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;


import com.jfoenix.controls.JFXButton;
import interfaces.IIdeeService;
import models.Idee;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import services.IdeeService;

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
    private Label idea_domaine ;
    @FXML
    private Label idea_description ;  
    @FXML
    private Label idea_price ;
    @FXML
    private AnchorPane row;
    private FXMLLoader mLLoader;
    @FXML
    private JFXButton edit_idea_button;
    @FXML
    private JFXButton garbage_idea_button;
    
    @FXML
    private ImageView unchecked_icon;
    @FXML
    private ImageView checked_icon;
    
    private   int state=0;

    public OneIdeasFXMLController(int state) {
        this.state=state;
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
        idea_title.setText(Ideas.getTitre());
        idea_domaine.setText(Ideas.getDomaine());
        idea_description.setText(Ideas.getDescription());
        idea_price.setText(Ideas.getPrix()+"$");
        
        
        if(state==1){//this shows private ideas
            
            if(Ideas.getEtat().equals("NON")){
                unchecked_icon.setVisible(true);
                checked_icon.setVisible(false);
                System.out.println("unchecked");
            }else if(Ideas.getEtat().equals("OK")){
                unchecked_icon.setVisible(false);
                checked_icon.setVisible(true);
                System.out.println("checked");
            }
            System.out.println("YEEEEES I AM IN MY IDEAS");
            edit_idea_button.setVisible(true);
            garbage_idea_button.setVisible(true);
            
        
        }else if(state==0){//this shows public ideas
            unchecked_icon.setVisible(false);
            checked_icon.setVisible(false);
            System.out.println("NOOO I AM IN ALL IDEAS");
            edit_idea_button.setVisible(false);
            garbage_idea_button.setVisible(false);
        }
        setText(null);
        setGraphic(row);
        }
    }
}
