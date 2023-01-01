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
    private Set<UserModel> userModels;



    public Rol() {
    }

    public Rol(String rol, Set<UserModel> userModels) {
        this.rol = rol;
        this.userModels = userModels;
    }

    public Rol(Integer id, String rol, Set<UserModel> userModels) {
        this.id = id;
        this.rol = rol;
        this.userModels = userModels;
    }

    public Rol(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Set<UserModel> getUsers() {
        return userModels;
    }

    public void setUsers(Set<UserModel> userModels) {
        this.userModels = userModels;
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

