package com.adria.stage.mytest.belmahi.model;

import java.math.BigDecimal;
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
@Table(name="COMPTE")
public class Compte {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COMPTE")
	private Long idCompte;
	@Column(name="NUMERO_COMPTE", unique=true)
	private String numeroCompte;
	@Column(name="INTITULE")
	private String intitule;
	@Column(name="SOLDE_COMPTABLE")
	private BigDecimal soldeComptable;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ID_ABONNE")
	private Abonne abonne;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="compte")
	private Set<Virement> virements = new HashSet<Virement>();
	
	@JsonIgnore
	public Set<Virement> getVirements() {
		return virements;
	}


	public void setVirements(Set<Virement> virements) {
		this.virements = virements;
	}


	public Compte() {
		super();
	}


	public Long getIdCompte() {
		return idCompte;
	}


	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}


	public String getNumeroCompte() {
		return numeroCompte;
	}


	public void setNumeroCompte(String numeroCompte) {
		this.numeroCompte = numeroCompte;
	}


	public String getIntitule() {
		return intitule;
	}


	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}


	public BigDecimal getSoldeComptable() {
		return soldeComptable;
	}


	public void setSoldeComptable(BigDecimal soldeComptable) {
		this.soldeComptable = soldeComptable;
	}

	@JsonIgnore
	public Abonne getAbonne() {
		return abonne;
	}


	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}
	
	
	
	
}
