package com.gitgud.todolist.web;

import com.gitgud.todolist.domain.SubTask;
import com.gitgud.todolist.service.SubTaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subtask")
public class SubTaskController {
    private final SubTaskService subTaskService;

    public SubTaskController (SubTaskService subTaskService) {
        this.subTaskService = subTaskService;
    }

    @GetMapping
    public List<SubTask> findAll () {
        return this.subTaskService.findAll();
    }

    @PostMapping
    public SubTask save(@RequestBody SubTask subTask) {
        return this.subTaskService.save(subTask);
    }

    @PutMapping
    public SubTask update(@RequestBody SubTask subTask) {
        return this.subTaskService.update(subTask);
    }
}
