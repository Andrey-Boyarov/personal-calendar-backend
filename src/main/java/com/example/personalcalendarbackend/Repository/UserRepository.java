package com.example.personalcalendarbackend.Repository;

import com.example.personalcalendarbackend.Base.BaseRepository;
import com.example.personalcalendarbackend.Entity.User;
import lombok.NonNull;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User, Long> {
}
