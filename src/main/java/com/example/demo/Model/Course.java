package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String courseName;
    private String Course_language;
    private Integer ECTS;
    private Integer min_students;
    private Integer max_students;
    private Integer expectednumber;
    private String Prerequisites;
    private String Learning_outcome;
    private String Content;
    private String Learning_activities;
    private String Examform;
    private String Teachers;


    public Course(String courseName, String course_language, Integer ECTS, Integer min_students, Integer max_students, Integer expectednumber, String prerequisites, String learning_outcome, String content, String learning_activities, String examform, String teachers) {
        this.courseName = courseName;
        this.Course_language = course_language;
        this.ECTS = ECTS;
        this.min_students = min_students;
        this.max_students = max_students;
        this.expectednumber = expectednumber;
        this.Prerequisites = prerequisites;
        this.Learning_outcome = learning_outcome;
        this.Content = content;
        this.Learning_activities = learning_activities;
        this.Examform = examform;
        this.Teachers = teachers;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourse_language() {
        return Course_language;
    }

    public void setCourse_language(String course_language) {
       this.Course_language = course_language;
    }

    public Integer getECTS() {
        return ECTS;
    }

    public void setECTS(Integer ECTS) {
        this.ECTS = ECTS;
    }

    public Integer getMin_students() {
        return min_students;
    }

    public void setMin_students(Integer min_students) {
        this.min_students = min_students;
    }

    public Integer getMax_students() {
        return max_students;
    }

    public void setMax_students(Integer max_students) {
        this.max_students = max_students;
    }

    public Integer getExpectednumber() {
        return expectednumber;
    }

    public void setExpectednumber(Integer expectednumber) {
        this.expectednumber = expectednumber;
    }

    public String getPrerequisites() {
        return Prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.Prerequisites = prerequisites;
    }

    public String getLearning_outcome() {
        return Learning_outcome;
    }

    public void setLearning_outcome(String learning_outcome) {
        this.Learning_outcome = learning_outcome;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
       this.Content = content;
    }

    public String getLearning_activities() {
        return Learning_activities;
    }

    public void setLearning_activities(String learning_activities) {
        this.Learning_activities = learning_activities;
    }

    public String getExamform() {
        return Examform;
    }

    public void setExamform(String examform) {
        this.Examform = examform;
    }

    public String getTeachers() {
        return Teachers;
    }

    public void setTeachers(String teachers) {
        this.Teachers = teachers;
    }
}
