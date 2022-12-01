package com.university.uniweb.professor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class ProfessorRepositoryTest {

    @Autowired
    private  ProfessorRepository professorRepository;

//    @Test
//    public void saveProfessor(){
//        Professor professor = Professor.builder()
//                .firstName("Nikolas")
//                .lastName("Samaras")
//                .email("samNik@uom.edu.gr")
//                .build();
//
//        professorRepository.save(professor);
//    }

    @Test
    public void printAllProfessors(){
        List<Professor> professorList = professorRepository.findAll();

        System.out.println("Professors List: " + professorList);
    }
}