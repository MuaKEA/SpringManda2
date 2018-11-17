package com.example.demo.Controller;

import com.example.demo.Model.StuRepository;
import com.example.demo.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StudentController {

    @Autowired
    private StuRepository stuRepo;

    @GetMapping("/view/courses")
        public String frontPage(){

        return "index";
    }
}

    /*public ResponseEntity<Student> getStudent(@PathVariable Long id) {

    }

}
*/