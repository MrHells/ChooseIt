/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import databases.userDAO;
import java.sql.SQLException;
import users.User;

/**
 *
 * @author Emili
 */
public class Register {
    private static final int nameMax = 3;
    private static final int nicknameMax = 16;
    private static final int nicknameMin = 3;
    public static void registerUser(String Nickname, String name, String password) throws SQLException{
        if(testText(Nickname, nicknameMin, nicknameMax)){
            
        }
        
        //userDAO.saveUser(new User(Nickname, name, password));
    }
    public static boolean testText(String text, int minCharacter, int maxCharacter){
        testEspecialCharacteres(text);
        return text.length() < maxCharacter &&  text.length() > minCharacter;
    }
    
    public static boolean testEspecialCharacteres(String text){
        String[] arrayText = text.split("", 1);
        for(String string : arrayText){
            System.out.println(string);
            System.out.println("h");
        }
        return false;
    }
}
