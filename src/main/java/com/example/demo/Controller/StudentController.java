package com.example.demo.Controller;

import com.example.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentController {
    public Long Id;

    @Autowired
    private StuRepository stuRepo;
   @Autowired
   private CourseRepository courseRepository;
   @Autowired
   private WaitinglistRepo waitinglistRepo;

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

    @GetMapping("chosecourse")
    public String choosecourse(Model model) {
      model.addAttribute("courseList", courseRepository.findAll());
        return "chooseCourse";
    }

    @PostMapping("chosecourse")
    public String choosecourse(@ModelAttribute Course course) {

        waitinglistRepo.save(new waitingList(Id,course.getId()));
        return "redirect:/conformations";
    }

@GetMapping("/conformations")
public String conformations(Model model,@RequestParam(defaultValue = "1") Long[] courseList){
    for (int i = 0; i <courseList.length ; i++) {
        waitinglistRepo.save(new waitingList(Id,courseList[i]));
    }
        model.addAttribute("conformation",waitinglistRepo.findById(Id));
        model.addAttribute("signedCourses",waitinglistRepo);


        return "conformations";
    }




}