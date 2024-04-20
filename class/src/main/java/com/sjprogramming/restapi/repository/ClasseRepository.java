package com.sjprogramming.restapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjprogramming.restapi.entity.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Long> {
        Optional<Classe> findByNom(String nom);
    }

