package com.sjprogramming.restapi.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjprogramming.restapi.entity.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Integer> {
}

