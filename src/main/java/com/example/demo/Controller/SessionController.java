package com.example.demo.Controller;

import com.example.demo.Controller.Auth.Authenticate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SessionController {
    private boolean loginFailed = false;

    @GetMapping("/logout")
    public String logout(HttpSession session){
        Authenticate.logOut(session);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String viewLogin(Model model){
        model.addAttribute("loginFailed", loginFailed);
        return "/login";
    }
}
