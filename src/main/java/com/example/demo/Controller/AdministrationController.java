package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.Repos.CourseRepository;
import com.example.demo.Repos.StuRepository;
import com.example.demo.Repos.TeacherRepo;
import com.example.demo.Repos.WaitinglistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class AdministrationController {
    @Autowired
    public StuRepository studentRepo;
    @Autowired
    public CourseRepository courseRepo;
    @Autowired
    public WaitinglistRepo waitinglistRepo;
    @Autowired
    public TeacherRepo teacherRepo;


    @GetMapping("/adminMenu")
    public String adminMenu(){
        return "adminMenu";
    }

    @GetMapping("/getStudentApprovalList")
    public String studentApproval(Model model){



             return "approvalList";
    }


    @GetMapping("/createTeacher")
    public String createTeacher(Model model){
        model.addAttribute("teacher",new Teacher());



        return "CreateTeachers";
    }
      @PostMapping("/createTeacher")
      public String createTeacher(Teacher teacher){
        teacherRepo.save(teacher);



        return "redirect:/index";


      }

    @GetMapping("/waitinglist")
    public String waitingList(Model model){
        System.out.println(waitinglistRepo.findAll());


        return "waitinglist";
    }

    @PostMapping("/waitinglist")
    public String waitinglist(WaitingList waitingList) {


        return "redirect:/";
    }

}
