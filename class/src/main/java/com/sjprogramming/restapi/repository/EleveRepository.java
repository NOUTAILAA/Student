package com.sjprogramming.restapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sjprogramming.restapi.entity.Eleve;

public interface EleveRepository extends JpaRepository<Eleve, Long> {
    List<Eleve> findByNom(String nom);
    @Query("SELECT e FROM Eleve e JOIN FETCH e.enseignements enseignement JOIN FETCH enseignement.matiere WHERE e.nom = :nom")
    List<Eleve> findEleveWithMatieresByName(String nom);
}
