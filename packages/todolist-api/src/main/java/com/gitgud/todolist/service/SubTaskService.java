package com.gitgud.todolist.service;

import com.gitgud.todolist.domain.SubTask;
import com.gitgud.todolist.repository.SubTaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SubTaskService {
    private final SubTaskRepository subTaskRepository;

    public SubTaskService(SubTaskRepository subTaskRepository) {
        this.subTaskRepository = subTaskRepository;
    }

    @Transactional(readOnly = true)
    public List<SubTask> findAll() {
        return this.subTaskRepository.findAll();
    }

    @Transactional
    public SubTask save(SubTask subTask) {
        return this.subTaskRepository.save(subTask);
    }

    @Transactional
    public SubTask update(SubTask subTask) {
        Optional<SubTask> current = this.subTaskRepository.findById(subTask.getId());
        return current.isPresent() ? this.subTaskRepository.save(subTask) : null;
    }
}
