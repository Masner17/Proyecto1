package com.masner.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masner.demo.Service.UserService;
import com.masner.demo.model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@Tag(
    name = "Users",
    description = "Endpoints for user management"
)
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Crear usuario
    @Operation(
    summary = "Crear nuevo usuario",
    description = "Crear un nuevo usuario y darle un role"
)
    @PostMapping
    public User createUser(@RequestBody User user, @RequestParam String role) {

        return userService.createUser(user, role);
    }

    // Listar todos los usuarios
    @Operation(
    summary = "Obtiene todos los usuarios",
    description = "Retorna todos los usuarios registrados"
)
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
