package com.amadejsky.jpa.course.jpa;

import com.amadejsky.jpa.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
    public List<Course> findByAuthor(String author);
    public List<Course> findByName(String course);
}
