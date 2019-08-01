/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fhill
 */
public class ConectionMaker {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/chooseit_database?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "pass123";
 
    public static Connection getConexao() throws SQLException {
        try {
            Class.forName(DRIVER);
            System.out.println("Conectando ao banco.");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public static void closeConnection(Connection conection){
        try {
            if(conection != null){
                conection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConectionMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection conection, PreparedStatement stmt){
        closeConnection(conection);
        try {
            if(stmt != null){
                stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConectionMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnection(Connection conection, PreparedStatement stmt, ResultSet rs){
        closeConnection(conection, stmt);
        try {
            if(rs != null){
                rs.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConectionMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
