package com.sjprogramming.restapi.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Transient;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "email")
    private String email;

    @Column(name = "cin", unique = true)
    private String cin;

    @Column(name = "mdp")
    private String mdp;

    @ManyToOne
    @JoinColumn(name = "classe_id", referencedColumnName = "id")
    @JsonIgnore
    private Classe classe;
    @Transient // Ignorer la persistance de cette propriété dans la base de données
    private String classNom;

    public String getClassNom() {
        return classe != null ? classe.getNom() : null;
    }
   public Teacher() {}

public Teacher(int id, String nom, String email, String cin, String mdp, Classe classe) {
	super();
	this.id = id;
	this.nom = nom;
	this.email = email;
	this.cin = cin;
	this.mdp = mdp;
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getCin() {
	return cin;
}

public void setCin(String cin) {
	this.cin = cin;
}

public String getMdp() {
	return mdp;
}

public void setMdp(String mdp) {
	this.mdp = mdp;
}

public Classe getClasse() {
	return classe;
}

public void setClasse(Classe classe) {
	this.classe = classe;
}
   
   
}
