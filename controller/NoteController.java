package com.sjprogramming.restapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sjprogramming.restapi.service.NoteService;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/assign-note")
    public ResponseEntity<String> assignNoteToStudent(@RequestParam int studentId, @RequestParam int teacherId, @RequestParam double valeurNote) {
        noteService.affecterNoteAUnEtudiant(studentId, teacherId, valeurNote);
        return ResponseEntity.ok("Note assigned successfully.");
    }
}
