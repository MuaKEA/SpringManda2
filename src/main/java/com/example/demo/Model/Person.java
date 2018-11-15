package com.example.demo.Model;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Person {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String course;
    public Person(){}

    public Person(Long id, String firstName, String lastName, String course) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse(){
        return course;
    }

    public void setCourse(String course){
        this.course = course;
    }

}
