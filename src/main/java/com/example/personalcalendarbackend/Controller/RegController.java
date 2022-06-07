package com.example.personalcalendarbackend.Controller;

import com.example.personalcalendarbackend.Entity.SysUser;
import com.example.personalcalendarbackend.Local.RegLocal;
import com.example.personalcalendarbackend.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegController {
    private final UserService userService;
    @PostMapping
    public void registration(@RequestBody RegLocal local){
        userService.saveUserWithEncode(new SysUser(local.getUsername(), local.getPassword()));
    }
}
