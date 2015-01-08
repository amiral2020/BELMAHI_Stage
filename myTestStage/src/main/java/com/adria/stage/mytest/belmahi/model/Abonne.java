package com.adria.stage.mytest.belmahi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ABONNE")
public class Abonne {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ABONNE")
	private Long idAbonne;
	@Column(name="USERNAME", unique=true)
	private String username;
	@Column(name="PASSWORD")
	private String password;
	@Column(name="NOM")
	private String nom;
	@Column(name="PRENOM")
	private String prenom;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="abonne")
	private Set<Compte> comptes = new HashSet<Compte>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="abonne")
	private Set<Beneficiaire> beneficiares = new HashSet<Beneficiaire>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="abonne")
	private Set<Virement> virements = new HashSet<Virement>();
	
	public Abonne() {
		super();
	}


	public Long getIdAbonne() {
		return idAbonne;
	}


	public void setIdAbonne(Long idAbonne) {
		this.idAbonne = idAbonne;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public Set<Compte> getComptes() {
		return comptes;
	}


	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}


	public Set<Beneficiaire> getBeneficiares() {
		return beneficiares;
	}


	public void setBeneficiares(Set<Beneficiaire> beneficiares) {
		this.beneficiares = beneficiares;
	}


	public Set<Virement> getVirements() {
		return virements;
	}


	public void setVirements(Set<Virement> virements) {
		this.virements = virements;
	}
	
	@Transient
	public String fullName(){
		return nom +" "+prenom;
	}
	
}
