package com.example.demo.Model;

import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.Entity;

public class Administration extends Person {
private String course;


    public Administration(String firstName, String lastName, String course){
        super(firstName, lastName, course);

}


}
