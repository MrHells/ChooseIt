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
 * @author Fhill
 */
public class Login {
    public static User tryLogin(String senha, String Nickname){
        UserDAO u = new UserDAO();
        String[] a = u.buscarUsuarios(Nickname, senha);

        return new User(Nickname, a[0], Integer.parseInt(a[2]), Integer.parseInt(a[3]));
    }
}