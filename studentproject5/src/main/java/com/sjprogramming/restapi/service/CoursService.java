package com.sjprogramming.restapi.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjprogramming.restapi.entity.Cours;
import com.sjprogramming.restapi.repository.CoursRepository;

@Service
public class CoursService {

    private final CoursRepository coursRepository;

    @Autowired
    public CoursService(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }
    public Optional<Cours> getCoursById(int id) {
        return coursRepository.findById(id);
    }
    public List<Cours> getAllCours() {
        return coursRepository.findAll();
    }

    public Cours addCours(Cours cours) {
        return coursRepository.save(cours);
    }
    public Cours updateCours(int id, Cours newCours) {
        Optional<Cours> existingCoursOptional = coursRepository.findById(id);
        if (existingCoursOptional.isPresent()) {
            Cours existingCours = existingCoursOptional.get();
            existingCours.setNom(newCours.getNom());
            existingCours.setUrl(newCours.getUrl());
            // Mettez à jour d'autres propriétés selon les besoins
            return coursRepository.save(existingCours);
        } else {
            // Gérer le cas où le cours n'est pas trouvé
            throw new RuntimeException("Cours not found with id: " + id);
        }
    }
    public void deleteCours(int id) {
        coursRepository.deleteById(id);
    }
}

