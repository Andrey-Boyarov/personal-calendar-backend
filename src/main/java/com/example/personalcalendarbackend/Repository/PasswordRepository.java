package com.example.personalcalendarbackend.Repository;

import com.example.personalcalendarbackend.Base.BaseRepository;
import com.example.personalcalendarbackend.Entity.Password;
import com.example.personalcalendarbackend.Entity.User;

import java.util.List;

public interface PasswordRepository extends BaseRepository<Password, Long> {

    List<Password> findAllByUserRef(User userRef);
}
