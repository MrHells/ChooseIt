/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import users.User;

/**
 *
 * @author Emili
 */
public class Login {
    public static User tryLogin(String senha, String userIdentification){
        User bufferUser;
        
        bufferUser = Archive.read("users");
        if(bufferUser.getName().equals(senha)){
            return bufferUser;
        }
        
        return null;
    }
}
