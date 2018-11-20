package com.example.demo.Controller;

//import com.example.demo.Controller.Auth.Authenticate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class SessionController {
    private boolean loginFailed = false;
    /*
    @GetMapping("/logout")
    public String logout(HttpSession session){
        Authenticate.logOut(session);
        return "redirect:/";
    }
*/
    @GetMapping("/login")
    public String viewLogin(Model model){
        model.addAttribute("loginFailed", loginFailed);
        return "/login";
    }

   /* @PostMapping("/login")
    public String login(
        @RequestParam("username") String userName,
        @RequestParam("passWord") String passWord,
        @RequestParam("action") String action,
        HttpSession session) throws SQLException{

    if(action.equals("Log Ind"))
        if(!Authenticate.login(userName, passWord, session)){
            loginFailed = true;
        }else{
        loginFailed = false;
        return (int) session.getAttribute("NIVEAU") == 2 ? "redirect:/reservation/create" : (int) session.getAttribute("NIVEAU") == 1 ? "redirect:/login");
        }
    }
    }
    */

}
