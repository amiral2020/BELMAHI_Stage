package com.adria.stage.mytest.belmahi.service;

import java.util.List;

import com.adria.stage.mytest.belmahi.model.Abonne;
import com.adria.stage.mytest.belmahi.model.Beneficiaire;

public interface IAbonneService {
	public Abonne getAbonne(Long idAbonne);
	public Abonne getAbonneByUserAndPass(String username, String password);
	public void AddAbonne(Abonne abonne);
	public void removeAbonne(Long idALong);
	public List<Abonne> getAllAbonnes();
	public List<Beneficiaire> getBeneficiaresAbonne(Long idAbonne);
	public Abonne getAbonneByUsername(String username);
	Boolean virementProprietaire(Abonne abonne, Long idVirement);
}
