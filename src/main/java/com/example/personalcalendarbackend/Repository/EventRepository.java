package com.example.personalcalendarbackend.Repository;

import com.example.personalcalendarbackend.Base.BaseRepository;
import com.example.personalcalendarbackend.Entity.Event;
import com.example.personalcalendarbackend.Entity.SysUser;

import java.util.List;

public interface EventRepository extends BaseRepository<Event, Long> {

    List<Event> findAllByAuthorAndIsRelevantTrue(SysUser author);
}
