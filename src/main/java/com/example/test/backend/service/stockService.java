package com.example.test.backend.service;

import com.example.test.backend.Model.Product;
import com.example.test.backend.Model.Stock;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface stockService {
    public Stock createStock(Stock stock);

    public boolean update(Stock stock);

    public boolean delete(Long id);

    public Optional<Stock> findById(Long id);

    public List<Stock> findAll();
}
