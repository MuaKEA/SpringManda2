package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student extends Person{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String adress;
    private int postcode;
    private Long mobil;
    private Long courseId;


    public Student(String firstName, String lastName, String adress, int postcode, Long mobil, Long courseId) {
        super(firstName, lastName);
        this.adress = adress;
        this.postcode = postcode;
        this.mobil = mobil;
        this.courseId = courseId;
    }

    public Student(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public Long getMobil() {
        return mobil;
    }

    public void setMobil(Long mobil) {
        this.mobil = mobil;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseIdd(int studentid) {
        this.courseId = courseId;
    }
}
