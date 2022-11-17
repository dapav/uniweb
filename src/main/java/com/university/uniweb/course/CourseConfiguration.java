package com.university.uniweb.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CourseConfiguration {

    @Bean
    CommandLineRunner comLRun(CourseRepository repository){
        return args -> {
            Course java = new Course(
                    101,"Introduction to Java OOP") ;
            Course maths = new Course(202,"Descrete Math");

            repository.saveAll(List.of(
                    java,maths
            ));
        };

    }
}
