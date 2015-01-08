package com.adria.stage.mytest.belmahi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adria.stage.mytest.belmahi.model.Beneficiaire;
import com.adria.stage.mytest.belmahi.repository.IBeneficiaireDao;

@Service("iBeneficiaireService")
public class BeneficiaireServiceImpl implements IBeneficiaireService {

	@Autowired
	IBeneficiaireDao dao;
	
	@Override
	public Beneficiaire getBeneficiaire(Long idBeneficiaire) {
		return dao.getBeneficiaire(idBeneficiaire);
	}

	@Override
	public void addBeneficiaire(Beneficiaire beneficiaire) {
		dao.addBeneficiaire(beneficiaire);
	}

	@Override
	public List<Beneficiaire> getAllBeneficiaires() {
		return dao.getAllBeneficiaires();
	}

}
