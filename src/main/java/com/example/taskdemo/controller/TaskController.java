package com.example.taskdemo.controller;

import com.example.taskdemo.model.Task;
import com.example.taskdemo.model.User;
import com.example.taskdemo.service.TaskService;
import com.example.taskdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/save")
    public String add(@RequestBody Task task){
        taskService.saveTask(task);

        return "task agregado";
    }
}


