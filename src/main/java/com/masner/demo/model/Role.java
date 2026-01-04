package com.masner.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Schema(
    name = "Role",
    description = "Represents a user role in the system"
)
@Entity
@Table(name = "roles")
public class Role {

    @Schema(
    description = "Unico identificador por rol",
    example = "1",
    accessMode = Schema.AccessMode.READ_ONLY
)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(
    description = "Nombre del rol",
    example = "ADMIN"
)
    @Column(nullable = false, unique = true)
    private String name;

    public Role(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
