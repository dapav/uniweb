package com.university.uniweb.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student davor = new Student(1L,"Davor","Pavits","davor1@gmail.com");
            Student mia = new Student(2L,"Mia","Pavits","mia2@gmail.com");

            repository.saveAll(
                    List.of(davor,mia)
            );
        };
    }

}
