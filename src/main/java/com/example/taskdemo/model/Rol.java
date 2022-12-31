package com.example.taskdemo.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;
    private String rol;

    @OneToMany(mappedBy = "rol")
    private Set<User> users;



    public Rol() {
    }

    public Rol(String rol, Set<User> users) {
        this.rol = rol;
        this.users = users;
    }

    public Rol(Integer id, String rol, Set<User> users) {
        this.id = id;
        this.rol = rol;
        this.users = users;
    }

    public Rol(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", rol='" + rol + '\'' +
                '}';
    }
}

