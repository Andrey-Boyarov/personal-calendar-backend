package com.example.personalcalendarbackend.Local;

import com.example.personalcalendarbackend.Entity.SysUser;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PasswordLocal {

    private Long userRef;

    private String password;

    public PasswordLocal(SysUser sysUser, String password){

        userRef = sysUser.getId();
        this.password = password;
    }
}
