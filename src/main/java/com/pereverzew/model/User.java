package com.pereverzew.model;

import lombok.Data;

@Data
public class User implements Comparable{
    private String login;
    private String password;
    private String info;

    public User(String login) {
        this.login = login;
    }

    public int compareTo(Object o) {
        if (this==o){return 0;}
        if (!(o instanceof User)) {return -1;}
        User user= (User) o;
        return this.getLogin().compareTo(user.getLogin());
    }
}
