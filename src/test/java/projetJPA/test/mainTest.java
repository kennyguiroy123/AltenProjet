package projetJPA.test;

import projetJPA.Dao.DaoDepartement;
import projetJPA.Dao.DaoEmploye;
import projetJPA.Entity.Adresse;
import projetJPA.Entity.Departement;
import projetJPA.Entity.Employe;
import projetJPA.util.JpaContext;

public class mainTest {

	public static void main(String[] args) {
		
		//deuxième commentaire merge
		JpaContext.getEntityManagerFactory();
		DaoEmploye daoEmployee = JpaContext.getDaoEmploye();
		DaoDepartement daoDepartment = JpaContext.getDaoDepartment();
		
		Departement departement1 = new Departement("Aquitaine");
		Departement departement2 = new Departement("Ile de france");
		daoDepartment.insert(departement1);
		daoDepartment.insert(departement2);
		
		Adresse adresse1 = new Adresse("28", "Avenue du chut", "33700", "Bordeaux");
		Adresse adresse2 = new Adresse("33", "Avenue du mourignon", "75000", "Paris");
		
		Employe employe1 = new Employe("Kenny", "Guiroy", adresse1, 33000.33, "07837913733",departement2, departement2);
		Employe employe2 = new Employe("Billy", "TheKid", adresse1, 1200.500, "0830838038", departement1, departement1);
		
		daoEmployee.insert(employe1);
		daoEmployee.insert(employe2);
		departement1.setResponsable(employe2);
		departement2.setResponsable(employe1);
		
		daoDepartment.update(departement1);
		daoDepartment.update(departement2);
		//karim chamas 
		//voila bonjour
		
	}

}
