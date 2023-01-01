package com.example.taskdemo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Entity
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;
    private String name;
    private String last_name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "userModel")
    private Set<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "rol_id",nullable = false)
    private Rol rol;


    public UserModel() {
    }

    public UserModel(Integer id) {
        this.id = id;
    }

    public UserModel(String name, String last_name, String email, String password, Rol rol) {
        this.email = email;
        this.last_name = last_name;
        this.name = name;
        this.password = password;
        this.rol = rol;
    }

    public UserModel(String email, String password, Rol rol) {
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public UserModel(String name, String last_name, String email, String password) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    public Rol getRol() {
        return rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tasks=" + tasks +
                ", rol=" + rol +
                '}';
    }
}
