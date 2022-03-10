package com.example.personalcalendarbackend.Controller;

import com.example.personalcalendarbackend.Entity.DictRole;
import com.example.personalcalendarbackend.Service.DictRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final DictRoleService dictRoleService;

    @GetMapping("/getRole")
    public DictRole getRole(){
        //todo enable security and do real
        return dictRoleService.getRoleByName("consumer");
    }
}
