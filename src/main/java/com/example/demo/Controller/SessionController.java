package com.example.demo.Controller;

import com.example.demo.Model.Login;
import com.example.demo.Model.LoginTable;
import com.example.demo.Repos.loginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class SessionController {

    @Autowired
    private loginRepository LoginRepository;

	private boolean loginFailed = false;

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        Login.logout(session);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String viewLogin(Model model) {
	    model.addAttribute("loginFailed", loginFailed);
        return "redirect:/login";
    }



    public  boolean login(String email, String password, HttpSession httpSession)  {

        System.out.println("#" +email + "#");
        System.out.println("#"+password + "#");

        LoginTable test = LoginRepository.findByEmail(email);


        if (checkUsername(email) & checkPassword(password)) {
            httpSession.setAttribute("ID", test.getId());
            httpSession.setAttribute("NIVEAU", test.getNiveau());
            return true;
        }
        return false;
    }

    public  boolean checkPassword(String password) {
        List<LoginTable> passwords=LoginRepository.findByPassword(password);

        for (LoginTable l : passwords) {

            if (password.equals(l.getPassword()));
            return true;

        }

        return false ;
    }
    private  boolean checkUsername(String email) {
        List<LoginTable> users = LoginRepository.findAll();
        for (LoginTable loginTable : users) {
            if (loginTable.getEmail().equals(email))
                return true;
        }
        return false;
    }


    @PostMapping("/login")
    public String login(
            @RequestParam("email") String username,
            @RequestParam("password") String password,
            @RequestParam(name = "action",defaultValue = "Log Ind" ) String action,
            HttpSession session)  {


        System.out.println(username);



        if(action.equals("Log Ind"))
            if (!login(username, password, session)) {
		        loginFailed = true;
	        } else {
		        loginFailed = false;
		        return ((int) session.getAttribute("NIVEAU")) == 1 ? "redirect:/teacherMenu" : ((int) session.getAttribute("NIVEAU")) == 2 ? "redirect:/studentMenu" : ((int) session.getAttribute("NIVEAU") == 3 ? "redirect:/adminMenu":"redirect:/" );
	        }


	    return "redirect:/";
    }
}
