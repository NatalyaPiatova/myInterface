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
public class MagazinController implements Initializable {
    /**
подключение
 */
       private static final  String url = "jdbc:mysql://mysql-162551.srv.hoster.ru/srv162551_new";
        private static  String user = "srv162551_root1";      
    private static final String password = "password1";
    
    private static Connection con;
    private static Statement stmt;
    static ResultSet rs;
  /**
Инизиализируем переменные
 */
    @FXML
    private Button ADD;
    @FXML
    private Button EXIT;
    @FXML
    private TextField ИД;
    @FXML
    private TextField ИДП;
    @FXML
    private TextField ИДО;
    @FXML
    private TextField ИДТ;
    @FXML
    private TextField ИДПР;
    @FXML
    private Button Delete;
    @FXML
    private Button Back;
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
    private Button Output5;
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
       String query = "insert into MAGAZIN values("+ИД.getText()+","+ИДП.getText()+","+ИДО.getText()+","+ИДТ.getText()+","+ИДПР.getText()+")";
       executeQuery(query);
   } 
            /**
формирование запрося для отображения связи таблицы, при выводе в таблице МАГАЗИН вместо цифрового значения продавца , будет выводить его ФИО
*/         
            if (event.getSource()==Output5){
       String query = "SELECT MAGAZIN.ID,MAGAZIN.TOVAR_ID,MAGAZIN.SELL_ID,MAGAZIN.PRICE_ID,PRODAVZI.`FIO` as `SELLER_ID` FROM MAGAZIN INNER JOIN PRODAVZI ON (MAGAZIN.`SELLER_ID`= PRODAVZI.`SELLER_ID`)";  
    try{   Connection con = DriverManager.getConnection(url,user,password);
        Statement stmt = con.createStatement();
           ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
                    
                    Out.appendText("ИД= "+rs.getString(1)+", Продажа= "+rs.getString(2)+", Организации= "+rs.getString(3)+", Товар= "+rs.getString(4)+", Продавец = "+rs.getString(5)+"\n");
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
            String query = "DELETE FROM MAGAZIN WHERE ID=" + ИД.getText() + "";
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
        
        
    }
    
}
