package com.sjprogramming.restapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sjprogramming.restapi.entity.Classe;
import com.sjprogramming.restapi.entity.Eleve;
import com.sjprogramming.restapi.entity.Remarque;
import com.sjprogramming.restapi.repository.ClasseRepository;
import com.sjprogramming.restapi.repository.EleveRepository;
import com.sjprogramming.restapi.repository.RemarqueRepository;

@RestController
@RequestMapping("/eleves")
public class EleveController {
    @Autowired
    private EleveRepository eleveRepository;
    @Autowired
    private RemarqueRepository remarqueRepository;

    @Autowired
    private ClasseRepository classeRepository;
    @PostMapping("/")
    public Eleve addEleve(@RequestBody Eleve eleve) {
        return eleveRepository.save(eleve);
    }

    @GetMapping("/{id}")
    public Eleve getEleve(@PathVariable Long id) {
        return eleveRepository.findById(id).orElse(null);
    }
    @PutMapping("/assignClasseByNom")
    public Eleve assignClasseToEleveByName(@RequestParam String nom, @RequestParam Long classeId) {
        List<Eleve> eleves = eleveRepository.findByNom(nom);
        if (eleves.isEmpty()) {
            throw new RuntimeException("No student found with the name: " + nom);
        }

        Eleve eleve = eleves.get(0); // Prend le premier élève trouvé
        Classe classe = classeRepository.findById(classeId).orElseThrow(() -> new RuntimeException("Classe not found!"));

        eleve.setClasse(classe);
        return eleveRepository.save(eleve);
    }

    @DeleteMapping("/{id}")
    public void deleteEleve(@PathVariable Long id) {
        eleveRepository.deleteById(id);
    }

    @PutMapping("/")
    public Eleve updateEleve(@RequestBody Eleve eleve) {
        return eleveRepository.save(eleve);
    }

    @GetMapping("/search")
    public List<Eleve> searchEleves(@RequestParam String nom) {
        return eleveRepository.findByNom(nom);
    }
    @PutMapping("/{eleveId}/assignClasse/{classeId}")
    public Eleve assignClasseToEleve(@PathVariable Long eleveId, @PathVariable Long classeId) {
        Eleve eleve = eleveRepository.findById(eleveId).orElseThrow(() -> new RuntimeException("Eleve not found!"));
        Classe classe = classeRepository.findById(classeId).orElseThrow(() -> new RuntimeException("Classe not found!"));

        eleve.setClasse(classe);
        return eleveRepository.save(eleve);
    }
    @PutMapping("/assignClasseByName")
    public Eleve assignClasseToEleveByName(@RequestParam String nomEleve, @RequestParam String nomClasse) {
        List<Eleve> eleves = eleveRepository.findByNom(nomEleve);
        if (eleves.isEmpty()) {
            throw new RuntimeException("No student found with the name: " + nomEleve);
        }

        Optional<Classe> classe = classeRepository.findByNom(nomClasse);
        if (!classe.isPresent()) {
            throw new RuntimeException("Classe not found with the name: " + nomClasse);
        }

        Eleve eleve = eleves.get(0); // Prend le premier élève trouvé
        eleve.setClasse(classe.get());
        return eleveRepository.save(eleve);
    }
    @PostMapping("/assignRemarqueByNom")
    public Remarque assignRemarqueToEleveByNom(@RequestParam String nomEleve, @RequestBody String contenu) {
        List<Eleve> eleves = eleveRepository.findByNom(nomEleve);
        if (eleves.isEmpty()) {
            throw new RuntimeException("No student found with the name: " + nomEleve);
        }

        Eleve eleve = eleves.get(0); // Assume le premier élève trouvé
        Remarque remarque = new Remarque();
        remarque.setContenu(contenu);
        remarque.setEleve(eleve);
        return remarqueRepository.save(remarque);
    }
    @GetMapping("/infoByName")
    public List<Eleve> getEleveInfoByName(@RequestParam String nom) {
        return eleveRepository.findEleveWithMatieresByName(nom);
    }
}
