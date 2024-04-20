package com.sjprogramming.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjprogramming.restapi.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    Teacher findByCin(String cin);
    List<Teacher> findByNom(String nom);
}
