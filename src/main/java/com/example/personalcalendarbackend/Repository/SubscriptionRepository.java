package com.example.personalcalendarbackend.Repository;

import com.example.personalcalendarbackend.Base.BaseRepository;
import com.example.personalcalendarbackend.Entity.Subscription;
import com.example.personalcalendarbackend.Entity.SysUser;

import java.util.List;

public interface SubscriptionRepository extends BaseRepository<Subscription, Long> {

    List<Subscription> findAllBySysUserRef(SysUser sysUser);
}
