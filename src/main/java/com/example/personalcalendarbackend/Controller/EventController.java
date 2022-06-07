package com.example.personalcalendarbackend.Controller;


import com.example.personalcalendarbackend.Entity.Event;
import com.example.personalcalendarbackend.Local.EventCreateLocal;
import com.example.personalcalendarbackend.Local.EventLocal;
import com.example.personalcalendarbackend.Repository.EventRepository;
import com.example.personalcalendarbackend.Service.CurUserService;
import com.example.personalcalendarbackend.Service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
                    .map(sub -> eventRepository.findAllByAuthorAndIsRelevantTrue(sub.getTargetRef()).stream())
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
                    .map(sub -> eventRepository.findAllByAuthorAndIsRelevantTrue(sub.getTargetRef()).stream())
                    .reduce(Stream::concat).orElse(Stream.empty())
                    .collect(Collectors.toList())
        ).orElse(new ArrayList<>());
    }

    @GetMapping("/getAllMyEvents")
    public List<EventLocal> getAllMyEvents(){
        return curUserService.getCurrentUserOpt().map(user ->
                eventRepository.findAllByAuthorAndIsRelevantTrue(user).stream()
                .map(e -> new EventLocal(
                        e.getId(),
                        e.getStartDateTime().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                        e.getTitle(),
                        e.getMaintain())
                ).collect(Collectors.toList())).orElse(new ArrayList<>());
    }

    @PostMapping("/create")
    public boolean create(@RequestBody EventCreateLocal local){
        Event event = new Event();
        event.setAuthor(curUserService.getCurrentUser());
        event.setTitle(local.getEventTitle());
        event.setMaintain(local.getEventMainTain());
        LocalDate date = LocalDate.parse(local.getEventDate(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        event.setStartDateTime(date.atStartOfDay());
        event.setEndDateTime(date.atStartOfDay());
        eventRepository.save(event);
        return true;
    }

    @GetMapping("/delete/{eventId}")
    public boolean delete(@PathVariable Long eventId){
        eventRepository.save(
                eventRepository.findById(eventId)
                        .map(e -> {
                            e.setIsRelevant(false);
                            return e;
                        })
                        .get());
        return true;
    }
}
