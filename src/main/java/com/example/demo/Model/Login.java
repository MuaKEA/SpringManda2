//package com.example.demo.Model;
//
//
//
//import com.example.demo.Repos.StuRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpSession;
//import java.sql.SQLException;
//
//@Service
//public class Login {
//
//    @Autowired
//    private StuRepository stuRepository;
//
//
//    public boolean isLoggedIn(HttpSession session) {
//        return session.getAttribute("ID") != null;
//    }
//
//    public boolean login(String email, String password, HttpSession httpSession) throws SQLException {
//        Person person = stuRepository.findByEmail(email);
//        if (checkUsername(email) & checkPassword(password, person.getPassword())) {
//            httpSession.setAttribute("ID", person.getId());
//            httpSession.setAttribute("NIVEAU", person.getNiveau());
//            return true;
//        }
//        return false;
//    }
//
//    public  void logout(HttpSession session) {
//        session.removeAttribute("ID");
//        session.removeAttribute("NIVEAU");
//
//    }
//
//    public  boolean checkPassword(String password, String hashed) {
//        return BCrypt.checkpw(password, hashed);
//    }
//
//    private boolean checkUsername(String email) {
//        List<Person> persons = (List<Person>) personRepo.findAll();
//        for (Person person : persons) {
//            if (person.getEmail().equals(email))
//                return true;
//        }
//        return false;
//    }
//}
//
