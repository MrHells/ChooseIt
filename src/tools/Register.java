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
public class Register {
    public static void registerUser(String name, String age){
        Archive.write(new User(name, age), "users");
    }
}
