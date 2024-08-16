package com.amadejsky.rest_management.controller;

import com.amadejsky.rest_management.exceptions.UserNotFoundException;
import com.amadejsky.rest_management.models.Post;
import com.amadejsky.rest_management.models.User;
import com.amadejsky.rest_management.repository.PostRepository;
import com.amadejsky.rest_management.repository.UserRepository;
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
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJPAController {
    private MessageSource messageSource;

    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserJPAController(MessageSource messageSource, UserRepository userRepository, PostRepository postRepository) {
        this.messageSource = messageSource;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }


    //    public UserResource(UserDaoService userDaoService) {
//        this.userDaoService = userDaoService;
//    }
    @GetMapping(path = "/jpa/users", produces = "application/json")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(path = "/jpa/users/{id}", produces = "application/json")
    public EntityModel<User> retrieveUserById(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
        if(user==null)
            throw new UserNotFoundException("id: "+id);
        EntityModel<User> entityModel = EntityModel.of(user.get());
        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @PostMapping(path = "/jpa/users", produces = "application/json")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);
        Long userId = user.getId();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(
                        savedUser.getId()
                ).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/jpa/users/{id}")
    public List<User> deleteUser(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
//        if(user==null)
//            throw new UserNotFoundException("id: "+id);
        userRepository.deleteById(id);
        return userRepository.findAll();
    }
    @GetMapping(path = "/jpa/users/{id}/posts")
    public List<Post> fetchPostsForUser(@PathVariable Long id){
        Optional<User> user = userRepository.findById(id);
//        if(user==null)
//            throw new UserNotFoundException("id: "+id);
        return user.get().getPosts();
    }
    @PostMapping(path = "/jpa/users/{id}/posts")
    public ResponseEntity<Post> createPostsForUser(@PathVariable Long id, @Valid @RequestBody Post post){
        Optional<User> user = userRepository.findById(id);
//        if(user==null)
//            throw new UserNotFoundException("id: "+id);
        post.setUser(user.get());
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(
                        savedPost.getId()
                ).toUri();
        return ResponseEntity.created(location).build();
    }

        @GetMapping(path="/jpa/test-i18")
    public String helloWorldInternationalized(){
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"Default message",locale);
    }

}
