package com.sjprogramming.restapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjprogramming.restapi.entity.Note;
import com.sjprogramming.restapi.entity.Student;
import com.sjprogramming.restapi.entity.Teacher;
import com.sjprogramming.restapi.repository.NoteRepository;
import com.sjprogramming.restapi.repository.StudentRepository;
import com.sjprogramming.restapi.repository.TeacherRepository;

@Service
public class NoteService {

    // Autres méthodes du service

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public void affecterNoteAUnEtudiant(int studentId, int teacherId, double valeurNote) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
        
        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found with id: " + teacherId));
        
        Note note = new Note();
        note.setStudent(student);
        note.setTeacher(teacher);
        note.setValeur(valeurNote);

        noteRepository.save(note);
    }
}
