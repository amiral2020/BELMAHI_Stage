package com.adria.stage.mytest.belmahi.service;

import java.util.List;
import java.util.Set;

import com.adria.stage.mytest.belmahi.model.BeneficiaireDuVirement;
import com.adria.stage.mytest.belmahi.model.VirementMultiple;
import com.adria.stage.mytest.belmahi.model.VirementMultipleBeneficiare;

public interface IVirementMulitpleBeneficiaireService {
	/**
	 * from list beneficiaire
	 * @return
	 */
	public Set<VirementMultipleBeneficiare> getListVirementMultipleBeneficiare(List<BeneficiaireDuVirement>
																				beneficiaireDuVirements
																				, VirementMultiple virementMuli);
	
	public void makeAllVirement(Set<VirementMultipleBeneficiare> virementMultipleBeneficiares);
}
