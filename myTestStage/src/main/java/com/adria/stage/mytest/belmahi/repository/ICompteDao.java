package com.adria.stage.mytest.belmahi.repository;

import com.adria.stage.mytest.belmahi.model.Compte;

public interface ICompteDao {
	public void addCompte(Compte compte);
	public Compte getCompte(Long idCompte);
}
