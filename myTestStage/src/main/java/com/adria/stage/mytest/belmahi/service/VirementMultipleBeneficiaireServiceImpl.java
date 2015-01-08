package com.adria.stage.mytest.belmahi.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adria.stage.mytest.belmahi.model.Beneficiaire;
import com.adria.stage.mytest.belmahi.model.BeneficiaireDuVirement;
import com.adria.stage.mytest.belmahi.model.VirementMultiple;
import com.adria.stage.mytest.belmahi.model.VirementMultipleBeneficiare;
import com.adria.stage.mytest.belmahi.repository.IAbonneDao;
import com.adria.stage.mytest.belmahi.repository.IVirementMultipleBeneficiaireDao;


@Service("iVirementMulitpleBeneficiaireService")
public class VirementMultipleBeneficiaireServiceImpl implements IVirementMulitpleBeneficiaireService {
	
	@Autowired
	IAbonneDao daoAbonne;
	@Autowired
	IBeneficiaireService beneficiaireService;
	
	@Autowired
	private IVirementMultipleBeneficiaireDao dao;
	
	@Override
	public Set<VirementMultipleBeneficiare> getListVirementMultipleBeneficiare(
			List<BeneficiaireDuVirement> beneficiaireDuVirements, VirementMultiple virementMulti) {
		
		Set<VirementMultipleBeneficiare> virementMultipleBeneficiares = new HashSet<VirementMultipleBeneficiare>();
		
		for(BeneficiaireDuVirement b : beneficiaireDuVirements){
			VirementMultipleBeneficiare virement = new VirementMultipleBeneficiare();
			virement.setVirementMultiple(virementMulti);
			Beneficiaire beneficiaire = new Beneficiaire(); 
			beneficiaire = beneficiaireService.getBeneficiaire(b.getIdBeneficiaire());
			System.out.println("beneficiaire id : " + b.getIdBeneficiaire());
			virement.setBeneficiaire(beneficiaire);
			virement.setMontant(b.getMontant());
			
			virementMultipleBeneficiares.add(virement);
		}
		
		return virementMultipleBeneficiares;
	}

	public IVirementMultipleBeneficiaireDao getDao() {
		return dao;
	}

	public void setDao(IVirementMultipleBeneficiaireDao dao) {
		this.dao = dao;
	}

	@Override
	public void makeAllVirement(Set<VirementMultipleBeneficiare> virementMultipleBeneficiares) {
		
		for(VirementMultipleBeneficiare v : virementMultipleBeneficiares){
			dao.addVirementMulitipleBeneficiaire(v);
		}
		
	}
	
	

}
