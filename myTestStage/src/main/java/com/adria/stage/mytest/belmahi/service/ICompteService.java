package com.adria.stage.mytest.belmahi.service;

import com.adria.stage.mytest.belmahi.model.Compte;

public interface ICompteService {
	public void addCompte(Compte compte);
	public Compte getCompte(Long idCompte);
}
