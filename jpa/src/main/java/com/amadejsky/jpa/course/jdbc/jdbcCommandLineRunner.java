package com.amadejsky.jpa.course.jdbc;

import com.amadejsky.jpa.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class jdbcCommandLineRunner implements CommandLineRunner {
    @Autowired
    private JdbcRepository jdbcRepository;
    @Override
    public void run(String... args) throws Exception {
        jdbcRepository.insert(new Course(1,"Angular2024","Muller"));
        jdbcRepository.insert(new Course(2,"LinuxAdmCommandL","H.Landa"));
        jdbcRepository.delete(2);
//        System.out.println(jdbcRepository.selectByIdMappingObject(1));
//        System.out.println(jdbcRepository.selectByIdMappingObject(2));
//        System.out.println(jdbcRepository.selectByIdMappingObject());
    }
}
