package com.example.test.backend.service;

import com.example.test.backend.Model.Product;
import com.example.test.backend.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface productService {
    public Product createProduct(Product product);

    public Boolean updateProduct(Product product);

    public Boolean deleteProduct(Long id);

    public Optional<Product> findById(Long id);

    public List<Product> findAll();
}
