package com.sjprogramming.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjprogramming.restapi.entity.Enseignement;

public interface EnseignementRepository extends JpaRepository<Enseignement, Long> {
}
