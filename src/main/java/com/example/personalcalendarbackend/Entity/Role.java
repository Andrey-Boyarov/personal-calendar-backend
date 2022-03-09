package com.example.personalcalendarbackend.Entity;

import com.example.personalcalendarbackend.Base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Role extends BaseEntity {

    private String name;

    private String description;
}
