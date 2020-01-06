/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication12;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author PIATOVA
 */
public class Menu1Controller implements Initializable {

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
   
                      /**
           Переход к таблице
 */
                      if (event.getSource()==МАГАЗИН){
           try {
               МАГАЗИН.getScene().getWindow().hide();
               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("magazin.fxml"));
               Parent root1 = (Parent) fxmlLoader.load();
               Stage stage = new Stage();
               stage.initModality(Modality.APPLICATION_MODAL);
               stage.initStyle(StageStyle.UNDECORATED);
               stage.setTitle("МАГАЗИН");
               stage.setScene(new Scene(root1));
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
           }
     }
                   /**
           Переход к таблице
 */
     if (event.getSource()==УЧЕТ){
           try {
               УЧЕТ.getScene().getWindow().hide();
               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("uchet.fxml"));
               Parent root1 = (Parent) fxmlLoader.load();
               Stage stage = new Stage();
               stage.initModality(Modality.APPLICATION_MODAL);
               stage.initStyle(StageStyle.UNDECORATED);
               stage.setTitle("УЧЕТ");
               stage.setScene(new Scene(root1));
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
           }
     }
                   /**
           Переход к таблице
 */
     if (event.getSource()==ТОВАРЫ){
           try {
               ТОВАРЫ.getScene().getWindow().hide();
               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tovary.fxml"));
               Parent root1 = (Parent) fxmlLoader.load();
               Stage stage = new Stage();
               stage.initModality(Modality.APPLICATION_MODAL);
               stage.initStyle(StageStyle.UNDECORATED);
               stage.setTitle("ТОВАРЫ");
               stage.setScene(new Scene(root1));
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
           }
     }
                   /**
           Переход к таблице
 */
     if (event.getSource()==ПРОДАВЦЫ){
           try {
               ПРОДАВЦЫ.getScene().getWindow().hide();
               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("prodavci.fxml"));
               Parent root1 = (Parent) fxmlLoader.load();
               Stage stage = new Stage();
               stage.initModality(Modality.APPLICATION_MODAL);
               stage.initStyle(StageStyle.UNDECORATED);
               stage.setTitle("ПРОДАВЦЫ");
               stage.setScene(new Scene(root1));
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
           }
     }
             /**
Кнопка выход
 */
     if (event.getSource()==ВЫХОД){
          Platform.exit();
     }
                    /**
           Переход к таблице
 */
     if (event.getSource()==ПРОДАЖА){
           try {
               ПРОДАЖА.getScene().getWindow().hide();
               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("prodazha.fxml"));
               Parent root1 = (Parent) fxmlLoader.load();
               Stage stage = new Stage();
               stage.initModality(Modality.APPLICATION_MODAL);
               stage.initStyle(StageStyle.UNDECORATED);
               stage.setTitle("ПРОДАЖА");
               stage.setScene(new Scene(root1));
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
           }
     }
     
     }
    
    
    
    
    }
    

