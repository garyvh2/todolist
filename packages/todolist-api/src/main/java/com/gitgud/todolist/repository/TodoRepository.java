package com.gitgud.todolist.repository;

import com.gitgud.todolist.domain.TodoTask;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<TodoTask, Long> {
    Optional<List<TodoTask>> findByStatus (String status);

    List<TodoTask> findByCategory(String category);

    @Query("select todoTask from TodoTask todoTask where todoTask.category like %:category%")
    List<TodoTask> searchByCategory(String category);

    @Query("select todoTask from TodoTask todoTask order by todoTask.id desc")
    Page<TodoTask> lastResults(Pageable pageable);

    @Query("select todoTask from TodoTask todoTask where todoTask.status = :status")
    Page<TodoTask> firstResultsStatus(String status, Pageable pageable);

    @Modifying
    @Query("update TodoTask todoTask set todoTask.status = :status where todoTask.id = :id")
    int updateStatus(Long id, String status);

    List<TodoTask> findByCreateDate(String date);
}
