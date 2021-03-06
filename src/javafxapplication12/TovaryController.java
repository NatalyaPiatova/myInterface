/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication12;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author PIATOVA
 */
public class TovaryController implements Initializable {
     private static final  String url = "jdbc:mysql://mysql-162551.srv.hoster.ru/srv162551_new";
        private static  String user = "srv162551_root1";      
    private static final String password = "password1";
    
    private static Connection con;
    private static Statement stmt;
    static ResultSet rs;
    private TextField Цена;
    @FXML
    private TextField Название;
    @FXML
    private TextField Колво;
    @FXML
    private Button ADD;
    @FXML
    private Button EXIT;
    @FXML
    private TextField Дата;
    @FXML
    private Button Delete;
    @FXML
    private Button Back;
    @FXML
    private TextField ИД;
     public void executeQuery(String query) {
    	Connection conn = getConnection();
    	Statement st;
    	try {
			st = conn.createStatement();
			st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
      public Connection getConnection() {
    	Connection conn;
    	try {
    		conn = DriverManager.getConnection(url,user,password);
    		return conn;
    	}
    	catch (Exception e){
    		e.printStackTrace();
    		return null;
    	}
    }

    @FXML
    private Button Output2;
    @FXML
    private TextArea Out;

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
           *Кнопка Добавить
 */
        if (event.getSource()==ADD){
       String query = "insert into TOVARY values("+ИД.getText()+",'"+Название.getText()+"','"+Колво.getText()+"','"+Дата.getText()+"')";
       executeQuery(query);
   } 
                       /**
           *Кнопка Просмотр
 */
        
           if (event.getSource()==Output2){
       String query = "SELECT * From TOVARY" ;
    try{   Connection con = DriverManager.getConnection(url,user,password);
        Statement stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery(query);
           Out.setText(null);
      while (rs.next()) {
                    
                    Out.appendText("ИД= "+rs.getString(1)+", Название товара= "+rs.getString(2)+", Кол-во= "+rs.getString(3)+", Дата поставки= "+rs.getString(4)+"\n");
                    Out.setEditable(false);
                }
      
    } 
    catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            } 
            }
                       /**
Кнопка Удалить
 */
           if (event.getSource() == Delete) {
            String query = "DELETE FROM TOVARY WHERE PRICE_ID=" + ИД.getText() + "";
            executeQuery(query);
        }
                      /**
Кнопка вернуться
 */
            if (event.getSource() == Back) {
             try {
               Back.getScene().getWindow().hide();
               FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu1.fxml"));
               Parent root2 = (Parent) fxmlLoader.load();
               Stage stage = new Stage();
               stage.initModality(Modality.APPLICATION_MODAL);
               stage.initStyle(StageStyle.UNDECORATED);
               stage.setTitle("Меню");
               stage.setScene(new Scene(root2));
               stage.show();
           } catch (IOException ex) {
               Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
           }
            }
                    /**
Кнопка выход
 */
     if (event.getSource()==EXIT){
        
                         Platform.exit();
        
        
    }    
    
    
}}
