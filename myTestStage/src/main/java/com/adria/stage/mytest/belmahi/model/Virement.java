package com.adria.stage.mytest.belmahi.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;


@Entity @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="VIREMENT")
public abstract class Virement {
	
	@Transient
	public static int ENTREGISTRE = 1;
	@Transient
	public static int CONFIRME_SIGNE = 2;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_VIREMENT")
	private Long idVirement;
	@Column(name="DATE_CREATION")
	private Date dateCreation;
	@Column(name="DATE_EXECUTION")
	private Date dateExecution;
	@Column(name="MONTANT")
	private BigDecimal montant;
	@Column(name="MOTIF")
	private String motif;
	@Column(name="STATUT")
	private int statut;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ID_ABONNE")
	private Abonne abonne;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ID_COMPTE")
	private Compte compte;
	
	public Virement() {
		super();
	}
	
	
	@JsonIgnore
	public Compte getCompte() {
		return compte;
	}



	public void setCompte(Compte compte) {
		this.compte = compte;
	}



	public Long getIdVirement() {
		return idVirement;
	}

	public void setIdVirement(Long idVirement) {
		this.idVirement = idVirement;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateExecution() {
		return dateExecution;
	}

	public void setDateExecution(Date dateExecution) {
		this.dateExecution = dateExecution;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}
	
	@JsonIgnore
	public Abonne getAbonne() {
		return abonne;
	}

	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}


	public int getStatut() {
		return statut;
	}


	public void setStatut(int statut) {
		this.statut = statut;
	}
	
	
}
