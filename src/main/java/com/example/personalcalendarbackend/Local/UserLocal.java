package com.example.personalcalendarbackend.Local;

import com.example.personalcalendarbackend.Entity.DictRole;
import com.example.personalcalendarbackend.Entity.SysUser;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserLocal {

    private final String login;

    private final List<String> roles;

    private final String mail;


    public UserLocal(SysUser sysUser){
        login = sysUser.getLogin();
        roles = sysUser.getRoles().stream().map(DictRole::getName).collect(Collectors.toList());
        mail = sysUser.getMailAddress();
    }
}
