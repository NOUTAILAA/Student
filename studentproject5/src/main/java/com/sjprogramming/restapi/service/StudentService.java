package com.sjprogramming.restapi.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjprogramming.restapi.entity.Student;
import com.sjprogramming.restapi.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(int id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }

    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}

