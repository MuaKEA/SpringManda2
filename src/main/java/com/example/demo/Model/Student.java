package com.example.demo.Model;

public class Student extends Person{
    private Long id;
    private String firstname;
    private String lastName;

    public Student(String firstName, String lastName, String course){
        super(firstName, lastName, course);
    }
}
