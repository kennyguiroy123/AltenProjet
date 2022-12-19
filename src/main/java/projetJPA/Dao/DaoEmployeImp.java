package projetJPA.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


import projetJPA.Entity.Employe;
import projetJPA.util.JpaContext;

public class DaoEmployeImp implements DaoEmploye{
	
	@Override
	public void insert(Employe obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(obj);
		et.commit();
		em.close();
	}
	
	@Override
	public Employe update(Employe obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		Employe Employe = null;
		et.begin();
		Employe = em.merge(obj);
		et.commit();
		em.close();
		return Employe;
	}
	
	@Override
	public void delete(Employe obj) {
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
		em.remove(em.find(Employe.class, key));
		et.commit();
		em.close();

	}
	
	@Override
	public Employe findByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction et = em.getTransaction();
		Employe Employe = null;
		et.begin();
		Employe = em.find(Employe.class, key);
		et.commit();
		em.close();
		return Employe;
	}
	
	@Override
	public List<Employe> findAll() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Employe> query = em.createQuery("from Employe", Employe.class);
		List<Employe> Employes = query.getResultList();
		em.close();
		return Employes;
	}

}
