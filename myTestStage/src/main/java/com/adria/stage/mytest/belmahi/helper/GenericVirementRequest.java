package com.adria.stage.mytest.belmahi.helper;

import java.util.List;

import com.adria.stage.mytest.belmahi.model.BeneficiaireDuVirement;

public class GenericVirementRequest {
	
	private List<BeneficiaireDuVirement> beneficiairesDuVirement;
	private int idCompte;
	private String motif;
	private String dateExecution;
	private int montant;
	public GenericVirementRequest() {
		super();
	}
	public List<BeneficiaireDuVirement> getBeneficiairesDuVirement() {
		return beneficiairesDuVirement;
	}
	public void setBeneficiairesDuVirement(
			List<BeneficiaireDuVirement> beneficiairesDuVirement) {
		this.beneficiairesDuVirement = beneficiairesDuVirement;
	}
	public int getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}
	public String getMotif() {
		return motif;
	}
	public void setMotif(String motif) {
		this.motif = motif;
	}
	public String getDateExecution() {
		return dateExecution;
	}
	public void setDateExecution(String dateExecution) {
		this.dateExecution = dateExecution;
	}
	public int getMontant() {
		return montant;
	}
	public void setMontant(int montant) {
		this.montant = montant;
	}
	
	
}
