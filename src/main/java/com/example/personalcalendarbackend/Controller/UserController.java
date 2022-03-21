package com.example.personalcalendarbackend.Controller;

import com.example.personalcalendarbackend.Entity.DictRole;
import com.example.personalcalendarbackend.Local.PasswordLocal;
import com.example.personalcalendarbackend.Local.UserLocal;
import com.example.personalcalendarbackend.Service.DictRoleService;
import com.example.personalcalendarbackend.Service.PasswordService;
import com.example.personalcalendarbackend.Service.SubscriptionService;
import com.example.personalcalendarbackend.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final DictRoleService dictRoleService;
    private final UserService userService;
    private final PasswordService passwordService;
    private final SubscriptionService subscriptionService;

    @GetMapping("/getRole")
    public DictRole getRole(){
        //todo enable security and do real
        return dictRoleService.getRoleByName("consumer");
    }

    @GetMapping("/getUserById/{id}")
    public UserLocal getUserById(@PathVariable Long id){

        return userService.getUserLocalById(id);
    }

    @PostMapping("/setNewPassword")
    public Boolean setNewPassword(@RequestBody PasswordLocal local){

        return passwordService.createPassword(local);
    }

    @GetMapping("/getSubscriptionsAsString/{id}")
    public String getSubscriptionsAsString(@PathVariable Long id){

        return subscriptionService.getSubscriptionsAsString(id);
    }
}
