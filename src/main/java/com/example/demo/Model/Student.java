package com.example.demo.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Student extends Person{
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public Student(String firstName, String lastName, String course){
        super(firstName, lastName, course);
    }


}
