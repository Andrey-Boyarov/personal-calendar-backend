package com.example.personalcalendarbackend.Entity;

import com.example.personalcalendarbackend.Base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "dict_role")
public class DictRole extends BaseEntity implements GrantedAuthority {

    private String name;

    private String description;

    @Override
    public String getAuthority() {
        return name;
    }
}
