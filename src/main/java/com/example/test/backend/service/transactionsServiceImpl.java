package com.example.test.backend.service;

import com.example.test.backend.Model.Transaction;
import com.example.test.backend.repository.transactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class transactionsServiceImpl implements transactionsService{
    @Autowired
    private transactionsRepository transactionsRepository;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        return transactionsRepository.save(transaction);
    }

    @Override
    public Boolean updateTransaction(Transaction transaction) {
        transactionsRepository.save(transaction);
        return true;
    }

    @Override
    public boolean deleteTransaction(Transaction transaction) {
        transactionsRepository.delete(transaction);
        return true;
    }
}
