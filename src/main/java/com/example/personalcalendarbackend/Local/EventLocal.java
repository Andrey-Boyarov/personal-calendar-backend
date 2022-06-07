package com.example.personalcalendarbackend.Local;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class EventLocal {
    private Long id;
    private String date;
    private String title;
    private String maintain;
}
