package com.sjprogramming.restapi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjprogramming.restapi.entity.Classe;
import com.sjprogramming.restapi.entity.Teacher;
import com.sjprogramming.restapi.service.ClasseService;
import com.sjprogramming.restapi.service.TeacherService;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {

    private final TeacherService teacherService;
    @Autowired
    private ClasseService classeService;



    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }
    @PutMapping("/{teacherId}/assign-class/{classId}")
    public Teacher assignClassToTeacher(@PathVariable int teacherId, @PathVariable int classId) {
        // Récupérer l'enseignant et la classe correspondants
        Teacher teacher = teacherService.getTeacherById(teacherId);
        Classe classe = classeService.getClassById(classId)
                .orElseThrow(() -> new RuntimeException("Classe not found with id: " + classId));
        
        // Vérifier si l'enseignant et la classe existent
        if (teacher == null) {
            throw new RuntimeException("Teacher not found with id: " + teacherId);
        }
        if (classe == null) {
            throw new RuntimeException("Classe not found with id: " + classId);
        }
        
        // Assigner la classe à l'enseignant
        teacher.setClasse(classe);
        
        // Enregistrer l'enseignant mis à jour dans la base de données
        return teacherService.updateTeacher(teacherId, teacher);
    }


    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable int id) {
        return teacherService.getTeacherById(id);
    }

    @PostMapping
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable int id, @RequestBody Teacher teacher) {
        return teacherService.updateTeacher(id, teacher);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable int id) {
        teacherService.deleteTeacher(id);
    }

    @GetMapping("/search/{nom}")
    public List<Teacher> searchTeacherByName(@PathVariable String nom) {
        return teacherService.searchTeacherByName(nom);
    }
}
