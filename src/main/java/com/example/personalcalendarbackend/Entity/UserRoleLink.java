package com.example.personalcalendarbackend.Entity;

import com.example.personalcalendarbackend.Base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name="user_role_link")
public class UserRoleLink extends BaseEntity {

    @ManyToOne
    @JoinColumn(name="user_ref")
    private SysUser userRef;

    @ManyToOne
    @JoinColumn(name = "role_ref")
    private DictRole roleRef;
}
