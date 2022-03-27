package com.example.personalcalendarbackend.Entity;

import com.example.personalcalendarbackend.Base.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static javax.persistence.FetchType.EAGER;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ent_user")
public class SysUser extends BaseEntity {

    private String login;

    private LocalDateTime isBannedUntil;

    private String mailAddress;

    private LocalDateTime irrelevantUntil;

    private String password;

    @OneToMany(fetch = EAGER)
    @JoinColumn(name = "user_ref")
    private List<UserRoleLink> links;

    public List<DictRole> getRoles(){
        return links.stream().map(UserRoleLink::getRoleRef).collect(Collectors.toList());
    }
}
