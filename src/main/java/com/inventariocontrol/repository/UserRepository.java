package com.inventariocontrol.repository;

import com.inventariocontrol.entities.UserEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface UserRepository extends ListCrudRepository<UserEntity, UUID> {
    UserEntity findByUsername(String username);
}
