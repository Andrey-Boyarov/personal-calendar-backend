package com.example.personalcalendarbackend.Controller;

import com.example.personalcalendarbackend.Entity.Role;
import com.example.personalcalendarbackend.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final RoleService roleService;

    @GetMapping("/getRole")
    public Role getRole(){
        //todo enable security and do real
        return roleService.getRoleByName("consumer");
    }
}
