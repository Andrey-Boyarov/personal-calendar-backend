package com.example.personalcalendarbackend.Base;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID> extends JpaRepository<T, ID> {

    @Override
    @NonNull
    Optional<T> findById(@NonNull ID id);

    void deleteById(@NonNull ID id);
}
