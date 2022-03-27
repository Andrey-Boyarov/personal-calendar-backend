package com.example.personalcalendarbackend.Auth;

import com.example.personalcalendarbackend.Entity.SysUser;
import com.example.personalcalendarbackend.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository
                .findByLoginAndIsRelevantTrue(username)
                .map(user ->  new User(user.getLogin(), user.getPassword(), user.getRoles()))
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
    }
}