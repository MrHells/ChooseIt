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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import users.User;

/**
 *
 * @author tecnica
 */
public class userDAO {

    private static Connection con = null;

    public static void saveUser(User user) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO user (Nickname, Name, Password) VALUES (?,?,?)";
        
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, user.getNickname() );
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }

    public String buscarUsuarios(String Nickname, String Pass) {
        String sql = "SELECT Nickname, Name, id_user, Password FROM chooseit_database.user WHERE Nickname = '"+Nickname+"' and Password ='"+ Pass+"'";
        try {
            con = (new ConnectionFactory()).getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                String tipo = rs.getString("Name");
                tipo += " | " + rs.getString("Nickname");
                tipo += " | " + rs.getString("id_user");
                return tipo;
            }

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
        return null;
    }
    
    public static boolean verifyExistence(String Nickname) throws SQLException{
        String sql = "SELECT Nickname Password FROM chooseit_database.user WHERE Nickname = '"+Nickname+"'";
        try {
            con = (new ConnectionFactory()).getConnection();
        } catch (SQLException ex) {
             System.err.println("Erro " + ex);
        }
        
        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs);
            System.out.println(rs.getString("Nickname"));
            if(rs == null){
                return false;
            }

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        }
        return true;
    }
}
