package com.example.demo.ApiController;


import com.example.demo.Model.Student;
import com.example.demo.Repos.StuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@SuppressWarnings("unchecked")
@RestController
public class StudentRest {

    @Autowired
    private StuRepository stuRepository;





@GetMapping("student/{id}")
public ResponseEntity<Student> getstudents(@PathVariable Long id) {

    return new ResponseEntity(stuRepository.findById(id),HttpStatus.OK);

}
@PutMapping("student/update/{id}")
public ResponseEntity<Student> updatestudent(@PathVariable Long id, @RequestParam String firstName,@RequestParam String lastName,@RequestParam String address,@RequestParam int postcode,@RequestParam String city ,@RequestParam String email,@RequestParam Long phone){


    Student student= new Student(firstName,lastName,address,postcode,city,email,phone);
    student.setId(id);
    stuRepository.save(student);



    return new ResponseEntity(student,HttpStatus.OK);
}
    @DeleteMapping("student/delete/{id}")
    public ResponseEntity<Student> delemapping(@PathVariable Long id) {
        Optional<Student> student =  stuRepository.findById(id);

        if(!student.isPresent()){
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }

     stuRepository.deleteById(id);
        return new ResponseEntity(student.get(),HttpStatus.ACCEPTED);

    }

    @PostMapping("student/new")
    public ResponseEntity<Student> saveCar(Student student){


         stuRepository.save(student);
        return new ResponseEntity(student, HttpStatus.OK);
    }

}
