package com.gitgud.todolist.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TodoTask {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;
    @Column
    private String category;
    @Column
    private String description;
    @Column
    private String status;
    @Column
    private String createDate;
    @OneToMany
    private Set<SubTask> subTasks = new HashSet<>();
    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
