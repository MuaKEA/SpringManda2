package com.example.demo.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Teacher extends Person {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    public Teacher(){}

}
