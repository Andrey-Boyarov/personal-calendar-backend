package com.example.personalcalendarbackend.Service;

import com.example.personalcalendarbackend.Entity.SysUser;
import com.example.personalcalendarbackend.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CurUserService {

    private final UserRepository userRepository;

    public SysUser getCurrentUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return userRepository.findByLoginAndIsRelevantTrue(username).orElse(null);
    }

    public Optional<SysUser> getCurrentUserOpt(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return userRepository.findByLoginAndIsRelevantTrue(username);
    }
}
