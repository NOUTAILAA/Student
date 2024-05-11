package com.sjprogramming.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjprogramming.restapi.entity.Cours;
@Repository
public interface CoursRepository extends JpaRepository<Cours, Integer> {}



