package com.example.test.backend.service;

import com.example.test.backend.Model.Product;
import com.example.test.backend.Model.User;
import com.example.test.backend.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class productServiceImpl implements productService{
    @Autowired
    private productRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Boolean updateProduct(Product product) {
        productRepository.save(product);
        return true;
    }

    public Boolean deleteProduct(Long id) {
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
