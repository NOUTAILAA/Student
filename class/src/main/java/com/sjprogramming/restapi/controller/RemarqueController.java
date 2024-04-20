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

import com.sjprogramming.restapi.entity.Remarque;
import com.sjprogramming.restapi.repository.RemarqueRepository;

@RestController
@RequestMapping("/remarques")
public class RemarqueController {
    @Autowired
    private RemarqueRepository remarqueRepository;

    @PostMapping("/")
    public Remarque addRemarque(@RequestBody Remarque remarque) {
        return remarqueRepository.save(remarque);
    }

    @GetMapping("/{id}")
    public Remarque getRemarque(@PathVariable Long id) {
        return remarqueRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteRemarque(@PathVariable Long id) {
        remarqueRepository.deleteById(id);
    }

    @PutMapping("/")
    public Remarque updateRemarque(@RequestBody Remarque remarque) {
        return remarqueRepository.save(remarque);
    }
}

