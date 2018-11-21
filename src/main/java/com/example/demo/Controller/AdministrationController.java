//package com.example.demo.Controller;
//
//import com.example.demo.Model.CourseRepository;
//import com.example.demo.Model.StuRepository;
//import com.example.demo.Model.Student;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import java.util.List;
//
//@Controller
//public class AdministrationController {
//    @Autowired
//    public StuRepository studentRepo;
//
//    @GetMapping("/getStudentList/{id}")
//    public String showStudentList(@PathVariable Long id){
//        Student john = new Student("John", "Pedersen", "Johnvej", 2770, 23457556L, "hahachi@some.dk");
//        Student erik = new Student("Erik", "Pedersen", "Erikvej", 2770, 23564556L, "hahachi@some.dk");
//        studentRepo.save(john);
//        studentRepo.save(erik);
//        List<Student> list = studentRepo.findByCourseId(id);
//        System.out.println(list.size());
//        return "studentList";
//    }
//
//    @GetMapping("/getStudentApprovalList")
//    public String studentApproval(){
//
//        return "approvalList";
//    }
//
//
//
//
//
//
//
//
//
//
//}
