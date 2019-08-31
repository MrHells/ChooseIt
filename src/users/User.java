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
    private int id;
    private int numberOfAnswers;
    public User(String Nickname, String name) {
        this.Nickname = Nickname;
        this.name = name;
    }
    public User(String Nickname, String name, int id, int numberOfAnswers) {
        this.Nickname = Nickname;
        this.name = name;
        this.id = id;
        System.out.println(id);
        this.numberOfAnswers = numberOfAnswers;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfAnswers() {
        return numberOfAnswers;
    }

    public void setNumberOfAnswers(int numberOfAnswers) {
        this.numberOfAnswers = numberOfAnswers;
    }

    @Override
    public String toString() {
        return "User{" + "Nickname=" + Nickname + ", name=" + name + ", id=" + id + ", numberOfAnswers=" + numberOfAnswers + '}';
    }
    
}
