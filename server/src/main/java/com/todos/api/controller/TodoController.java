package com.todos.api.controller;

import com.todos.api.model.Todo;
import com.todos.api.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/todos")
@CrossOrigin(origins = "*")
public class TodoController {
    @Autowired
    private TodoService todoSrv;

    @GetMapping("")
    public List<Todo> list(){
        return todoSrv.listTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> get(@PathVariable Integer id) {
        try {
            Todo todo = todoSrv.getTodo(id);
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Todo todo) {
        todoSrv.saveTodo(todo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Todo todo) {
        try {
            Todo todoFromDb = todoSrv.getTodo(id);
            todoFromDb.setDone(todo.getDone());
            todoSrv.saveTodo(todoFromDb);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        todoSrv.deleteTodo(id);
    }
}
