package com.inventariocontrol.Repository;

import com.inventariocontrol.Entities.DepartmentEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.UUID;

public interface DepartmentRepository extends ListCrudRepository<DepartmentEntity, UUID> {
    DepartmentEntity findByName(String name);
}
