package com.example.test.backend.repository;

import com.example.test.backend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User, Long>{
}
