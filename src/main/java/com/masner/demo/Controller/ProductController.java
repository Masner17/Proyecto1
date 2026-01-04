package com.masner.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;


import com.masner.demo.Service.ProductService;
import com.masner.demo.exception.ResourceNotFoundException;
import com.masner.demo.model.Product;

import jakarta.validation.Valid;

import java.util.List;

@Tag(
    name = "Products",
    description = "Operations related to products"
)

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(
    summary = "Obtiene todos los productos",
    description = "Devuelve una lista con todos los productos de la BD"
    )
    // Listar todos
    @GetMapping
    public List<Product> getAll() {
        return productService.findAll();
    }


    @Operation(
    summary = "Obtener productos por ID",
    description = "Retorna los productos por el ID"
    )
    @ApiResponses({
    @ApiResponse(responseCode = "200", description = "Product found"),
    @ApiResponse(responseCode = "404", description = "Product not found")
    })
    // Obtener por id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return productService.findById(id).map(ResponseEntity::ok).orElseThrow (() -> new ResourceNotFoundException ("Producto no encontrado id: "+ id));
    }

    @Operation(
    summary = "Crea un nuevo producto",
    description = "Crea nuevos productos con los datos introducidos"
    )
    @PostMapping
    public ResponseEntity<Product> create(@Valid @RequestBody Product product) {
        Product created = productService.create(product);
        return ResponseEntity.ok(created);
    }

    // Actualizar
    @Operation(summary = "Actualiza productos ya existentes")
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody Product product) {
        Product updated = productService.update(id, product);
        return ResponseEntity.ok(updated);
    }

    // Eliminar
    @Operation(summary = "Elimina un producto por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
