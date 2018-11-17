package com.example.demo.Model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Teacher extends Person {
    @GeneratedValue(strategy = GenerationType.AUTO)
}
