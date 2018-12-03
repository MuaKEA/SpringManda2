package com.example.demo.Model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class WaitingList {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;


    @OneToOne
    private Course course;
    @ManyToOne
    private Student student;


    public WaitingList(Course course, Student student) {
        this.course = course;
        this.student = student;
    }

    public WaitingList(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
