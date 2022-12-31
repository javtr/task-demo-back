package com.example.taskdemo.service;

import com.example.taskdemo.model.Task;
import com.example.taskdemo.model.User;
import com.example.taskdemo.repository.TaskRepository;
import com.example.taskdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    public Task saveTask(Task task){
        return taskRepository.save(task);
    }


}
