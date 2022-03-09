package com.example.personalcalendarbackend.Service;

import com.example.personalcalendarbackend.Entity.Role;
import com.example.personalcalendarbackend.Repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getRoleByName(String rolename){
        return roleRepository.findByName(rolename).get();
    }
}
