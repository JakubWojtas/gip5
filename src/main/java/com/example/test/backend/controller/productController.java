package com.example.test.backend.controller;

import com.example.test.backend.DTO.productDTO;
import com.example.test.backend.Model.Product;
import com.example.test.backend.service.productServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/products")
public class productController {
    private static final Logger logger = LoggerFactory.getLogger(Product.class);
    private static final Logger msgLogger = LoggerFactory.getLogger("messagelogger");

    @Autowired
    private productServiceImpl productService;

    @GetMapping("")
    ResponseEntity<List<Product>> readAll(){
        try {
            return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<Product> read(@PathVariable Long id) {
        try {
            Optional<Product> foundUser = productService.findById(id);

            System.out.println("Ik heb je gevonden!");
            if (foundUser.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(foundUser.get(), HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    ResponseEntity<Product> create(@RequestBody productDTO productDTO) {
        try {
            Product product = new Product();

            product.setProd_name(productDTO.getProd_name());
            product.setProd_desc(productDTO.getProd_desc());
            productDTO.setProd_limit(productDTO.getProd_limit());
            productDTO.setProduct_type(productDTO.getProduct_type());

            Product _product = productService.createProduct(product);
            return new ResponseEntity<>(_product, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<Product> update(@PathVariable Long id) {
        try {
            Optional<Product> foundProduct = productService.findById(id);

            if (foundProduct.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            productService.updateProduct(foundProduct.get());

            return new ResponseEntity<>(foundProduct.get(), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Product> delete(@PathVariable Long id) {
        try {
            productService.deleteProduct(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
