package com.example.personalcalendarbackend.Local;

import com.example.personalcalendarbackend.Entity.User;
import lombok.Getter;

@Getter
public class UserLocal {

    private String login;

    private String role;

    private String mail;


    public UserLocal(User user){
        login = user.getLogin();
        role = user.getRole().getDescription();
        mail = user.getMailAddress();
    }
}
