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
        String statement = find_statement();
        btnStatement.setText(statement); 
    }
    
    public void place_condition() throws SQLException{
        String condition = find_condition();
        btnCondition.setText(condition);
    }

    public static String find_statement() throws SQLException{
         String sql = "SELECT statement FROM chooseit_database.ask ";
        try {
             con = ConnectionFactory.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                String tipo = rs.getString("statement");
                return tipo;
            }

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
      return null;
    }
    
    public static String find_condition() throws SQLException{
         String sql = "SELECT conditions FROM chooseit_database.ask ";
        try {
             con = ConnectionFactory.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                String tipo = rs.getString("conditions");
                return tipo;
            }

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
      return null;
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
            save_answer_yes();
        }else {
            save_answer_no();
        }
    }
    
    private void save_answer_yes() throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        String sql =    "UPDATE ask \n" +
                        "SET yesQuant = yesQuant + 1\n" +
                        "WHERE idAsk = 1;";
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    private void save_answer_no() throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        String sql =    "UPDATE ask \n" +
                        "SET notQuant = notQuant + 1\n" +
                        "WHERE idAsk = 1;";
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}

