/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import databases.UserDAO;
import java.sql.SQLException;
import static tools.AlertSpawnOnly.create_alert;
import users.User;

/**
 *
 * @author Fhill
 */
public class Register {
    private static final int NAME_MAX = 20;
    private static final int NAME_MIN = 3;
    private static final int NICKNAME_MAX = 16;
    private static final int NICKNAME_MIN = 3;
    
    public static void registerUser(String Nickname, String name, String password) throws SQLException{
        UserDAO u = new UserDAO();
        if(testText(Nickname, NICKNAME_MIN, NICKNAME_MAX) && testText(name, NAME_MIN, NAME_MAX)){
            if(!UserDAO.verifyExistence(Nickname)){
                System.out.println("yeah");
                UserDAO.saveUser(new User(Nickname, name), password);
                create_alert("YOW", name + " are a pretty name...", "Successfully Registered");
            }else{
                create_alert("This NICK?", "Someone already use this nickname.", "Try another nickname.");
            }
        }else{
            create_alert("Oh no", "Too much character, or too less characters.", "Try changing");
        }
    }
    public static boolean testText(String text, int minCharacter, int maxCharacter){
        if(!testEspecialCharacteres(text)){
            create_alert("Not suitable", "Some text may have some not good characters.", "Especial characteres detected!");
            return false;
        }
        return text.length() <= maxCharacter &&  text.length() >= minCharacter;
    }

    public static boolean testEspecialCharacteres(String text){
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == '_'){
                continue;
            }else if(Character.isLetter(text.charAt(i)) || Character.isDigit(text.charAt(i))){
                continue;
            }
            return false;
        }
        return true;
    }
}
