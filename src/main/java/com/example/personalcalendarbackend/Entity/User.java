package com.example.personalcalendarbackend.Entity;

import com.example.personalcalendarbackend.Base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ent_user")
public class User extends BaseEntity {

    String login;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role")
    DictRole role;

    LocalDateTime isBannedUntil;

    String mailAddress;

    LocalDateTime irrelevantUntil;
}
