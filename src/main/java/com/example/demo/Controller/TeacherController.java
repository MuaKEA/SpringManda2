package com.example.demo.Controller;

import com.example.demo.Model.Course;
import com.example.demo.Model.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String Createcourse(Course course){
        courseRepository.save(course);
        return "redirect:/ShowCourses";
    }


    @GetMapping("/view/courses")
    public String showCourse(Model model){
        model.addAttribute("List",courseRepository.findAll());


        return"ShowCourses";
    }


    @DeleteMapping("/Teacher/deletecourse")
    public String delete(@RequestParam(value = "ID", defaultValue = "1") Long id){
        courseRepository.deleteById(id);

        return "redirect:/ShowCourses";
    }

    @GetMapping("/Teacher/editcourse")
    public String editcourse(@RequestParam(value = "ID", defaultValue = "1") Long id, Model model){

        model.addAttribute("course",courseRepository.findById(id));
        return "editCourses";
    }

    @PutMapping("/Teacher/editcourse")
    public String editcourse(Course course){
        courseRepository.save(course);


        return "redirect:/ShowCourses";
    }
}










