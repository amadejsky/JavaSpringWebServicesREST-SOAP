package com.amadejsky.jpa.course;

import com.amadejsky.jpa.course.jdbc.JdbcRepository;
import com.amadejsky.jpa.course.jpa.JPARepository;
import com.amadejsky.jpa.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {
    @Autowired
    private JdbcRepository jdbcRepository;

    @Autowired
    private JPARepository jpaRepository;
    @Override
    public void run(String... args) throws Exception {
//        jdbc
        jdbcRepository.insert(new Course(1,"Angular2024","Muller"));
        jdbcRepository.insert(new Course(2,"LinuxAdmCommandL","H.Landa"));
        jdbcRepository.delete(2);
//        System.out.println(jdbcRepository.selectByIdMappingObject(1));
//        System.out.println(jdbcRepository.selectByIdMappingObject(2));
// --------------------------
//        jpa
        jpaRepository.insert(new Course(3,"Docker","DCaptain"));
        jpaRepository.findById(2);
    }
}
