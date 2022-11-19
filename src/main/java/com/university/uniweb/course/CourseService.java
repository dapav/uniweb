package com.university.uniweb.course;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CourseService {


    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    //A method to get create new course
    public void registerNewCourse(Course course){
        Optional<Course> courseOptional = courseRepository.findCourseByCourseId(course.getCourseId());
        if(courseOptional.isPresent()){
            throw new IllegalStateException("Course exists");
        }
        courseRepository.save(course);
    }

    public void deleteCourse(Integer courseId) {
        boolean exists = courseRepository.existsById(courseId);
        if(!exists){
            throw new IllegalStateException("Course with Id " + courseId + " does not exists");
        }
        courseRepository.deleteById(courseId);
    }

    @Transactional
    public void updateCourse(Integer courseId,String courseName){
        Course course = courseRepository.findById(courseId)
                .orElseThrow(()->new IllegalStateException("Course does not exists"));

        if(courseName!= null && !Objects.equals(course.getCourseName(),courseName)){
            course.setCourseName(courseName);
        }
    }
}
