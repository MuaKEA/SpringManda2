package com.example.demo.Controller;

import com.example.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdministrationController {
    @Autowired
    public StuRepository studentRepo;
    public CourseRepository courseRepo;
    @Autowired
    public WaitinglistRepo waitinglistRepo;
    /*@GetMapping("/chooseCourse")
    public String chooseCourse(){
        return "chooseCourse";
    }
    @PostMapping("/chooseCourse")
    public String chooseCoursePost(Long id){

        return "redirect:/getStudentList/" + id;
    }

    @GetMapping("/getStudentList/{id}")
    public String showStudentList(@PathVariable Long id, Model model){
        //Student john = new Student("John", "Pedersen", "Johnvej", 2770, "Kastrup", 23457556L, "John@hotmail.com", 1L);
        //Student erik = new Student("Erik", "Pedersen", "Erikvej", 2770, "Kastrup", 23564556L, "Erik@hotmail.com",2L);
        //studentRepo.save(john);
        //studentRepo.save(erik);
        List<Student> list = studentRepo.findByCourseId(id);
        model.addAttribute("studentView", list);
        //System.out.println(list.size());
        return "studentList";
    }*/

    @GetMapping("/getStudentList")
    public String showStudentList(Model model, @RequestParam(value = "id", defaultValue = "1") Long id){
        //Student john = new Student("John", "Pedersen", "Johnvej", 2770, "Kastrup", 23457556L, "John@hotmail.com");
       // Student erik = new Student("Erik", "Pedersen", "Erikvej", 2770, "Kastrup", 23564556L, "Erik@hotmail.com");
        //studentRepo.save(john);
        //studentRepo.save(erik);
        //id = 0L;
        //model.addAttribute("id", id);

        return "studentList";
    }



    @GetMapping("/adminMenu")
    public String adminMenu(){
        return "adminMenu";
    }

    @GetMapping("/getStudentApprovalList")
    public String studentApproval(Model model){





                     model.addAttribute("coursesList", waitinglistRepo.findAll());




             return "approvalList";
    }








}
