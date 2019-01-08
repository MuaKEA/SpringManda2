package com.example.demo.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class minetester {

    public static void main(String[] args) {

        ArrayList<String> hallo= new ArrayList<>();

        for (int i = 0; i <10 ; i++) {
            hallo.add(i + "");
        }
        System.out.println(hallo);
        hallo.add(3,"hallo world");
        System.out.println(hallo);

    }

}
