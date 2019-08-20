/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package users;

import java.io.Serializable;

/**
 *
 * @author Emili
 */
public class User implements Serializable {
    private String Nickname;
    private String name;
    private String password;
    private int id;
    public User(String Nickname, String name, String password, int id) {
        this.Nickname = Nickname;
        this.name = name;
        this.password = password;
        this.id = id;
    }
    public User(String Nickname, String name, String password) {
        this.Nickname = Nickname;
        this.name = name;
        this.password = password;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String Nickname) {
        this.Nickname = Nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
