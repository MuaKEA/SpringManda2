package com.example.demo.Controller;

import com.example.demo.Model.CourseRepository;
import com.example.demo.Model.StuRepository;
import com.example.demo.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdministrationController {
    @Autowired
    public StuRepository studentRepo;

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
    public String showStudentList(@PathVariable Long id, Model model){
        //Student john = new Student("John", "Pedersen", "Johnvej", 2770, "Kastrup", 23457556L, "John@hotmail.com", 1L);
        //Student erik = new Student("Erik", "Pedersen", "Erikvej", 2770, "Kastrup", 23564556L, "Erik@hotmail.com",2L);
        //studentRepo.save(john);
        //studentRepo.save(erik);
        model.addAttribute("id", id);
        List<Student> list = studentRepo.findByCourseId(id);
        model.addAttribute("studentView", list);
        //System.out.println(list.size());
        return "studentList";
    }

    @GetMapping("/getStudentApprovalList")
    public String studentApproval(){

        return "approvalList";
    }










}
