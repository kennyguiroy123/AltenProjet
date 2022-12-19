package projetJPA.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import projetJPA.Dao.DaoDepartement;
import projetJPA.Dao.DaoDepartementImp;
import projetJPA.Dao.DaoEmployeImp;
import projetJPA.Dao.DaoEmploye;


public class JpaContext {
	
	private static EntityManagerFactory emf = null;
	private static DaoDepartement daoDepartment;
	private static DaoEmploye daoEmployee;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(emf == null) {
			emf=Persistence.createEntityManagerFactory("baseAltenProjetJPA");
		}
		return emf;
	}
	
	public static void DestroyJpaContext() {
		if(emf != null) {
			emf.close();
			emf = null;
		}
	}
	
	public static DaoDepartement getDaoDepartment() {
		if(daoDepartment==null) {
			daoDepartment=new DaoDepartementImp();
		}
		return daoDepartment;
	}
	
	public static DaoEmploye getDaoEmploye() {
		if(daoEmployee==null) {
			daoEmployee=new DaoEmployeImp();
		}
		return daoEmployee;
	}
	
}

