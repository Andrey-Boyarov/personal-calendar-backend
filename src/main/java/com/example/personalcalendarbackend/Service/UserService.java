package com.example.personalcalendarbackend.Service;

import com.example.personalcalendarbackend.Entity.User;
import com.example.personalcalendarbackend.Local.UserLocal;
import com.example.personalcalendarbackend.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserLocal getUserById(Long id){

        Optional<User> optional = userRepository.findById(id);

        return optional.isPresent()
                ? new UserLocal(optional.get())
                : null;
    }
}
