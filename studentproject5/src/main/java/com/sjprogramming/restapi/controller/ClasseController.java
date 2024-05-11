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
import com.sjprogramming.restapi.entity.Cours;
import com.sjprogramming.restapi.service.ClasseService;
import com.sjprogramming.restapi.service.CoursService;

@RestController
@RequestMapping("/api/classes")
public class ClasseController {

    private final ClasseService classeService;
    private final CoursService coursService;

    @Autowired
    public ClasseController(ClasseService classeService, CoursService coursService) {
        this.classeService = classeService;
        this.coursService = coursService;
    }

    @GetMapping
    public List<Classe> getAllClasses() {
        return classeService.getAllClasses();
    }

    @GetMapping("/{id}")
    public Classe getClassById(@PathVariable int id) {
        return classeService.getClassById(id)
                .orElseThrow(() -> new RuntimeException("Classe not found with id: " + id));
    }

    @PostMapping
    public Classe addClasse(@RequestBody Classe classe) {
        return classeService.addClasse(classe);
    }

    @DeleteMapping("/{id}")
    public void deleteClasse(@PathVariable int id) {
        classeService.deleteClasse(id);
    }

    @PutMapping("/{classeId}/add-course/{coursId}")
    public Classe addCourseToClasse(@PathVariable int classeId, @PathVariable int coursId) {
        Classe classe = classeService.getClassById(classeId)
                .orElseThrow(() -> new RuntimeException("Classe not found with id: " + classeId));
        Cours cours = coursService.getCoursById(coursId)
                .orElseThrow(() -> new RuntimeException("Cours not found with id: " + coursId));
        
        classe.getCours().add(cours);
        return classeService.addClasse(classe);
    }
}
