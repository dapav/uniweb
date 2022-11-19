package com.university.uniweb.professor;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }


    public List<Professor> getProfessors(){
        return professorRepository.findAll();
    }


    public void addNewProfessor(Professor professor){
        Optional<Professor> professorOptional = professorRepository.findProfessorByEmail(professor.getEmail());
        if(professorOptional.isPresent()){
            throw new IllegalStateException("Email taken");
        }
        professorRepository.save(professor);
    }

    public void deleteProfessor(Integer professorId) {
        boolean exists = professorRepository.existsById(professorId);
        if(!exists){
            throw new IllegalStateException("Professor with " + professorId+" does not exists");
        }
        professorRepository.deleteById(professorId);
    }

    @Transactional
    public void updateProfessor(Integer professorId, String firstName, String lastName, String email){
        Professor professor = professorRepository.findById(professorId)
                .orElseThrow(()-> new IllegalStateException("Professor with id " + professorId + " does not exists"));


        if(firstName != null && !Objects.equals(professor.getFirstName(), firstName)){
            professor.setFirstName(firstName);
        }

        if(lastName!=null && !Objects.equals(professor.getLastName(),lastName)){
            professor.setLastName(lastName);
        }

        if(email !=null && email.length()>0 && !Objects.equals(professor.getEmail(),email)){
            Optional<Professor> professorOptional = professorRepository
                    .findProfessorByEmail(email);
            if(professorOptional.isPresent()){
                throw new IllegalStateException("Email taken");
            }
            professor.setEmail(email);
        }
    }
}
