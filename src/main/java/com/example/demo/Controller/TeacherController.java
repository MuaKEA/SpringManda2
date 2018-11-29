package com.example.demo.Controller;

import com.example.demo.Model.Course;
import com.example.demo.Model.CourseRepository;
import com.example.demo.Model.StuRepository;
import com.example.demo.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    public CourseRepository courseRepository;
    @Autowired
    public StuRepository studrepo;




    @GetMapping("/createcourse")
    public String Createcourse(Model model){
        model.addAttribute("course",new Course());

        return "save_course";
    }

    @PostMapping("/createcourse")
    public String Createcourse(Course course){
        for (int i = 0; i <10 ; i++) {
            Course c= new Course("name","english",30,20,40,30,"none","none","math&shadush","shafush","oral&report","alex");
            courseRepository.save(c);
        }
        courseRepository.save(course);

        return "redirect:/ShowCourses";
    }


    @GetMapping("/ShowCourses")
    public String showCourse(Model model){
        model.addAttribute("List",courseRepository.findAll());

        return"ShowCourses";
    }


    @GetMapping("/deletecourse")
    public String delete(@RequestParam(value = "id", defaultValue = "1") Long id){
        courseRepository.deleteById(id);

        return "redirect:/ShowCourses";
    }

    @GetMapping("/editcourse")
    public String editcourse(@RequestParam(value = "id", defaultValue = "1") Long id, Model model){

        model.addAttribute("course",courseRepository.findById(id));
        return "editCourses";
    }

    @PostMapping("/editcourse")
    public String editcourse(Course course){
        courseRepository.save(course);


        return "redirect:/ShowCourses";
    }


}










