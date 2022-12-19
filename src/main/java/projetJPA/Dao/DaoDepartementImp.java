package projetJPA.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


import projetJPA.Entity.Departement;
import projetJPA.util.JpaContext;

public class DaoDepartementImp implements DaoDepartement{
	
	@Override
	public void insert(Departement obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(obj);
		et.commit();
		em.close();
	}
	
	@Override
	public Departement update(Departement obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		Departement Departement = null;
		et.begin();
		Departement = em.merge(obj);
		et.commit();
		em.close();
		return Departement;
	}
	
	@Override
	public void delete(Departement obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(em.merge(obj));
		et.commit();
		em.close();

	}
	
	@Override
	public void deleteByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(em.find(Departement.class, key));
		et.commit();
		em.close();

	}
	
	@Override
	public Departement findByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		Departement Departement = null;
		et.begin();
		Departement = em.find(Departement.class, key);
		et.commit();
		em.close();
		return Departement;
	}
	
	@Override
	public List<Departement> findAll() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Departement> query = em.createQuery("from Departement", Departement.class);
		List<Departement> Departements = query.getResultList();
		em.close();
		return Departements;
	}

}
