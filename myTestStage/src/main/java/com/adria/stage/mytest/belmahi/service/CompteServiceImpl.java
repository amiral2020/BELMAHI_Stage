package com.adria.stage.mytest.belmahi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adria.stage.mytest.belmahi.model.Compte;
import com.adria.stage.mytest.belmahi.repository.ICompteDao;

@Service("iCompteService")
public class CompteServiceImpl implements ICompteService {

	@Autowired
	ICompteDao dao;
	
	@Override
	public void addCompte(Compte compte) {
		dao.addCompte(compte);
	}

	@Override
	public Compte getCompte(Long idCompte) {
		return dao.getCompte(idCompte);
	}

}
