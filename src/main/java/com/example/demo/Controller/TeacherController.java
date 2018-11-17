package com.example.demo.Controller;

import com.example.demo.Model.Course;
import com.example.demo.Model.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TeacherController {

    @Autowired
    public CourseRepository courseRepository;


    @GetMapping("/Teacher/addcourse")
    public String Createcourse(Model model){
        model.addAttribute("course",new Course());



        return "Createcourse";
    }

    @PostMapping("/Teacher/addcourse")
    public String Createcourse(@ModelAttribute Course course){
        courseRepository.save(course);


        return "redirect:/ShowCourses";
    }


    @GetMapping("/Teacher/ShowCourses")
    public String showCourse(Model model){
        model.addAttribute("List",courseRepository.findAll());


     return"ShowCourses";
    }


    @PostMapping("/Teacher/deletecourse")
    public String delete(){


return "redirect:/ShowCourses";
    }








}
