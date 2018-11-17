package com.example.demo.Controller;

import com.example.demo.Model.StuRepository;
import com.example.demo.Model.Student;
import org.apache.catalina.ssi.ResponseIncludeWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class StudentController {
    public  Object[] myArraylist = new Object[5];

    @Autowired
    private StuRepository stuRepo;



    @GetMapping("/view/courses")
        public ResponseEntity<MyArraylist> viewCourse(){
        myArraylist<Student> students = stuRepo.findAll();
        return new ResponseEntity(students, HttpStatus.OK);
    }
}
