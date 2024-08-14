package com.amadejsky.jpa.course.jdbc;

import com.amadejsky.jpa.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepository {
    @Autowired
    private JdbcTemplate jdbc;
    private static String INSERT_QUERY =
            """
                    insert into courses(id, name, author)
                    values(?,?,?);
            """;
    private static String DELETE_QUERY =
            """
                    delete from courses
                    where id = ?;
            """;
    private static String SELECT_QUERY =
            """
                    select * from courses
                    where id = ?;
            """;
    public void insert(Course course){
        jdbc.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
    };
    public void delete(long id){
        jdbc.update(DELETE_QUERY,id);
    }

//    public void selectbyId(long id){
//        jdbc.update(SELECT_QUERY,id);
//    }
    public Course selectByIdMappingObject(long id){
        return jdbc.queryForObject(SELECT_QUERY,
                new BeanPropertyRowMapper<>(Course.class),id);
    }

}
