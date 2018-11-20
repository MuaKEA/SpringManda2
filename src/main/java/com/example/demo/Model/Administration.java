package com.example.demo.Model;

import net.bytebuddy.implementation.bind.annotation.Super;

import javax.persistence.Entity;

public class Administration extends Person {

    public Administration() {
    }

    public Administration(String firstName, String lastName) {
        super(firstName, lastName);
    }
}



