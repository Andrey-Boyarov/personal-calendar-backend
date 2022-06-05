package com.example.personalcalendarbackend.Service;

import com.example.personalcalendarbackend.Entity.Subscription;
import com.example.personalcalendarbackend.Entity.SysUser;
import com.example.personalcalendarbackend.Repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserService userService;

    public String listToString(List<Subscription> list){
        return list.stream().map(sub -> sub.getTargetRef().getLogin()).collect(Collectors.joining(" "));
    }

    public List<Subscription> getSubscriptionsByUser(Long id){
        SysUser sysUser = userService.getUserById(id);
        if (sysUser == null) return new ArrayList<>();
        return getSubscriptionsByUser(sysUser);
    }

    public List<Subscription> getSubscriptionsByUser(SysUser sysUser){

        return subscriptionRepository.findAllBySysUserRef(sysUser);
    }

    public String getSubscriptionsAsString(List<Subscription> list){

        return listToString(list);
    }

    public String getSubscriptionsAsString(Long id){

        return getSubscriptionsAsString(getSubscriptionsByUser(id));
    }
}
