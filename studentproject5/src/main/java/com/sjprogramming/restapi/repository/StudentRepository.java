package com.sjprogramming.restapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjprogramming.restapi.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Ajoutez ici des méthodes supplémentaires si nécessaire
}

