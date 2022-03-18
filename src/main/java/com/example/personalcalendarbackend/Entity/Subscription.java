package com.example.personalcalendarbackend.Entity;

import com.example.personalcalendarbackend.Base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "ent_subscription")
public class Subscription extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_ref")
    private User userRef;

    @ManyToOne
    @JoinColumn(name = "target_ref")
    private User targetRef;
}
