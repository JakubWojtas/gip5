package com.example.test.backend.service;

import com.example.test.backend.Model.Transaction;
import org.springframework.stereotype.Service;


@Service
public interface transactionsService {

    public Transaction createTransaction(Transaction transaction);

    public Boolean updateTransaction(Transaction transaction);

    public boolean deleteTransaction(Transaction transaction);
}
