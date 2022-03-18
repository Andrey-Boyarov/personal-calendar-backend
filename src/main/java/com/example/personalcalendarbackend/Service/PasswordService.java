package com.example.personalcalendarbackend.Service;

import com.example.personalcalendarbackend.Entity.Password;
import com.example.personalcalendarbackend.Entity.User;
import com.example.personalcalendarbackend.Local.PasswordLocal;
import com.example.personalcalendarbackend.Repository.PasswordRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter
@Getter
@RequiredArgsConstructor
public class PasswordService {

    private final PasswordRepository passwordRepository;
    private final UserService userService;

    public Boolean createPassword(PasswordLocal local){

        User user = userService.getUserById(local.getUserRef());
        if (user == null || local.getPassword() == null || local.getPassword().isBlank()) return false;

        return createPassword(user, local.getPassword());
    }

    public Boolean createPassword(User user, String password){

        List<Password> passwords = passwordRepository.findAllByUserRef(user);
        passwords.forEach(pass -> pass.setIsRelevant(false));
        passwords.add(new Password(user, password));

        passwordRepository.saveAll(passwords);

        return true;
    }
}
