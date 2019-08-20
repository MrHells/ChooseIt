/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import databases.userDAO;
import users.User;

/**
 *
 * @author Emili
 */
public class Login {
    public static User tryLogin(String senha, String Nickname){
        
        userDAO u = new userDAO();
        String a = u.buscarUsuarios(Nickname, senha);
        
        System.out.println(a);
        
        return new User(Nickname, senha, a, 0);
    }
}