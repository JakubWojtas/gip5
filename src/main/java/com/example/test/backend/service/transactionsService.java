package com.example.test.backend.service;

import com.example.test.backend.Model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface transactionsService {

    public Transaction createTransaction(Transaction transaction);

    public Boolean updateTransaction(Transaction transaction);

    public boolean deleteTransaction(Long id);

    public Optional<Transaction> findById(Long id);

    public List<Transaction> findAll();
}
