package com.todos.api.controller;

import com.todos.api.model.User;
import com.todos.api.repository.UserRepository;
import com.todos.api.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user/signup")
    public void registerUser(@RequestBody User user) {
        userService.save(user);
    }
    
    @PostMapping("/user/signin")
    public ResponseEntity<List<User>> loginUser(@RequestBody User user) {
        return new ResponseEntity<List<User>>(userService.getUser(user.getUsername(), user.getPassword()) , HttpStatus.OK);
    }
}