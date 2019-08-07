/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

/**
 *
 * @author Emili
 */
public class AdmUser extends User {
    private String email;
    
    public AdmUser(String Nickname, String name, String password) {
        super(Nickname, name, password);
    }
    
}
