package com.example.test.backend.repository;

import com.example.test.backend.Model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface stockRepository extends JpaRepository<Stock, Long> {
}
