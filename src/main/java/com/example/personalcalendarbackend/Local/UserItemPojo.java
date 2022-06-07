package com.example.personalcalendarbackend.Local;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserItemPojo {
    private Long userId;
    private String username;
    private String roles;
}
