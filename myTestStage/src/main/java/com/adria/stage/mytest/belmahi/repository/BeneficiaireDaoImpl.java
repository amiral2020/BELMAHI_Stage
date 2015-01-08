package com.adria.stage.mytest.belmahi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adria.stage.mytest.belmahi.model.Beneficiaire;

@Transactional
@Repository("iBeneficiaireDao")
public class BeneficiaireDaoImpl implements IBeneficiaireDao {
	
	@PersistenceContext private EntityManager entityManager;
	
	@Override
	public Beneficiaire getBeneficiaire(Long idBeneficiaire) {
		return entityManager.find(Beneficiaire.class, idBeneficiaire);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Beneficiaire> getAllBeneficiaires() {
		Query query = entityManager.createQuery("from Beneficiaire");
		return query.getResultList();
	}

	@Override
	public List<Beneficiaire> getBeneficiaresAbonne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addBeneficiaire(Beneficiaire beneficiaire) {
		entityManager.persist(beneficiaire);
	}

}
