package com.amadejsky.rest_management.controller;

import com.amadejsky.rest_management.exceptions.UserNotFoundException;
import com.amadejsky.rest_management.models.User;
import com.amadejsky.rest_management.service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user = userDaoService.findById(id);
        if(user==null)
            throw new UserNotFoundException("id: "+id);
        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.save(user);
        int userId = user.getId();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(
                        savedUser.getId()
                ).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/users/{id}")
    public List<User> deleteUser(@PathVariable int id){
        User user = userDaoService.findById(id);
        if(user==null)
            throw new UserNotFoundException("id: "+id);
        userDaoService.deleteUser(id);
        return userDaoService.findAll();
    }

}
