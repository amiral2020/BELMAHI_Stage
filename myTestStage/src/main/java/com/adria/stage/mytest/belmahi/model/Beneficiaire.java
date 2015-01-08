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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity
@Table(name="BENEFICIARE")
public class Beneficiaire {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_BENEFICIAIRE")
	private Long idBeneficiaire;
	@Column(name="NOM")
	private String nom;
	@Column(name="PRENOM")
	private String prenom;
	@Column(name="NUMERO_COMPTE", unique=true)
	private String numeroCompte;
	
	@ManyToOne/*(fetch=FetchType.EAGER, cascade=CascadeType.ALL)*/
	@JoinColumn(name="ID_ABONNE")
	@JsonIgnore
	private Abonne abonne;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.beneficiaire", cascade=CascadeType.ALL)
	private Set<VirementMultipleBeneficiare> virementMultipleBeneficiares = new HashSet<VirementMultipleBeneficiare>();
	
	public Beneficiaire() {
		super();
	}
	
	public Beneficiaire(Beneficiaire beneficiaire) {
		idBeneficiaire = beneficiaire.getIdBeneficiaire();
		nom = beneficiaire.getNom();
		prenom = beneficiaire.getPrenom();
		numeroCompte = beneficiaire.getNumeroCompte();
	}


	public Long getIdBeneficiaire() {
		return idBeneficiaire;
	}


	public void setIdBeneficiaire(Long idBeneficiaire) {
		this.idBeneficiaire = idBeneficiaire;
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


	public String getNumeroCompte() {
		return numeroCompte;
	}


	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	@JsonIgnore
	public Abonne getAbonne() {
		return abonne;
	}


	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}

	@JsonIgnore
	public Set<VirementMultipleBeneficiare> getVirementMultipleBeneficiares() {
		return virementMultipleBeneficiares;
	}


	public void setVirementMultipleBeneficiares(
			Set<VirementMultipleBeneficiare> virementMultipleBeneficiares) {
		this.virementMultipleBeneficiares = virementMultipleBeneficiares;
	}
	
	
	
}
