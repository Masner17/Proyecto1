package com.masner.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Schema(
    name = "User",
    description = "Represents an application user"
)
@Entity
@Table(name = "users")
public class User {

    @Schema(
    description = "Unico identificador por usuario",
    example = "1",
    accessMode = Schema.AccessMode.READ_ONLY
)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(
    description = "Email del usuario",
    example = "user@email.com"
)
    @Column(nullable = false, unique = true)
    private String email;

    @Schema(
    description = "Contraseña Usuario",
    example = "strongPassword123"
)
    @Column(nullable = false)
    private String password;

    @Schema(
    description = "Nombre completo del usuario",
    example = "Juan Pérez"
)
    private String name;

    @Schema(
    description = "Rol asignado del usuario"
)
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public User(String name, String password, Role role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }
    public User(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
