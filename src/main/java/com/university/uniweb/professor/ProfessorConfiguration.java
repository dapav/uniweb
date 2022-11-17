package com.university.uniweb.professor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProfessorConfiguration {

    @Bean
    CommandLineRunner lineRunner(ProfessorRepository repository){
        return args -> {
            Professor alex =
                    new Professor(1,
                            "Alexandros",
                            "Xatzi",
                            "xatz@uom.edu.gr");
            repository.saveAll(List.of(alex));
        };
    }
}
