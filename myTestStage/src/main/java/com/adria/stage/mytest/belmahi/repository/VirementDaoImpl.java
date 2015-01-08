package com.adria.stage.mytest.belmahi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adria.stage.mytest.belmahi.model.Virement;

@Transactional
@Repository("iVirementDao")
public class VirementDaoImpl implements IVirementDao {
	@PersistenceContext private EntityManager entityManager;
	@Override
	public Virement getVirement(Long idVirement) {
		return entityManager.find(Virement.class, idVirement);
	}

	@Override
	public Virement addVirement(Virement virement) {
		entityManager.persist(virement);
		entityManager.flush();
//		System.out.println("dao : " + virement.getIdVirement());
		return virement;
	}

	@Override
	public void updateVirement(Virement virement) {
		entityManager.merge(virement);
	}

	@Override
	public void comfirmerVirement(Long IdVirement) {
		 Query query = entityManager.createQuery(
			      "UPDATE Virement SET statut = 2 " +
			      "WHERE idVirement = :p");
			  int updateCount = query.setParameter("p", IdVirement).executeUpdate();
	}

}
