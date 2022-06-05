package com.example.personalcalendarbackend.Service;

import com.example.personalcalendarbackend.Entity.SysUser;
import com.example.personalcalendarbackend.Local.UserItemPojo;
import com.example.personalcalendarbackend.Local.UserLocal;
import com.example.personalcalendarbackend.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public List<UserItemPojo> getAllUsers(){
        return userRepository.findAllByIsRelevantTrue()
                .stream().map(user -> new UserItemPojo(user.getId(), user.getLogin())).collect(Collectors.toList());
    }

    public SysUser saveUserWithEncode(SysUser user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    public SysUser getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public UserLocal getUserLocalById(Long id){
        Optional<SysUser> optional = userRepository.findById(id);
        return optional.isPresent()
                ? new UserLocal(optional.get())
                : null;
    }

    public SysUser getUserByLogin(String login){
        return userRepository.findByLoginAndIsRelevantTrue(login).get();
    }
}
