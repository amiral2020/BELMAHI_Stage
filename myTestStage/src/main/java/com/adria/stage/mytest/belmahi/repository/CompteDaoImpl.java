package com.adria.stage.mytest.belmahi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adria.stage.mytest.belmahi.model.Compte;

@Transactional
@Repository("iCompteDao")
public class CompteDaoImpl implements ICompteDao {

	@PersistenceContext private EntityManager entityManager;
	
	@Override
	public void addCompte(Compte compte) {
		entityManager.persist(compte);
	}

	@Override
	public Compte getCompte(Long idCompte) {
		return entityManager.find(Compte.class, idCompte);
	}

}
