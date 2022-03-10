package com.example.personalcalendarbackend.Repository;

import com.example.personalcalendarbackend.Base.BaseRepository;
import com.example.personalcalendarbackend.Entity.DictRole;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DictRoleRepository extends BaseRepository<DictRole, Long> {

    Optional<DictRole> findByName(String name);
}
