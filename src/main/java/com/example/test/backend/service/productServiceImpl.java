package com.example.test.backend.service;

import com.example.test.backend.Model.Product;
import com.example.test.backend.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Boolean deleteProduct(Product product) {
        productRepository.delete(product);
        return true;
    }
}
