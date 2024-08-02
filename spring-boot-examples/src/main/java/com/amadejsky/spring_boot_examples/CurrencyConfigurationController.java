package com.amadejsky.spring_boot_examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
public class CurrencyConfigurationController {
    @Autowired
    private CurrenctServiceConfiguration configuration;
    @RequestMapping("/currency-configuration")
    public CurrenctServiceConfiguration retrieveAllCourses(){
        return configuration;
    }
}
