package com.inventariocontrol.Repository;

import com.inventariocontrol.Entities.UserEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends ListCrudRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUsername(String username);

}
