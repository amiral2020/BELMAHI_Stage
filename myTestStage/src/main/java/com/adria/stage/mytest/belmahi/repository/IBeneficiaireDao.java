package com.adria.stage.mytest.belmahi.repository;

import java.util.List;

import com.adria.stage.mytest.belmahi.model.Beneficiaire;

public interface IBeneficiaireDao {
	public Beneficiaire getBeneficiaire(Long idBeneficiaire);
	public void addBeneficiaire(Beneficiaire beneficiaire);
	public List<Beneficiaire> getAllBeneficiaires();
	public List<Beneficiaire> getBeneficiaresAbonne();
}
