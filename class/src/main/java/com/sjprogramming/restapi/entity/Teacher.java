package com.sjprogramming.restapi.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String cin;
    
    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String mdp;
    @ManyToOne
    @JsonManagedReference
    private Classe classe;

    @Column
    private String email;

    @OneToMany(mappedBy = "teacher")
    private List<Document> documents;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Teacher(Long id, String cin, String nom, String mdp, String email, List<Document> documents) {
		super();
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.mdp = mdp;
		this.email = email;
		this.documents = documents;
	}
	   public Classe getClasse() {
	        return classe;
	    }

	    public void setClasse(Classe classe) {
	        this.classe = classe;
	    }
    public Teacher() {}
    // Getters and Setters
}
