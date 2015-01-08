package com.adria.stage.mytest.belmahi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adria.stage.mytest.belmahi.model.Abonne;
import com.adria.stage.mytest.belmahi.model.Beneficiaire;
import com.adria.stage.mytest.belmahi.model.Virement;
import com.adria.stage.mytest.belmahi.repository.IAbonneDao;

@Service("iAbonneService")
public class AbonneServiceImpl implements IAbonneService {
	
	@Autowired
	private IAbonneDao dao;
	
	@Override
	public Abonne getAbonne(Long idAbonne) {
		return dao.getAbonne(idAbonne);
	}

	@Override
	public void AddAbonne(Abonne abonne) {
		dao.AddAbonne(abonne);
	}

	@Override
	public List<Abonne> getAllAbonnes() {
		return dao.getAllAbonnes();
	}

	public IAbonneDao getDao() {
		return dao;
	}

	public void setDao(IAbonneDao dao) {
		this.dao = dao;
	}

	@Override
	public Abonne getAbonneByUserAndPass(String username, String password) {
		return dao.getAbonneByUserAndPass(username, password);
	}

	@Override
	public void removeAbonne(Long idALong) {
		dao.removeAbonne(idALong);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Beneficiaire> getBeneficiaresAbonne(Long idAbonne) {
		return (List<Beneficiaire>) getAbonne(idAbonne).getBeneficiares();
	}

	@Override
	public Abonne getAbonneByUsername(String username) {
		return dao.getAbonneByUsername(username);
	}

	@Override
	public Boolean virementProprietaire(Abonne abonne, Long idVirement) {
		
		for(Virement v : abonne.getVirements()){
			if(v.getIdVirement() == idVirement) return true;
		}
		
		return false;
	}
	
	

}
