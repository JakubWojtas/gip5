package com.example.test.backend.controller;

import com.example.test.backend.DTO.userDTO;
import com.example.test.backend.Model.User;
import com.example.test.backend.service.userServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/users")
public class userController {
    private static final Logger logger = LoggerFactory.getLogger(User.class);
    private static final Logger msgLogger = LoggerFactory.getLogger("messagelogger");

    @Autowired
    private userServiceImpl userService;

    @GetMapping("")
    ResponseEntity<List<User>> readAll(){
        try {
            return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    ResponseEntity<User> read(@PathVariable Long id) {
        try {
            Optional<User> foundUser = userService.findById(id);

            System.out.println("Ik heb je gevonden!");
            if (foundUser.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            return new ResponseEntity<>(foundUser.get(), HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    ResponseEntity<User> create(@RequestBody userDTO userDTO) {
        try {
            User user = new User();

            user.setUser_name(userDTO.getUser_name());
            user.setUser_mobile(userDTO.getUser_mobile());
            user.setUser_email(user.getUser_email());
            user.setUser_role(user.getUser_role());

            User _user = userService.createUser(user);
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    ResponseEntity<User> update(@PathVariable Long id) {
        try {
            Optional<User> foundUser = userService.findById(id);

            if (foundUser.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            userService.updateUser(foundUser.get());

            return new ResponseEntity<>(foundUser.get(), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<User> delete(@PathVariable Long id) {
        try {
            userService.deleteUser(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
