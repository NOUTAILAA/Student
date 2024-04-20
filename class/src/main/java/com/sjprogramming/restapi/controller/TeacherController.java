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
import com.sjprogramming.restapi.entity.Teacher;
import com.sjprogramming.restapi.repository.ClasseRepository;
import com.sjprogramming.restapi.repository.TeacherRepository;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
	@Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping("/")
    public Teacher addTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @GetMapping("/{id}")
    public Teacher getTeacher(@PathVariable Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherRepository.deleteById(id);
    }

    @PutMapping("/")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        return teacherRepository.save(teacher);
    }
    @PutMapping("/assignClasseByNom")
    public Teacher assignClasseToTeacherByName(@RequestParam String nomTeacher, @RequestParam String nomClasse) {
        List<Teacher> teachers = teacherRepository.findByNom(nomTeacher);
        if (teachers.isEmpty()) {
            throw new RuntimeException("No teacher found with the name: " + nomTeacher);
        }

        Optional<Classe> classe = classeRepository.findByNom(nomClasse);
        if (!classe.isPresent()) {
            throw new RuntimeException("Classe not found with the name: " + nomClasse);
        }

        Teacher teacher = teachers.get(0); // Assume le premier enseignant trouvé
        teacher.setClasse(classe.get());  // Assurez-vous que Teacher a un champ Classe et des setters appropriés
        return teacherRepository.save(teacher);
    }
}

