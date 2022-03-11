package com.example.test.backend.controller;

import com.example.test.backend.DTO.stockDTO;
import com.example.test.backend.Model.Product;
import com.example.test.backend.Model.Stock;
import com.example.test.backend.service.productServiceImpl;
import com.example.test.backend.service.stockServiceImpl;
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
@RequestMapping("/api/stock")
public class stockController {
    private static final Logger logger = LoggerFactory.getLogger(Stock.class);
    private static final Logger msgLogger = LoggerFactory.getLogger("messagelogger");

    @Autowired
    private stockServiceImpl stockService;
    @Autowired
    private productServiceImpl productService;

    @GetMapping("")
    ResponseEntity<List<Stock>> readAll(){
        try {
            return new ResponseEntity<>(stockService.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<Stock> read(@PathVariable Long id) {
        try {
            Optional<Stock> foundStock = stockService.findById(id);

            System.out.println("Ik heb je gevonden!");
            if (foundStock.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(foundStock.get(), HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    ResponseEntity<Stock> create(@RequestBody stockDTO stockDTO) {
        try {
            Stock stock = new Stock();

            stock.setProducts(stockDTO.getProducts());

            Stock _stock = stockService.createStock(stock);
            return new ResponseEntity<>(_stock, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<Stock> update(@PathVariable Long id) {
        try {
            Optional<Stock> foundStock = stockService.findById(id);

            if (foundStock.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            stockService.update(foundStock.get());

            return new ResponseEntity<>(foundStock.get(), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}/product/{prod_id}")
    ResponseEntity<Void> addProduct(@PathVariable Long prod_id, @PathVariable Long id){
        Optional<Stock> stock = stockService.findById(id);
        Optional<Product> product = productService.findById(prod_id);

        if (!product.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (!product.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        stock.get().addProduct(product.get());
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    @DeleteMapping("/{id}/product/{prod_id}")
    ResponseEntity<Void> removeProduct(@PathVariable Long prod_id, @PathVariable Long id){
        Optional<Stock> stock = stockService.findById(id);
        Optional<Product> product = productService.findById(prod_id);

        if (!product.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (!product.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        stock.get().removeProduct(product.get());
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Stock> delete(@PathVariable Long id) {
        try {
            stockService.delete(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
