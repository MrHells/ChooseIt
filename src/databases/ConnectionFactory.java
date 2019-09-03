/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fhill
 */
public class ConnectionFactory {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL =  "jdbc:mysql://localhost:3306/chooseit_database?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "pass123";
        
    public static Connection getConnection() throws SQLException{
        
        try {
            Class.forName(DRIVER);
            
            return DriverManager.getConnection(URL, USER, PASS);
            
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException("Erro na conexão", ex);
        }
    }
    
    public static void closeConnection (Connection com){
        if(com != null){
            try {
                com.close();
            } catch (SQLException ex) {
                System.err.println("Erro "+ex);
            }
        }      
    }
public static void closeConnection (Connection com, PreparedStatement stmt) throws SQLException{
        if(stmt != null){
            stmt.close();
        }
        closeConnection(com);
    }
public static void closeConnection (Connection com, PreparedStatement stmt, ResultSet rs) throws SQLException{
        System.out.println("SA");
    if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
                System.err.println("Erro "+ex);
            }
        }
        closeConnection(com, stmt);
    }
}
