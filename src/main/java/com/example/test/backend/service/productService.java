package com.example.test.backend.service;

import com.example.test.backend.Model.Product;
import org.springframework.stereotype.Service;

@Service
public interface productService {
    public Product createProduct(Product product);

    public Boolean updateProduct(Product product);

    public Boolean deleteProduct(Product product);
}
