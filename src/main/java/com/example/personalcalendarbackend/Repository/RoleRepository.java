package com.example.personalcalendarbackend.Repository;

import com.example.personalcalendarbackend.Base.BaseRepository;
import com.example.personalcalendarbackend.Entity.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends BaseRepository<Role, Long> {

    Optional<Role> findByName(String name);
}
