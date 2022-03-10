package com.example.personalcalendarbackend.Base;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;
import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID> extends JpaRepository<T, ID> {

    @Override
    @NonNull
    Optional<T> findById(@NonNull ID id);

    Optional<T> findByUuid(@NonNull UUID uuid);

    void deleteById(@NonNull ID id);

    void deleteByUuid(@NonNull UUID uuid);
}
