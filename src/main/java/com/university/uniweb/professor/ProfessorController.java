package com.university.uniweb.professor;

import com.university.uniweb.student.Student;
import com.university.uniweb.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/professor")

public class ProfessorController {

    @Autowired
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> getProfessors(){
        return professorService.getProfessors();
    }

    @PostMapping
    public void registerNewProfessor(@RequestBody Professor professor){
        professorService.addNewProfessor(professor);
    }

    @DeleteMapping(path="{professorId}")
    public void deleteProfessor(@PathVariable("professorId") Integer professorId){
        professorService.deleteProfessor(professorId);
    }
    @PutMapping(path = "{professorId}")
    public void updateProfessor(
            @PathVariable("professorId") Integer professorId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email){
        professorService.updateProfessor(professorId, firstName,lastName,email);
    }


}
