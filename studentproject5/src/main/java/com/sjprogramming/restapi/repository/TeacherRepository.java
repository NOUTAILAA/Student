package com.sjprogramming.restapi.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjprogramming.restapi.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    List<Teacher> findByNomContaining(String nom);

}
