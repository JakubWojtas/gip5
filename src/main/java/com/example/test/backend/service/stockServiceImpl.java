package com.example.test.backend.service;

import com.example.test.backend.Model.Stock;
import com.example.test.backend.repository.stockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class stockServiceImpl implements stockService{
    @Autowired
    private stockRepository stockRepository;

    @Override
    public Stock createStock(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public boolean update(Stock stock) {
        stockRepository.save(stock);
        return true;
    }

    @Override
    public boolean delete(Long id) {
        stockRepository.deleteById(id);
        return true;
    }

    @Override
    public Optional<Stock> findById(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

}
