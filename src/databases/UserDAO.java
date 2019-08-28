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
import users.User;

/**
 *
 * @author fhill
 */
public class UserDAO {

    private static Connection con = null;

    public static void saveUser(User user, String password) throws SQLException {
        Connection con = ConnectionFactory.getConnection();
        String sql = "INSERT INTO user (nickname, name, password, how_much_answered) VALUES (?,?,?,?)";
        System.out.println("a");
        PreparedStatement stmt = null;

        try {
            stmt = (PreparedStatement) con.prepareStatement(sql);

            stmt.setString(1, user.getNickname() );
            stmt.setString(2, user.getName());
            stmt.setString(3, password);
            stmt.setInt(4, 0);
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }   
    }
    public String[] buscarUsuarios(String Nickname, String Pass) {
        String sql = "SELECT nickname, name, idUser, Password FROM chooseit_database.user WHERE Nickname = '"+Nickname+"' and Password ='"+Pass+"'";
        try {
            con = (new ConnectionFactory()).getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                String[] data = new String[4];
                data[0] = rs.getString("name");
                data[1] = rs.getString("nickname");
                data[2] = rs.getString("idUser");
                data[3] = rs.getString("how_much_answered");
                
                return data;
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