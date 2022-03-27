package com.example.personalcalendarbackend.Service;

import com.example.personalcalendarbackend.Entity.SysUser;
import com.example.personalcalendarbackend.Local.UserLocal;
import com.example.personalcalendarbackend.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

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
}
