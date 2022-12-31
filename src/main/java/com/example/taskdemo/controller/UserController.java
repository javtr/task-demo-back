package com.example.taskdemo.controller;

import com.example.taskdemo.model.User;
import com.example.taskdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String add(@RequestBody User user){

        System.out.println(user);
        userService.saveUser(user);

        return "user agregado";
    }
}


