package com.university.uniweb.professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor,Integer> {

    @Query("select p from Professor p where p.email=?1")
    Optional<Professor> findProfessorByEmail(String email);
}
