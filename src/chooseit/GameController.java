/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chooseit;

import databases.ConnectionFactory;
import databases.UserDAO;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import static chooseit.ChooseIt.askDao;

/**
 * FXML Controller class
 *
 * @author fhill
 */
public class GameController implements Initializable {

    @FXML
    private Circle btnChoose;
    private static Connection con = null;
    @FXML
    private TextField btnStatement;
    @FXML
    private TextField btnCondition;
    @FXML
    private Button btnNot;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            place_statement();
            place_condition();
            
        } catch (SQLException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    public void place_statement() throws SQLException{
        String statement = askDao.find_statement();
        btnStatement.setText(statement); 
    }
    
    public void place_condition() throws SQLException{
        String condition = askDao.find_condition();
        btnCondition.setText(condition);
    }

    @FXML
    private void btnChoose_clicked(MouseEvent event) throws SQLException {
        boolean button_clicked = true;
        save_answer(button_clicked);
    }
    
    @FXML
    private void btnNot_clicked(ActionEvent event) throws SQLException {
        boolean button_clicked = false;
        save_answer(button_clicked);
    }
    
     public void save_answer(boolean button_pressed) throws SQLException{
        if (button_pressed){
            askDao.save_answer_yes();
        }else {
            askDao.save_answer_no();
        }
    }
    
   
}

