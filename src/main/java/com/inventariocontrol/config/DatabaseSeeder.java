package com.inventariocontrol.config;

import com.inventariocontrol.Entities.DepartmentEntity;
import com.inventariocontrol.Entities.UserEntity;
import com.inventariocontrol.Repository.DepartmentRepository;
import com.inventariocontrol.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    public DatabaseSeeder(
        UserRepository userRepository,
        DepartmentRepository departmentRepository
    ) {
        this.userRepository = userRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        DepartmentEntity department = departmentRepository.findAll().stream().findFirst().orElse(null);

        if (department == null) {
            department = new DepartmentEntity();
            department.setName("ADMINISTRACION");
            department.setActive(true);
            department.setDescription("Área de administración");
            department = departmentRepository.save(department);
        }

        if (userRepository.count() == 0) {
            UserEntity user = new UserEntity();
            user.setUsername("Aldair Cruz");
            user.setCellphoneNumber("4425866795");
            user.setRole("ADMIN");
            user.setDepartment(department);
            userRepository.save(user);
        }
    }
}
