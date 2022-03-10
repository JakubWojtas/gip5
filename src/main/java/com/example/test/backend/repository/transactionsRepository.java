package com.example.test.backend.repository;

import com.example.test.backend.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface transactionsRepository extends JpaRepository<Transaction, Long> {
}
