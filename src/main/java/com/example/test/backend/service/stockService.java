package com.example.test.backend.service;

import com.example.test.backend.Model.Stock;
import org.springframework.stereotype.Service;

@Service
public interface stockService {
    public Stock createStock(Stock stock);

    public boolean update(Stock stock);

    public boolean delete(Stock stock);
}
