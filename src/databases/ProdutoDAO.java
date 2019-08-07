/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import users.User;

/**
 *
 * @author fhill
 */
public class ProdutoDAO {
  /* public void create(User user){
      Connection con = ConnectionFactory.getConnection();
      PreparedStatement stmt = null;
      try{
          stmt = con.prepareStatement("INSERT INTO user (Nickname, Senha) VALUES (?,?); ");
          
          stmt.setString(1, user.getName());
          stmt.setString(1, user.getAge());
          
      }catch (SQLException ex){
          Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
        
    }*/
}
