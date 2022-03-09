package com.example.test.backend.service;

import com.example.test.backend.Model.User;
import org.springframework.stereotype.Service;

@Service
public interface userService {
    public User createUser(User user);

    public Boolean updateUser(User User);

    public Boolean deleteUser(User User);
}
