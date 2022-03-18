package com.example.personalcalendarbackend.Controller;

import com.example.personalcalendarbackend.Entity.DictRole;
import com.example.personalcalendarbackend.Entity.User;
import com.example.personalcalendarbackend.Local.UserLocal;
import com.example.personalcalendarbackend.Service.DictRoleService;
import com.example.personalcalendarbackend.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final DictRoleService dictRoleService;
    private final UserService userService;

    @GetMapping("/getRole")
    public DictRole getRole(){
        //todo enable security and do real
        return dictRoleService.getRoleByName("consumer");
    }

    @GetMapping("/getUserById/{id}")
    public UserLocal getUserById(@PathVariable Long id){

        return userService.getUserById(id);
    }
}
