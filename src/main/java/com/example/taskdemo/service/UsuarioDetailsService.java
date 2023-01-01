package com.example.taskdemo.service;

import com.example.taskdemo.model.UserModel;
import com.example.taskdemo.repository.RolRepository;
import com.example.taskdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioDetailsService implements UserDetailsService  {


    @Autowired
    UserRepository usersRepository;

    @Autowired
    RolRepository rolRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel user = usersRepository.findByEmail(username);

        List< GrantedAuthority> rol = new ArrayList<>();
        rol.add(new SimpleGrantedAuthority(user.getRol().getRol()));

        UserDetails userDetails = new User(user.getEmail(),user.getPassword(),rol);

        return userDetails;


    }
}

