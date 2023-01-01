package com.example.taskdemo.service;

import com.example.taskdemo.model.Rol;
import com.example.taskdemo.model.UserModel;
import com.example.taskdemo.repository.RolRepository;
import com.example.taskdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RolRepository rolRepository;



    @Autowired
    private UserRepository usersRepository;

    @PersistenceContext
    EntityManager em = null;

    @Autowired
    private JwtUtilService jwtUtil;



    public UserModel getUserByToker(String token)  {
        String usuario = jwtUtil.getUserName(token);

        UserModel user = new UserModel();

        if (usuario != null && usuario != "" ){

            user =  usersRepository.findByEmail(usuario);
            user.setPassword("");

        }else{
            return null;
        }

        return user;
    }


    public UserModel saveUser(UserModel userModel){

        if(rolRepository.existsById(1)){
            Rol rol = rolRepository.findById(1).get();
            userModel.setRol(rol);
        }

        System.out.println(userModel);

        return userRepository.save(userModel);
    }


}
