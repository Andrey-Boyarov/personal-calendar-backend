package com.example.personalcalendarbackend.Controller;

import com.example.personalcalendarbackend.Auth.AuthService;
import com.example.personalcalendarbackend.Entity.DictRole;
import com.example.personalcalendarbackend.Entity.SysUser;
import com.example.personalcalendarbackend.Local.PasswordLocal;
import com.example.personalcalendarbackend.Local.UserItemPojo;
import com.example.personalcalendarbackend.Local.UserLocal;
import com.example.personalcalendarbackend.Service.CurUserService;
import com.example.personalcalendarbackend.Service.DictRoleService;
import com.example.personalcalendarbackend.Service.SubscriptionService;
import com.example.personalcalendarbackend.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final DictRoleService dictRoleService;
    private final UserService userService;
    private final SubscriptionService subscriptionService;
    private final AuthService authService;
    private final CurUserService curUserService;

    @GetMapping("/getRoles")
    public List<String> getRoles(){
        return curUserService.getCurrentUser().getRoles().stream().map(DictRole::getName).collect(Collectors.toList());
    }

    @GetMapping("/getAllUsers")
    public List<UserItemPojo> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/delete/{userId}")
    public boolean deleteUser(@PathVariable Long userId){
        return userService.deleteUser(userId);
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
}
