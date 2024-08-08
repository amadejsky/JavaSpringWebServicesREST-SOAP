package com.amadejsky.rest_management.controller;

import com.amadejsky.rest_management.models.User;
import com.amadejsky.rest_management.service.UserDaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserResource {
    private UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }
    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUserById(@PathVariable int id){
        return userDaoService.findById(id);
    }

}
