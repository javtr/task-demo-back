package com.example.taskdemo.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;
    private Integer state;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public Task() {
    }

    public Task(Integer id, Integer state, String description, User user) {
        this.id = id;
        this.state = state;
        this.description = description;
        this.user = user;
    }

    public Task(Integer state, String description, User user) {
        this.state = state;
        this.description = description;
        this.user = user;
    }

    public Task(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", state=" + state +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
