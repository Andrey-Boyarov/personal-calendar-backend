package com.example.personalcalendarbackend.Entity;

import com.example.personalcalendarbackend.Base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "meta_password")
public class Password extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_ref")
    private User userRef;

    String password;
}
