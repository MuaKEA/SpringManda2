package com.example.demo.Model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class waitingList {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private Long Studentid;
    private Long Courseid;

    public waitingList(Long studentid, Long courseid) {
        Studentid = studentid;
        Courseid = courseid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentid() {
        return Studentid;
    }

    public void setStudentid(Long studentid) {
        Studentid = studentid;
    }

    public Long getCourseid() {
        return Courseid;
    }

    public void setCourseid(Long courseid) {
        Courseid = courseid;
    }
}
