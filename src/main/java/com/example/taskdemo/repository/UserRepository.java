package com.example.taskdemo.repository;

import com.example.taskdemo.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel,Integer> {
    UserModel findByEmail(String email);

}





