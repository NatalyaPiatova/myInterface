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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author PIATOVA
 */
public class FXMLController implements Initializable {

    @FXML
    private Button FXML;
      @FXML
    private TextField Логин;
       @FXML
    private TextField Пароль;

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
 Создаем условие, чтобы создать авторизацию
 */
    String lg= Логин.getText();
    String pw= Пароль.getText();
    String l="Natasha";
    String p="23082000";
        if (event.getSource()==FXML){
       if ((lg.equals(l))&&(pw.equals(p))) {
           try {
               FXML.getScene().getWindow().hide();
               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu1.fxml"));
               Parent root1 = (Parent) fxmlLoader.load();
               Stage stage = new Stage();
               stage.initModality(Modality.APPLICATION_MODAL);
               stage.initStyle(StageStyle.UNDECORATED);
               stage.setTitle("ABC");
               stage.setScene(new Scene(root1));
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
           }
        
   } else {
           
 Логин.setText("Повторите ввод");
 Пароль.setText("Повторите ввод");
  
   }
    
    
    }
    
}
}