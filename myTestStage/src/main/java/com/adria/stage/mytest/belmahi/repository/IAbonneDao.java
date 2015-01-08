package com.adria.stage.mytest.belmahi.repository;

import java.util.List;

import com.adria.stage.mytest.belmahi.model.Abonne;



public interface IAbonneDao {
	
	public Abonne getAbonne(Long idAbonne);
	public Abonne getAbonneByUserAndPass(String username, String password);
	public Abonne getAbonneByUsername(String username);
	public void AddAbonne(Abonne abonne);
	public void removeAbonne(Long idALong);
	public List<Abonne> getAllAbonnes();
}
