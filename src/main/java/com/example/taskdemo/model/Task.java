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
    private UserModel userModel;

    public Task() {
    }

    public Task(Integer id, Integer state, String description, UserModel userModel) {
        this.id = id;
        this.state = state;
        this.description = description;
        this.userModel = userModel;
    }

    public Task(Integer state, String description, UserModel userModel) {
        this.state = state;
        this.description = description;
        this.userModel = userModel;
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

    public UserModel getUser() {
        return userModel;
    }

    public void setUser(UserModel userModel) {
        this.userModel = userModel;
    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", state=" + state +
                ", description='" + description + '\'' +
                ", user=" + userModel +
                '}';
    }
}
