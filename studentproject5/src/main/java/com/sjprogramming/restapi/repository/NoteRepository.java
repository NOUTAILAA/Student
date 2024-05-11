package com.sjprogramming.restapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjprogramming.restapi.entity.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
    // Ajoutez des méthodes personnalisées si nécessaire
}
