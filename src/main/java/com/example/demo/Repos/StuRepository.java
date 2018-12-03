package com.example.demo.Repos;

import com.example.demo.Model.Person;
import com.example.demo.Model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StuRepository extends CrudRepository<Student,Long>{

    Person findByEmail(String email);

}

