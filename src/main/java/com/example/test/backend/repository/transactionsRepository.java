package com.example.test.backend.repository;

import com.example.test.backend.Model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface transactionsRepository extends JpaRepository<Transactions, Long> {
}
