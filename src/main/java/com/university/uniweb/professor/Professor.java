package com.university.uniweb.professor;

import com.university.uniweb.course.Course;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
//@Builder
@Table(
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email_address"
        )
)
public class Professor {

    @Id
    @SequenceGenerator(
            name = "professor_sequence",
            sequenceName = "professor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "professor_sequence"
    )
    private Integer professorId;

    private String firstName;
    private String lastName;
    @Column(name = "email_address",
            nullable = false)
    private String email;




    @ManyToMany
    @JoinTable(name = "teach",
                joinColumns =@JoinColumn(name="professorid"),
                inverseJoinColumns = @JoinColumn(name="courseid"))
    private List<Course> courseList = new ArrayList<>();

    public Professor() {
    }

    public Professor(String firstName, String lastName, String email, List<Course> courseList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.courseList = courseList;
    }

    public Professor(Integer professorId, String firstName, String lastName, String email) {
        this.professorId = professorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }

    public Integer getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourseList() {
        return courseList;
    }
    @Override
    public String toString() {
        return "Professor{" +
                "professorId=" + professorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @ManyToMany
    private Collection<Course> courses;

    public Collection<Course> getCourses() {
        return courses;
    }

    public void setCourses(Collection<Course> courses) {
        this.courses = courses;
    }
}
