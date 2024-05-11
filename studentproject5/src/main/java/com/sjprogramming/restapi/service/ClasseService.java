package com.sjprogramming.restapi.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjprogramming.restapi.entity.Classe;
import com.sjprogramming.restapi.repository.ClasseRepository;

@Service
public class ClasseService {

    private final ClasseRepository classeRepository;

    @Autowired
    public ClasseService(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    public Optional<Classe> getClassById(int id) {
        return classeRepository.findById(id);
    }

    public Classe addClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    public void deleteClasse(int id) {
        classeRepository.deleteById(id);
    }
}
