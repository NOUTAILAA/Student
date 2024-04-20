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

import com.sjprogramming.restapi.entity.Document;
import com.sjprogramming.restapi.repository.DocumentRepository;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    @Autowired
    private DocumentRepository documentRepository;

    @PostMapping("/")
    public Document addDocument(@RequestBody Document document) {
        return documentRepository.save(document);
    }

    @GetMapping("/{id}")
    public Document getDocument(@PathVariable Long id) {
        return documentRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable Long id) {
        documentRepository.deleteById(id);
    }

    @PutMapping("/")
    public Document updateDocument(@RequestBody Document document) {
        return documentRepository.save(document);
    }
}
