package com.example.personalcalendarbackend.Service;

import com.example.personalcalendarbackend.Entity.Subscription;
import com.example.personalcalendarbackend.Entity.User;
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

        User user = userService.getUserById(id);
        if (user == null) return new ArrayList<>();

        return getSubscriptionsByUser(user);
    }

    public List<Subscription> getSubscriptionsByUser(User user){

        return subscriptionRepository.findAllByUserRef(user);
    }

    public String getSubscriptionsAsString(List<Subscription> list){

        return listToString(list);
    }

    public String getSubscriptionsAsString(Long id){

        return getSubscriptionsAsString(getSubscriptionsByUser(id));
    }
}
