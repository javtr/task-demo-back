package com.example.taskdemo.controller;

import com.example.taskdemo.model.Rol;
import com.example.taskdemo.model.UserModel;
import com.example.taskdemo.repository.UserRepository;
import com.example.taskdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserRepository usersRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel user) {

        System.out.println(user);

        if (usersRepository.findByEmail(user.getEmail())!=null) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "El email ya esta registrado");
        }

        //pisar el password por uno encriptado
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        //poner Rol por defecto, se le pone el rol del id:1
        user.setRol(new Rol(1));


        return new ResponseEntity<>(usersRepository.save(user), HttpStatus.OK);

    }


    @PostMapping("/save")
    public String add(@RequestBody UserModel userModel){

        System.out.println(userModel);
        userService.saveUser(userModel);

        return "user agregado";
    }



}


