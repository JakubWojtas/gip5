package com.example.test.backend.repository;

import com.example.test.backend.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<Product, Long> {
}
