package com.masner.demo.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

@Schema(
    name = "Producto",
    description = "Representa un producto en el sistema"
)

@Entity
@Table(name = "products")
public class Product {

    @Schema(
    description = "Identificador del producto",
    example = "1",
    accessMode = Schema.AccessMode.READ_ONLY
    )
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(
    description = "Nombre del producto",
    example = "Teclado"
    )
    @NotBlank(message = "Nombre requerido")
    @Column(nullable = false)
    private String name;

    @Schema(
    description = "Detalles del producto",
    example = "Teclado mecanico luces RGB"
)
    private String description;

    @Schema(
    description = "Precio producto",
    example = "99.99"
    )
    @NotNull(message = "Precio requerido")
    @PositiveOrZero(message = "El valor debe ser mayor que 0")
    private Double price;

    @Schema(
    description = "Stock disponible",
    example = "50"
)
    @PositiveOrZero(message = "El stock debe ser un valor de 0 o mayor")
    private int stock;

    public Product(String name, String description, Double price, Integer stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Product(){

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
