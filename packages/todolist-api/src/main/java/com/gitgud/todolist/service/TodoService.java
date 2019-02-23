package com.gitgud.todolist.service;

import com.gitgud.todolist.domain.TodoTask;
import com.gitgud.todolist.repository.TodoRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Transactional
    public List<TodoTask> findAll() {
        return todoRepository.findAll();
    }

    @Transactional
    public TodoTask save(TodoTask todoTask) {
        return todoRepository.save(todoTask);
    }

    @Transactional
    public TodoTask update(TodoTask todoTask) {
        boolean existing = todoRepository.findById(todoTask.getId()).isPresent();
        return existing ? todoRepository.save(todoTask) : null;
    }

    @Transactional
    public TodoTask findById(Long id) {
        Optional<TodoTask> todoTask = todoRepository.findById(id);
        return todoTask.isPresent() ? todoTask.get() : null;
    }

    @Transactional
    public List<TodoTask> findByStatus(String status) {
        Optional<List<TodoTask>> todoTask = todoRepository.findByStatus(status);
        return todoTask.isPresent() ? todoTask.get() : null;
    }

    @Transactional(readOnly = true)
    public List<TodoTask> findByCategory(String category) {
        return todoRepository.findByCategory(category);
    }

    @Transactional(readOnly = true)
    public List<TodoTask> searchByCategory(String category) {
        return todoRepository.searchByCategory(category);
    }

    @Transactional(readOnly = true)
    public List<TodoTask> lastResults() {
        return todoRepository.lastResults(PageRequest.of(0, 5)).getContent().stream().sorted(Comparator.comparing(TodoTask::getCategory)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<TodoTask> firstResultsStatus(String status) {
        return todoRepository.firstResultsStatus(status, PageRequest.of(0, 5)).getContent();
    }

    @Transactional
    public TodoTask updateStatus(Long id, String status) {
        if (todoRepository.updateStatus(id, status) > 0) {
            return todoRepository.findById(id).get();
        } else {
            throw new Error("No entities were found / modified");
        }
    }

    @Transactional(readOnly = true)
    public List<TodoTask> findByCreateDate(String date) {
        return todoRepository.findByCreateDate(date);
    }
}
