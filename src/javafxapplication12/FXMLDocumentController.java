/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication12;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author PIATOVA
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button МАГАЗИН;
    @FXML
    private Button УЧЕТ;
    @FXML
    private Button ТОВАРЫ;
    @FXML
    private Button ПРОДАВЦЫ;
    @FXML
    private Button ВЫХОД;
    @FXML
    private Button ПРОДАЖА;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlButtonAction(ActionEvent event) {
    }
    
}
