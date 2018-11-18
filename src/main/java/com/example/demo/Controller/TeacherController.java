package com.example.demo.Controller;

import com.example.demo.Model.Course;
import com.example.demo.Model.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class TeacherController {

    @Autowired
    public CourseRepository courseRepository;


    @GetMapping("/add/courses")
    public String Createcourse(Model model){
        model.addAttribute("course",new Course());



        return "save_course";
    }

    @PostMapping("/add/courses")
    public String saveCar(Course course){
        courseRepository.save(course);
        return "redirect:/ShowCourses";
    }


    @GetMapping("/view/courses")
    public String showCourse(Model model){
        model.addAttribute("List",courseRepository.findAll());


     return"ShowCourses";
    }


    @PostMapping("/Teacher/deletecourse")
    public String delete(){


return "redirect:/ShowCourses";
    }









}
