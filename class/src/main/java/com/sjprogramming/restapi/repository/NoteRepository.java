package com.sjprogramming.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjprogramming.restapi.entity.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
