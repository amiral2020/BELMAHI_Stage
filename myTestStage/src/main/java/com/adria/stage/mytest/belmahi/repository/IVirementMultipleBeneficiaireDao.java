package com.adria.stage.mytest.belmahi.repository;

import com.adria.stage.mytest.belmahi.model.VirementMultipleBeneficiare;

public interface IVirementMultipleBeneficiaireDao {
	public void addVirementMulitipleBeneficiaire(VirementMultipleBeneficiare virementMultipleBeneficiare);
	public VirementMultipleBeneficiare getVirementMultipleBeneficiaire(Long idVirementMultipleBeneficiaire);
}
