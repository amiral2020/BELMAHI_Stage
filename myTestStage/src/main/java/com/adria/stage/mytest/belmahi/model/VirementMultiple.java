package com.adria.stage.mytest.belmahi.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;


@Entity
public class VirementMultiple extends Virement {
	@Column(name="NOMBRE_BENEFICIAIRES")
	private int nombreBenificiaires;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.virementMultiple", cascade=CascadeType.ALL)
	private Set<VirementMultipleBeneficiare> virementMultipleBeneficiares = new HashSet<VirementMultipleBeneficiare>();

	
	
	public VirementMultiple() {
		super();
	}

	public int getNombreBenificiaires() {
		return nombreBenificiaires;
	}

	public void setNombreBenificiaires(int nombreBenificiaires) {
		this.nombreBenificiaires = nombreBenificiaires;
	}

	public Set<VirementMultipleBeneficiare> getVirementMultipleBeneficiares() {
		return virementMultipleBeneficiares;
	}

	public void setVirementMultipleBeneficiares(
			Set<VirementMultipleBeneficiare> virementMultipleBeneficiares) {
		this.virementMultipleBeneficiares = virementMultipleBeneficiares;
	}
	
	
}
