package com.example.demo.Repos;

import com.example.demo.Model.Course;
import com.example.demo.Model.Student;
import com.example.demo.Model.WaitingList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {
    List<Course> findAll();


}
