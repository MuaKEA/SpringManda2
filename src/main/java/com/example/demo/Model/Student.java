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
    private String address;
    private int postcode;
    private String city;
    private String email;
    private Long tlf;
    private Long courseId;


    public Student(String firstName, String lastName, String address, int postcode, String city, Long tlf, String email, Long courseId) {
        super(firstName, lastName);
        this.address = address;
        this.postcode = postcode;
        this.tlf = tlf;
        this.courseId = courseId;
        this.city = city;
        this.email = email;
    }

    public Student(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTlf() {
        return tlf;
    }

    public void setTlf(Long tlf) {
        this.tlf = tlf;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
