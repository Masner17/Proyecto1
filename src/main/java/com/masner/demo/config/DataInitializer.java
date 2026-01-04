package com.masner.demo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.masner.demo.model.Role;
import com.masner.demo.repository.RoleRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        if (roleRepository.findByName("ADMIN").isEmpty()) {
            Role admin = new Role();
            admin.setName("ADMIN");
            roleRepository.save(admin);
        }

        if (roleRepository.findByName("USER").isEmpty()) {
            Role user = new Role();
            user.setName("USER");
            roleRepository.save(user);
        }
    }
}