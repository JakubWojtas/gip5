package com.example.test.backend.service;

import com.example.test.backend.Model.User;
import com.example.test.backend.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Boolean deleteUser(User user) {
        userRepository.delete(user);

        return true;
    }
}
