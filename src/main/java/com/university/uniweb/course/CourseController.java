package com.university.uniweb.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/course")
public class CourseController {

    //Needs a connection to the service layer
    @Autowired
    private final CourseService courseService;//Create the constructor in the Course service class


    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping//Get-->Returns smth
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    @PostMapping
    public void registerNewCourse(@RequestBody Course course){
        courseService.registerNewCourse(course);
    }

    @DeleteMapping(path = "{courseId}")
    public void deleteCourse(@PathVariable("courseId") Integer courseId){
        courseService.deleteCourse(courseId);
    }

    @PutMapping(path = "{courseId}")
    public void updateCourse(
            @PathVariable("courseId") Integer courseId,
            @RequestParam(required = false) String courseName){
        courseService.updateCourse(courseId,courseName);
    }

}
