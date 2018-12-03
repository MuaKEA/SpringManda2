package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.Repos.CourseRepository;
import com.example.demo.Repos.StuRepository;
import com.example.demo.Repos.WaitinglistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@Controller
public class StudentController {
    public Long Id;

    @Autowired
    private StuRepository stuRepo;
   @Autowired
   private CourseRepository courseRepository;
   @Autowired
   private WaitinglistRepo waitinglistRepo;

    @GetMapping("/studentMenu")
    public String adminMenu(){
        return "studentMenu";
    }

    @GetMapping("/add/createStudent")
    public String createstudent(Model model) {
        model.addAttribute("student", new Student());

        return "createStudent";
    }

    @PostMapping("/add/createStudent")
    public String createstudent(Student student) {
        stuRepo.save(student);
        Id=student.getId();
        return "redirect:/chooseCourse";

    }

    @GetMapping("chooseCourse")
    public String choosecourse(Model model) {
        model.addAttribute("courseList", courseRepository.findAll());
        return "chooseCourse";
    }

    @PostMapping("chosecourse")
    public String choosecourse(@ModelAttribute WaitingList waitingList,@RequestParam(value = "courseids[]") Long[] courseList) {
        for (int i = 0; i <courseList.length ; i++) {
        WaitingList w=new WaitingList();
        Student student= stuRepo.findById(Id).get();
        Course course = courseRepository.findById(courseList[i]).get();
        w.setCourse(course);
        w.setStudent(student);
        waitinglistRepo.save(w);


        }
        return "redirect:/conformations";
    }

    @GetMapping("/conformations")
    public String conformations(Model model){
      List<WaitingList> waitingLists=waitinglistRepo.findAllById(Id);

       return "conformations";
    }

//Post mangler




}