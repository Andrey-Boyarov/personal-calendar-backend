package com.example.personalcalendarbackend.Repository;

import com.example.personalcalendarbackend.Base.BaseRepository;
import com.example.personalcalendarbackend.Entity.SysUser;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends BaseRepository<SysUser, Long> {

    Optional<SysUser> findByLoginAndIsRelevantTrue(String login);

    List<SysUser> findAllByIsRelevantTrue();
}
