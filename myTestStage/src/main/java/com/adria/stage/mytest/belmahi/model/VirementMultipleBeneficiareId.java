package com.adria.stage.mytest.belmahi.model;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class VirementMultipleBeneficiareId implements java.io.Serializable{

	private static final long serialVersionUID = 4639481181132718931L;
	
	private VirementMultiple virementMultiple;
	private Beneficiaire beneficiaire;
	
	
	
	
	public VirementMultipleBeneficiareId() {
		super();
	}

	@ManyToOne
	public VirementMultiple getVirementMultiple() {
		return virementMultiple;
	}
	
	@ManyToOne
	public Beneficiaire getBeneficiaire() {
		return beneficiaire;
	}
	
	public void setVirementMultiple(VirementMultiple virementMultiple) {
		this.virementMultiple = virementMultiple;
	}
	public void setBeneficiaire(Beneficiaire beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
	
	@Override
	public int hashCode() {
		 int result;
	        result = (beneficiaire != null ? beneficiaire.hashCode() : 0);
	        result = 17 * result + (beneficiaire != null ? beneficiaire.hashCode() : 0);
	        return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof VirementMultipleBeneficiareId))
			return false;
		VirementMultipleBeneficiareId other = (VirementMultipleBeneficiareId) obj;
		if (virementMultiple == null) {
			if (other.virementMultiple != null)
				return false;
		} else if (!virementMultiple.equals(other.virementMultiple))
			return false;
		if (beneficiaire == null) {
			if (other.beneficiaire != null)
				return false;
		} else if (!beneficiaire.equals(other.beneficiaire))
			return false;
		return true;
	}
	
}
