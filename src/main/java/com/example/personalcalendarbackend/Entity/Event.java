package com.example.personalcalendarbackend.Entity;

import com.example.personalcalendarbackend.Base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ent_event")
public class Event extends BaseEntity {

    private LocalDateTime irrelevantUntil;

    private LocalDateTime startDateTime;

    private LocalDateTime endDateTime;

    private String title;

    private String maintain;

    private String metaReferences;

    @OneToOne
    @JoinColumn(name = "author")
    private SysUser author;

    private Boolean isPublic;
}