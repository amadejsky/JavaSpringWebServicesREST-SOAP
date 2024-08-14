package com.amadejsky.jpa.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class jdbcCommandLineRunner implements CommandLineRunner {
    @Autowired
    private JdbcRepository jdbcRepository;
    @Override
    public void run(String... args) throws Exception {
        jdbcRepository.insert();
    }
}
