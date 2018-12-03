package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.Repos.CourseRepository;
import com.example.demo.Repos.StuRepository;
import com.example.demo.Repos.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeacherController {
    @Autowired
    public CourseRepository courseRepository;
    @Autowired
    public StuRepository studrepo;
    @Autowired
    public TeacherRepo teacherRepo;

    @GetMapping("/teacherMenu")
    public String adminMenu(){
        return "teacherMenu";
    }

    @GetMapping("/createcourse")
    public String Createcourse(Model model){
        model.addAttribute("course",new Course());
        model.addAttribute("teacherList",teacherRepo.findAll());
        return "save_course";
    }

    @PostMapping("/createcourse")
    public String Createcourse(Course course){

        courseRepository.save(course);

        return "redirect:/ShowCourses";
    }


    @GetMapping("/ShowCourses")
    public String showCourse(Model model){
        model.addAttribute("studentList",courseRepository.findAll());

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










