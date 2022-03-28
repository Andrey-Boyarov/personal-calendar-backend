package com.example.personalcalendarbackend.Controller;

import com.example.personalcalendarbackend.Auth.AuthService;
import com.example.personalcalendarbackend.Entity.DictRole;
import com.example.personalcalendarbackend.Entity.SysUser;
import com.example.personalcalendarbackend.Local.PasswordLocal;
import com.example.personalcalendarbackend.Local.UserLocal;
import com.example.personalcalendarbackend.Service.DictRoleService;
import com.example.personalcalendarbackend.Service.SubscriptionService;
import com.example.personalcalendarbackend.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final DictRoleService dictRoleService;
    private final UserService userService;
    private final SubscriptionService subscriptionService;
    private final AuthService authService;

    @GetMapping("/getRole")
    public DictRole getRole(){
        //todo enable security and do real
        return dictRoleService.getRoleByName("consumer");
    }

    @GetMapping("/refreshtoken")
    public void refreshtoken(HttpServletRequest request, HttpServletResponse response){
        authService.refreshtoken(request, response);
    }

    @GetMapping("/getUserById/{id}")
    public UserLocal getUserById(@PathVariable Long id){

        return userService.getUserLocalById(id);
    }

    @GetMapping("/getSubscriptionsAsString/{id}")
    public String getSubscriptionsAsString(@PathVariable Long id){

        return subscriptionService.getSubscriptionsAsString(id);
    }

    @GetMapping("/c")
    public void c (){
        SysUser user = userService.getUserById(1L);
        user.setPassword("root");
        userService.saveUserWithEncode(user);
    }
}
