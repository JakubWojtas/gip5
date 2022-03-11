package com.example.test.backend.service;

import com.example.test.backend.Model.User;
import com.example.test.backend.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class userServiceImpl implements userService {
    @Autowired
    private userRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Boolean updateUser(User user) {
        userRepository.save(user);
        return true;
    }

    public Boolean deleteUser(Long id) {
        userRepository.deleteById(id);

        return true;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
