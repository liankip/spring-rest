package com.todos.api.repository;

import java.util.List;

import com.todos.api.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer> {
    List<User> findByUsernameAndPassword(String username, String password);
}
