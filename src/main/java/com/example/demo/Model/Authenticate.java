package com.example.demo.Model;

import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authenticate {
    public static boolean isLoggedIn(HttpSession session){
        return session.getAttribute("ID") != null;
    }

    /*public static boolean login(String userName, String passWord, HttpSession session)throws SQLException {
        ResultSet resultSet = DataBaseConnection.query("SELECT * FROM users WHERE")
    }
    */
}
