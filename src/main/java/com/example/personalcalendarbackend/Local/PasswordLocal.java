package com.example.personalcalendarbackend.Local;

import com.example.personalcalendarbackend.Entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PasswordLocal {

    private Long userRef;

    private String password;

    public PasswordLocal(User user, String password){

        userRef = user.getId();
        this.password = password;
    }
}
