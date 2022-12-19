package projetJPA.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projetJPA.Dao.DaoEmploye;
import projetJPA.Entity.Adresse;
import projetJPA.Entity.Departement;
import projetJPA.Entity.Employe;
import projetJPA.util.JpaContext;

@WebServlet("/employe")
public class EmployeeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DaoEmploye daoEmployee;
	
	public EmployeeController() {
		
	}
	
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		daoEmployee = JpaContext.getDaoEmploye();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		String q = request.getParameter("q");
		if (q == null || q.isEmpty()) {
			rd = list(request, response);
		} else if (q.equals("add")) {
			rd = add(request, response);
		} else if (q.equals("save")) {
			rd = save(request, response);
		} else if (q.equals("delete")) {
			rd = delete(request, response);
		} else if (q.equals("edit")) {
			rd = edit(request, response);
		}
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private RequestDispatcher add(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("employe", new Employe());
		return goForm(request, response);
	}

	private RequestDispatcher edit(HttpServletRequest request, HttpServletResponse response) {
		Employe employe = daoEmployee.findByKey(Long.parseLong(request.getParameter("matricule")));
		request.setAttribute("employe", employe);
		return goForm(request, response);
	}

	private RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) {
		daoEmployee.deleteByKey(Long.parseLong(request.getParameter("matricule")));
		return list(request, response);
	}

	private RequestDispatcher list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("employe", daoEmployee.findAll());
		return request.getRequestDispatcher("/WEB-INF/employe/list.jsp");
	}

	private RequestDispatcher goForm(HttpServletRequest request, HttpServletResponse response) {
		return request.getRequestDispatcher("/WEB-INF/employe/edite.jsp");
	}

	private RequestDispatcher save(HttpServletRequest request, HttpServletResponse response) {

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		double salaire = Double.parseDouble(request.getParameter("salaire"));
		String telephone = request.getParameter("telephone");
		Adresse adresse = new Adresse(request.getParameter("adresse.numero"), request.getParameter("adresse.rue"),
				request.getParameter("adresse.codePostal"), request.getParameter("adresse.ville"));
		
		Employe employe = new Employe(prenom, nom, adresse, salaire, telephone);
		if (request.getParameter("matricule") == null || request.getParameter("matricule").isEmpty()) {
			daoEmployee.insert(employe);
		} else {
			Long id = Long.parseLong(request.getParameter("matricule"));
			employe.setMatricule(id);
			daoEmployee.update(employe);
			
		}
		return list(request, response);
	}
}
