package com.sjprogramming.restapi.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjprogramming.restapi.entity.Teacher;
import com.sjprogramming.restapi.repository.TeacherRepository;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(int id) {
        return teacherRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Teacher not found with id: " + id));
    }

    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher updateTeacher(int id, Teacher teacher) {
        if (!teacherRepository.existsById(id)) {
            throw new IllegalArgumentException("Teacher not found with id: " + id);
        }
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(int id) {
        if (!teacherRepository.existsById(id)) {
            throw new IllegalArgumentException("Teacher not found with id: " + id);
        }
        teacherRepository.deleteById(id);
    }
    public List<Teacher> searchTeacherByName(String nom) {
        // Implémentez ici la logique de recherche par nom
        // Par exemple, vous pouvez appeler une méthode dans votre repository pour effectuer la recherche
        return teacherRepository.findByNomContaining(nom);
    }
}
