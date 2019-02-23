package com.gitgud.todolist.web;

import com.gitgud.todolist.domain.TodoTask;
import com.gitgud.todolist.service.TodoService;
import org.springframework.web.bind.annotation.*;
import sun.jvm.hotspot.ui.tree.SimpleTreeNode;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<TodoTask> getAll() {
        return todoService.findAll();
    }

    @PostMapping
    public TodoTask save(@RequestBody TodoTask todoTask) {
        return todoService.save(todoTask);
    }

    @PutMapping
    public TodoTask update(@RequestBody TodoTask todoTask) {
        return todoService.update(todoTask);
    }

    @GetMapping("/find-by-id/{id}")
    public TodoTask findById(@PathVariable Long id) {
        return todoService.findById(id);
    }

    @GetMapping("/find-by-status")
    public List<TodoTask> findByStatus(@RequestParam("status") String status) {
        return todoService.findByStatus(status);
    }

    @GetMapping("/find-category")
    public List<TodoTask> findByCategory (@RequestParam String category) {
        return todoService.findByCategory(category);
    }

    @GetMapping("/search-category")
    public List<TodoTask> searchByCategory(@RequestParam String category) {
        return todoService.searchByCategory(category);
    }

    @GetMapping("/last-results")
    public List<TodoTask> lastResults() {
        return todoService.lastResults();
    }

    @GetMapping("/first-results-status")
    public List<TodoTask> firstResultsStatus(@RequestParam String status) {
        return todoService.firstResultsStatus(status);
    }

    @GetMapping("/creation-date")
    public List<TodoTask> findByCreateDate(@RequestParam String date) {
        return todoService.findByCreateDate(date);
    }

    @PutMapping("/update-status/{id}")
    public TodoTask updateStatus(@PathVariable Long id, @RequestParam String status) {
        return todoService.updateStatus(id, status);
    }
}