package com.amadejsky.jpa.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepository {
    @Autowired
    private JdbcTemplate jdbc;
    private static String INSERT_QUERY =
                """
                        insert into course(id, name, author)
                        values(1,'Angular','Muller');
                """;
    public void insert(){
        jdbc.update(INSERT_QUERY);
    };

}
