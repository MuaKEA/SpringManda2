package com.example.demo.Controller;

import com.example.demo.Model.*;
import com.example.demo.Repos.CourseRepository;
import com.example.demo.Repos.StuRepository;
import com.example.demo.Repos.WaitinglistRepo;
import com.example.demo.Repos.loginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class StudentController {
    public Long Id;
    public String email;
    @Autowired
    private StuRepository stuRepo;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private WaitinglistRepo waitinglistRepo;
    @Autowired
    private loginRepository loginRepository;


    @GetMapping("/studentMenu{email}")
    public String adminMenu(@RequestParam(value = "email") String username) {
        System.out.println(username);
        Student student = stuRepo.findByEmail(username);
        Id = student.getId();

        return "studentMenu";
    }

    @GetMapping("/createStudent")
    public String createstudent(Model model) {
        model.addAttribute("student", new Student());

        return "createStudent";
    }

    @PostMapping("/createStudent")
    public String createstudent(Student student) {
        stuRepo.save(student);
        Id = student.getId();
        LoginTable loginTable = new LoginTable(student.getEmail(), "password", 2);
        loginRepository.save(loginTable);
        return "redirect:/chooseCourse";

    }

    @GetMapping("chooseCourse")
    public String choosecourse(Model model) {
        model.addAttribute("courseList", courseRepository.findAll());
        return "chooseCourse";
    }

    @PostMapping("choosecourse")
    public String choosecourse(@ModelAttribute WaitingList waitingList, @RequestParam(value = "courseids[]") Long[] courseList) {
        for (int i = 0; i < courseList.length; i++) {
            WaitingList w = new WaitingList();
            Student student = stuRepo.findById(Id).get();
            Course course = courseRepository.findById(courseList[i]).get();
            w.setCourse(course);
            w.setStudent(student);
            w.setDate(w.getcurrentdate());
            w.setAssigned(false);
            waitinglistRepo.save(w);
        }
        return "redirect:/";
    }

    @GetMapping("/myCourses")
    public String myCourses(Model model) {
        model.addAttribute("studentList", waitinglistRepo.findByStudentIdAndAssigned(Id, true));

        return "myCourses";
    }

    @GetMapping("/studentList")
    public String studentList(Model model) {
        MyArrayList<Course> courseMyArrayList = new MyArrayList<>();

        for (WaitingList w : waitinglistRepo.findByAssigned(true)) {
            courseMyArrayList.add(w.getCourse());

        }
        model.addAttribute("couseList", courseMyArrayList);
        model.addAttribute("studentList", stuRepo.findStudentById(Id));

        return "studentList";
    }


}

