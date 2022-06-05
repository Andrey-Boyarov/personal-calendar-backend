package com.example.personalcalendarbackend.Controller;


import com.example.personalcalendarbackend.Entity.Event;
import com.example.personalcalendarbackend.Repository.EventRepository;
import com.example.personalcalendarbackend.Service.CurUserService;
import com.example.personalcalendarbackend.Service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
public class EventController {

    private final EventRepository eventRepository;
    private final CurUserService curUserService;
    private final SubscriptionService subscriptionService;

    @GetMapping("/getAllEventsByDay")
    public List<Event> getAllEventsByDay(@RequestParam LocalDate date){
        return curUserService.getCurrentUserOpt().map(user ->
            subscriptionService.getSubscriptionsByUser(user).stream()
                    .map(sub -> eventRepository.findAllByAuthor(sub.getTargetRef()).stream())
                    .reduce(Stream::concat).orElse(Stream.empty())
                    .filter(event ->
                            event.getStartDateTime().toLocalDate().equals(date) || event.getEndDateTime().toLocalDate().equals(date) ||
                                    (date.isAfter(event.getStartDateTime().toLocalDate()) && date.isBefore(event.getEndDateTime().toLocalDate()))
                    )
                    .collect(Collectors.toList())
        ).orElse(new ArrayList<>());
    }

    @GetMapping("/getAllEventsBySubscription")
    public List<Event> getAllEventsBySubscription(){
        return curUserService.getCurrentUserOpt().map(user ->
            subscriptionService.getSubscriptionsByUser(user).stream()
                    .map(sub -> eventRepository.findAllByAuthor(sub.getTargetRef()).stream())
                    .reduce(Stream::concat).orElse(Stream.empty())
                    .collect(Collectors.toList())
        ).orElse(new ArrayList<>());
    }
}
