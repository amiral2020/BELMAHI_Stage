package com.adria.stage.mytest.belmahi.model;

import java.math.BigDecimal;

public class BeneficiaireDuVirement extends Beneficiaire {
	
	private String fullName;
	
	private BigDecimal montant;
	
	public BeneficiaireDuVirement() {
		super();
	}
	
	
	
	public BeneficiaireDuVirement(BigDecimal montant, Beneficiaire beneficiaire) {
		super(beneficiaire);
		this.montant = montant;
	}



	public String getFullName() {
		return getNom()+" "+getPrenom();
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public BigDecimal getMontant() {
		return montant;
	}
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}
	
	
	
	
}
