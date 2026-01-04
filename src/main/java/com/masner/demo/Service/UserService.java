package com.masner.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.masner.demo.exception.ResourceNotFoundException;
import com.masner.demo.model.Role;
import com.masner.demo.model.User;

import com.masner.demo.repository.RoleRepository;
import com.masner.demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User createUser(User user, String roleName) {
        // Validacion si existe
        if (userRepository.existsByName(user.getName())) {
            throw new RuntimeException("Nombre ya equiste");
        }

        // Buscar y asignarle el rol
        Role role = roleRepository.findByName(roleName).orElseThrow(() -> new ResourceNotFoundException("Rol no existe" +roleName));

        user.setRole(role);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
