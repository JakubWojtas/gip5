package com.example.test.backend.controller;

import com.example.test.backend.DTO.transactionDTO;
import com.example.test.backend.Model.Product;
import com.example.test.backend.Model.Transaction;
import com.example.test.backend.service.productService;
import com.example.test.backend.service.transactionsService;
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
@RequestMapping("/api/transactions")
public class transactionsController {
    private static final Logger logger = LoggerFactory.getLogger(Transaction.class);
    private static final Logger msgLogger = LoggerFactory.getLogger("messagelogger");

    @Autowired
    private transactionsService transactionsService;
    @Autowired
    private productService productService;

    @GetMapping("")
    ResponseEntity<List<Transaction>> readAll(){
        try {
            return new ResponseEntity<>(transactionsService.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<Transaction> read(@PathVariable Long id) {
        try {
            Optional<Transaction> foundStock = transactionsService.findById(id);

            System.out.println("Ik heb je gevonden!");
            if (foundStock.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(foundStock.get(), HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    ResponseEntity<Transaction> create(@RequestBody transactionDTO transactionDTO) {
        try {
            Transaction transaction = new Transaction();

            transaction.setUser(transactionDTO.getUser());
            transaction.setProduct_amount(transactionDTO.getProduct_amount());
            transaction.setDate(transactionDTO.getDate());
            transaction.setProducts(transactionDTO.getProducts());

            Transaction _trans = transactionsService.createTransaction(transaction);
            return new ResponseEntity<>(_trans, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<Transaction> update(@PathVariable Long id) {
        try {
            Optional<Transaction> foundTrans = transactionsService.findById(id);

            if (foundTrans.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            transactionsService.updateTransaction(foundTrans.get());

            return new ResponseEntity<>(foundTrans.get(), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}/product/{prod_id}")
    ResponseEntity<Void> addProduct(@PathVariable Long prod_id, @PathVariable Long id){
        Optional<Transaction> transaction = transactionsService.findById(id);
        Optional<Product> product = productService.findById(prod_id);

        if (!transaction.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (!product.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        transaction.get().addProduct(product.get());
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }

    @DeleteMapping("/{id}/product/{prod_id}")
    ResponseEntity<Void> removeProduct(@PathVariable Long prod_id, @PathVariable Long id){
        Optional<Transaction> transaction = transactionsService.findById(id);
        Optional<Product> product = productService.findById(prod_id);

        if (!transaction.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (!product.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        transaction.get().removeProduct(product.get());
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }


    @DeleteMapping("/{id}")
    ResponseEntity<Transaction> delete(@PathVariable Long id) {
        try {
            transactionsService.deleteTransaction(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
