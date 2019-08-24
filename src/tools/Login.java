/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import databases.UserDAO;
import users.User;

/**
 *
 * @author Emili
 */
public class Login {
    public static User tryLogin(String senha, String Nickname){
        
        UserDAO u = new UserDAO();
        
        String a = u.buscarUsuarios(Nickname, senha);
        
        System.out.println(a);
        
        return new User(Nickname, senha, a, 0);
    }
}