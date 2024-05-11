package com.sjprogramming.restapi.entity;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "classe")
    private List<Cours> cours;

    @Column(name = "nom")
    private String nom;

    // Constructeur avec les nouvelles modifications pour la relation
    public Classe(List<Cours> cours, String nom) {
        this.cours = cours;
        this.nom = nom;
    }
    

public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<Cours> getCours() {
		return cours;
	}


	public void setCours(List<Cours> cours) {
		this.cours = cours;
	}


	


public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


public Classe() {}

}
