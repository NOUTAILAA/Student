package com.sjprogramming.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjprogramming.restapi.entity.Remarque;

public interface RemarqueRepository extends JpaRepository<Remarque, Long> {
}

