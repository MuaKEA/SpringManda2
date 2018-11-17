package com.example.demo.Controller;

import com.example.demo.Model.MyArrayList;
import com.example.demo.Model.StuRepository;
import com.example.demo.Model.Student;
import org.apache.catalina.ssi.ResponseIncludeWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class StudentController {


    @Autowired
    private StuRepository stuRepo;



    @GetMapping("/view/courses")
        public ResponseEntity<MyArrayList> viewCourse(Model model){
        MyArrayList<Student> students = (MyArrayList<Student>) StuRepository.findAll();
        model.addAttribute("shadush",students);
        return new ResponseEntity(students, HttpStatus.OK);
    }

    @PostMapping("/search/courses")
    public ResponseEntity<MyArrayList> signUpForCourse(Student student){
        Student stud = StuRepository.save(student);
        return new ResponseEntity(stud, HttpStatus.OK);
    }

}
