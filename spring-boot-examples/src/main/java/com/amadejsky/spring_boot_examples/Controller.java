package com.amadejsky.spring_boot_examples;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
public class Controller {
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
                new Course(1,"Learn Docker","dockerCaptain"),
                new Course(2,"Learn AWS","in28"),
                new Course(3,"Angular2024","W.Schwarzmuller")
        );
    }
}
