package com.adria.stage.mytest.belmahi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adria.stage.mytest.belmahi.model.VirementMultipleBeneficiare;

@Transactional
@Repository("iVirementMultipleBeneficiaireDao")
public class VirementMultipleBeneficiaireDaoImpl implements
		IVirementMultipleBeneficiaireDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void addVirementMulitipleBeneficiaire(VirementMultipleBeneficiare virementMultipleBeneficiare) {
		entityManager.persist(virementMultipleBeneficiare);
	}

	@Override
	public VirementMultipleBeneficiare getVirementMultipleBeneficiaire(Long idVirementMultipleBeneficiaire) {
		return entityManager.find(VirementMultipleBeneficiare.class, idVirementMultipleBeneficiaire);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	

}
