package com.sjprogramming.restapi.repository;

import com.sjprogramming.restapi.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}

