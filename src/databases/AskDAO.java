/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Ask.Ask;
import users.User;

/**
 *
 * @author fhill
 */
public class AskDAO {
    private static Connection con = null;
    
     public void save_answer_yes() throws SQLException{
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
    
    public void save_answer_no() throws SQLException{
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
    

    public static void saveAsk(Ask ask) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO ask(statement, conditions, yesQuant, notQuant, id_creator) VALUES (?,?,?,?,?)";
        System.out.println("a");
        PreparedStatement stmt = null;
        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);
            stmt.setString(1, ask.getStatement());
            stmt.setString(2, ask.getConditions());
            stmt.setInt(3, 0);
            stmt.setInt(4, 0);
            stmt.setInt(5, ask.getIdCreator());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }   
    }
    
    public String buscarUsuarios(String Nickname, String Pass) {
        String sql = "SELECT nickname, name, idUser, Password FROM chooseit_database.user WHERE Nickname = '"+Nickname+"' and Password ='"+Pass+"'";
        try {
            con = (new ConnectionFactory()).getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                String tipo = rs.getString("Name");
                tipo += " | " + rs.getString("Nickname");
                tipo += " | " + rs.getString("idUser");
                return tipo;
            }

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
        return null;
    }
    
    public static boolean verifyExistence(String Nickname) throws SQLException{
        String sql = "SELECT Nickname FROM chooseit_database.user WHERE Nickname = '"+Nickname+"'";
        boolean r = false;
        try {
            con = (new ConnectionFactory()).getConnection();
        } catch (SQLException ex) {
             System.err.println("Erro " + ex);
        }
        
        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){ 
                System.out.println("I");
                return true;
            }
            
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return r;
    }

}
