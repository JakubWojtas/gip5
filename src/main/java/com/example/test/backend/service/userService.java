package com.example.test.backend.service;

import com.example.test.backend.Model.User;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public interface userService {
    public User createUser(User user);

    public Boolean updateUser(User User);

    public Boolean deleteUser(Long id);

    public Optional<User> findById(Long id);

    public List<User> findAll();
}
