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

import com.sjprogramming.restapi.entity.Cours;
import com.sjprogramming.restapi.service.CoursService;

@RestController
@RequestMapping("/api/cours")
public class CoursController {

    private final CoursService coursService;

    @Autowired
    public CoursController(CoursService coursService) {
        this.coursService = coursService;
    }

    @GetMapping
    public List<Cours> getAllCours() {
        return coursService.getAllCours();
    }

    @GetMapping("/{id}")
    public Cours getCoursById(@PathVariable int id) {
        return coursService.getCoursById(id)
                .orElseThrow(() -> new RuntimeException("Cours not found with id: " + id));
    }

    @PostMapping
    public Cours addCours(@RequestBody Cours cours) {
        return coursService.addCours(cours);
    }

    @PutMapping("/{id}")
    public Cours updateCours(@PathVariable int id, @RequestBody Cours cours) {
        return coursService.updateCours(id, cours);
    }

    @DeleteMapping("/{id}")
    public void deleteCours(@PathVariable int id) {
        coursService.deleteCours(id);
    }
}

