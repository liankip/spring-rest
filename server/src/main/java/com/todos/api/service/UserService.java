package com.todos.api.service;

import javax.transaction.Transactional;

import com.todos.api.model.User;
import com.todos.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> getUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
