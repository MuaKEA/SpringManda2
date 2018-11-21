package com.example.demo.Controller;

import com.example.demo.Model.Course;
import com.example.demo.Model.CourseRepository;
import com.example.demo.Model.StuRepository;
import com.example.demo.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class StudentController {

    @Autowired
    private StuRepository stuRepo;



    @GetMapping("/add/createStudent")
    public String createstudent(Model model){
        model.addAttribute("student", new Student());

        return "createStudent";
    }

    @PostMapping("/add/createStudent")
    public String createstudent(Student student){

        stuRepo.save(student);
        return "redirect:/search/courses";

    }


}
