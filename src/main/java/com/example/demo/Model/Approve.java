package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Approve {
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Id
        private Long id;
        private Long Studentid;
        private Long Courseid;

        public Approve(Long studentid, Long courseid) {
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
