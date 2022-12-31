package com.example.taskdemo.service;

import com.example.taskdemo.model.Rol;
import com.example.taskdemo.model.User;
import com.example.taskdemo.repository.RolRepository;
import com.example.taskdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;


    public User saveUser(User user){

        if(rolRepository.existsById(1)){
            Rol rol = rolRepository.findById(1).get();
            user.setRol(rol);
        }

        System.out.println(user);

        return userRepository.save(user);
    }


}
