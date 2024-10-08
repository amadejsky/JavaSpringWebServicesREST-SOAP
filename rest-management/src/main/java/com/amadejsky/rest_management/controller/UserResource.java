package com.amadejsky.rest_management.controller;

import com.amadejsky.rest_management.exceptions.UserNotFoundException;
import com.amadejsky.rest_management.models.User;
import com.amadejsky.rest_management.service.UserDaoService;
import jakarta.validation.Valid;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResource {
    private MessageSource messageSource;

    public UserResource(MessageSource messageSource, UserDaoService userDaoService) {
        this.messageSource = messageSource;
        this.userDaoService = userDaoService;
    }

    private UserDaoService userDaoService;

//    public UserResource(UserDaoService userDaoService) {
//        this.userDaoService = userDaoService;
//    }
    @GetMapping(path = "/users", produces = "application/json")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

    @GetMapping(path = "/users/{id}", produces = "application/json")
    public EntityModel<User> retrieveUserById(@PathVariable int id){
        User user = userDaoService.findById(id);
        if(user==null)
            throw new UserNotFoundException("id: "+id);
        EntityModel<User> entityModel = EntityModel.of(user);
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping(path = "/users", produces = "application/json")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        User savedUser = userDaoService.save(user);
        Long userId = user.getId();
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

        @GetMapping(path="/test-i18")
    public String helloWorldInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default message",locale);
    }

}
