package com.masner.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.masner.demo.exception.ResourceNotFoundException;
import com.masner.demo.model.Product;
import com.masner.demo.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // Obtener todos los productos
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    // Obtener producto por Id
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    // Crear nuevo producto
    public Product create(Product product) {
        // podemos agregar algunas validaciones aca para el producto a guardar en la BD
        return productRepository.save(product);
    }

    // Actualizar Producto
public Product update(Long id, Product updated) {
    Product existing = productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Producto no existe"));

    existing.setName(updated.getName());
    existing.setDescription(updated.getDescription());
    existing.setPrice(updated.getPrice());
    existing.setStock(updated.getStock());

    return productRepository.save(existing);
}

    // Eliminar producto
    public void delete(Long id) {
        Product existing = findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Producto no existe"));
        productRepository.delete(existing);
    }
}
