package com.todos.api.service;

import javax.transaction.Transactional;

import com.todos.api.model.Todo;
import com.todos.api.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    public List<Todo> listTodos() {
        return todoRepository.findAll();
    }

    public void saveTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public Todo getTodo(Integer id) {
        return todoRepository.findById(id).get();
    }

    public void deleteTodo(Integer id) {
        todoRepository.deleteById(id);
    }
}
