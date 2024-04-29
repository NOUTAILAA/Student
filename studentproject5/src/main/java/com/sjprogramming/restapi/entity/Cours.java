package com.sjprogramming.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom")
    private String nom;

    // Autres attributs du cours
    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "classe_id", referencedColumnName = "id")
    private Classe classe;

    // Constructeur avec les nouvelles modifications pour la relation
  



public Cours(int id, String nom, String url, Classe classe) {
		super();
		this.id = id;
		this.nom = nom;
		this.url = url;
		this.classe = classe;
	}



public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public Classe getClasse() {
		return classe;
	}



	public void setClasse(Classe classe) {
		this.classe = classe;
	}



public Cours() {}
}
