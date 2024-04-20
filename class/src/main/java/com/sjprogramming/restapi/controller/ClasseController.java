package com.sjprogramming.restapi.controller;

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
import com.sjprogramming.restapi.repository.ClasseRepository;

@RestController
@RequestMapping("/classes")
public class ClasseController {
    @Autowired
    private ClasseRepository classeRepository;

    @PostMapping("/")
    public Classe addClasse(@RequestBody Classe classe) {
        return classeRepository.save(classe);
    }

    @GetMapping("/{id}")
    public Classe getClasse(@PathVariable Long id) {
        return classeRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteClasse(@PathVariable Long id) {
        classeRepository.deleteById(id);
    }

    @PutMapping("/")
    public Classe updateClasse(@RequestBody Classe classe) {
        return classeRepository.save(classe);
    }
}
