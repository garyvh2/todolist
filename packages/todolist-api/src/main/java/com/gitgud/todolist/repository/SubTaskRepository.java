package com.gitgud.todolist.repository;

import com.gitgud.todolist.domain.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
}
