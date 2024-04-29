package com.sjprogramming.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Remarque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    private Teacher teacher;

    @Column(name = "contenu")
    private String contenu;

public Remarque () {}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public Student getStudent() {
	return student;
}

public void setStudent(Student student) {
	this.student = student;
}

public Teacher getTeacher() {
	return teacher;
}

public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}

public String getContenu() {
	return contenu;
}

public void setContenu(String contenu) {
	this.contenu = contenu;
}

public Remarque(int id, Student student, Teacher teacher, String contenu) {
	super();
	this.id = id;
	this.student = student;
	this.teacher = teacher;
	this.contenu = contenu;
}

}
