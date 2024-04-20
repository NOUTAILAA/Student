package com.sjprogramming.restapi.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Eleve {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private String cin;
    
    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String mdp;

    @Column
    private String email;

    @ManyToOne
    @JsonManagedReference
    private Classe classe;
    
    @OneToMany(mappedBy = "eleve")
    
    private List<Note> notes;
    
    @OneToMany(mappedBy = "eleve")
    @JsonManagedReference
    private List<Remarque> remarques;
    
    @OneToMany(mappedBy = "eleve") 
    @JsonBackReference // Assurez-vous que le mapping est correct
    private List<Enseignement> enseignements;

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

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public List<Remarque> getRemarques() {
		return remarques;
	}

	public void setRemarques(List<Remarque> remarques) {
		this.remarques = remarques;
	}
	 public List<Enseignement> getEnseignements() {
	        return enseignements;
	    }

	    public void setEnseignements(List<Enseignement> enseignements) {
	        this.enseignements = enseignements;
	    }

	public Eleve(Long id, String cin, String nom, String mdp, String email, Classe classe, List<Note> notes,
			List<Remarque> remarques) {
		super();
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.mdp = mdp;
		this.email = email;
		this.classe = classe;
		this.notes = notes;
		this.remarques = remarques;
	}

    
    public Eleve() {}
}

