package com.adria.stage.mytest.belmahi.model;

import java.math.BigDecimal;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="VIREMENT_MULTIPLE_BENEFICIARE")
@AssociationOverrides({
	@AssociationOverride(name = "pk.virementMultiple", 
		joinColumns = @JoinColumn(name = "ID_VIREMENT")),
	@AssociationOverride(name = "pk.beneficiaire", 
		joinColumns = @JoinColumn(name = "ID_BENEFICIAIRE")) })
public class VirementMultipleBeneficiare implements java.io.Serializable {
	
	private static final long serialVersionUID = 5859507925916530384L;
	
	private VirementMultipleBeneficiareId pk = new VirementMultipleBeneficiareId();
	@Column(name="MONTANT", nullable = false)
	private BigDecimal montant;
	
	
	public VirementMultipleBeneficiare() {
		super();
	}

	@Transient
	public VirementMultiple getVirementMultiple(){
		return pk.getVirementMultiple();
	}
	
	public void setVirementMultiple(VirementMultiple virementMultiple){
		pk.setVirementMultiple(virementMultiple);
	}
	
	
	@Transient
	public Beneficiaire getBeneficiaire(){
		return pk.getBeneficiaire();
	}
	
	public void setBeneficiaire(Beneficiaire beneficiaire){
		pk.setBeneficiaire(beneficiaire);
	}
	
	@EmbeddedId
	public VirementMultipleBeneficiareId getPk() {
		return pk;
	}
	

	public void setPk(VirementMultipleBeneficiareId pk) {
		this.pk = pk;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}
	
	@Override
	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof VirementMultipleBeneficiare))
			return false;
		VirementMultipleBeneficiare other = (VirementMultipleBeneficiare) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		if (montant == null) {
			if (other.montant != null)
				return false;
		} else if (!montant.equals(other.montant))
			return false;
		return true;
	}
	
	
	
}
