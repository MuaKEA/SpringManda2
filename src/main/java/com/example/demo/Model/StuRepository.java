package com.example.demo.Model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StuRepository extends CrudRepository<Student,Long>{

    List<Student> findByCourseId(Long id);

}

