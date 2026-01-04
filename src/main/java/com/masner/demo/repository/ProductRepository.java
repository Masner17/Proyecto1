package com.masner.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masner.demo.model.Product;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);
}
