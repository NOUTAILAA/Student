package com.sjprogramming.restapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sjprogramming.restapi.entity.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {
}
