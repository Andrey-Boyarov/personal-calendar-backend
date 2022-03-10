package com.example.personalcalendarbackend.Service;

import com.example.personalcalendarbackend.Entity.DictRole;
import com.example.personalcalendarbackend.Repository.DictRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DictRoleService {

    private final DictRoleRepository dictRoleRepository;

    public DictRole getRoleByName(String rolename){
        return dictRoleRepository.findByName(rolename).get();
    }
}
