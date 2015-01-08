package com.adria.stage.mytest.belmahi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adria.stage.mytest.belmahi.model.Abonne;


@Transactional
@Repository("iAbonneDao")
public class AbonneDaoImpl implements IAbonneDao {

	@PersistenceContext private EntityManager entityManager;
	
	@Override
	public Abonne getAbonne(Long idAbonne) {
		return entityManager.find(Abonne.class, idAbonne);
	}

	@Override
	public void AddAbonne(Abonne abonne) {
		entityManager.persist(abonne);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Abonne> getAllAbonnes() {
		Query query = entityManager.createQuery("from Abonne");
		return query.getResultList();
	}
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Abonne getAbonneByUserAndPass(String username, String password) {
		Query query = entityManager.createQuery("from Abonne where username=:username and password=:password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		return (Abonne) query.getSingleResult();
	}

	@Override
	public void removeAbonne(Long idALong) {
		entityManager.remove(getAbonne(idALong));
	}

	@Override
	public Abonne getAbonneByUsername(String username) {
		Query query = entityManager.createQuery("from Abonne where username=:username");
		query.setParameter("username", username);
		return (Abonne) query.getSingleResult();
	}

}
