package com.university.uniweb.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {

    @Query("select c from Course c where c.courseId=?1")
    Optional<Course> findCourseByCourseId(Integer courseId);
}
