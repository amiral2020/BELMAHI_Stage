package com.adria.stage.mytest.belmahi.service;

import java.util.List;

import com.adria.stage.mytest.belmahi.model.Beneficiaire;

public interface IBeneficiaireService {
	public Beneficiaire getBeneficiaire(Long idBeneficiaire);
	public void addBeneficiaire(Beneficiaire beneficiaire);
	public List<Beneficiaire> getAllBeneficiaires();
}
