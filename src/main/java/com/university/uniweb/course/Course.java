package com.university.uniweb.course;

import com.university.uniweb.professor.Professor;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Integer courseId;

    //Define column Name
    @Column(name = "Title")
    private String courseName;




    @ManyToMany(mappedBy = "courseList")
    private List<Professor> professorList =new ArrayList<>();
    public Course() {
    }

    public Course(String courseName) {
        this.courseName = courseName;

    }

    public Course(Integer courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;

    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Professor> getProfessorList() {
        return professorList;
    }

    public Course(String courseName, List<Professor> professorList) {
        this.courseName = courseName;
        this.professorList = professorList;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
