package projetJPA.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projetJPA.Dao.DaoDepartement;
import projetJPA.Dao.DaoEmploye;
import projetJPA.Entity.Departement;
import projetJPA.Entity.Employe;
import projetJPA.util.JpaContext;

@WebServlet("/departement")
public class DepartmentController extends HttpServlet{

	
	 
	private static final long serialVersionUID = 1L;
	private DaoDepartement daoDepartment;
	private DaoEmploye daoEmploye;
	
	public DepartmentController() {
		
	}
	//Ajout de commentaire !
	@Override
	public void init() throws ServletException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		daoDepartment = JpaContext.getDaoDepartment();
		daoEmploye = JpaContext.getDaoEmploye();
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
		request.setAttribute("departement", new Departement());
		return goForm(request, response);
	}

	private RequestDispatcher edit(HttpServletRequest request, HttpServletResponse response) {
		Departement departement = daoDepartment.findByKey(Long.parseLong(request.getParameter("id")));
		request.setAttribute("departement", departement);
		return goForm(request, response);
	}

	private RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) {
		daoDepartment.deleteByKey(Long.parseLong(request.getParameter("id")));
		return list(request, response);
	}

	private RequestDispatcher list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("departements", daoDepartment.findAll());
		return request.getRequestDispatcher("/WEB-INF/department/list.jsp");
	}

	private RequestDispatcher goForm(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("employees", daoEmploye.findAll());
		return request.getRequestDispatcher("/WEB-INF/department/editd.jsp");
	}

	private RequestDispatcher save(HttpServletRequest request, HttpServletResponse response) {

		String nomDepartment = request.getParameter("nomDept");
		
		Departement departementNew = new Departement(nomDepartment);
		
		if (request.getParameter("employe.matricule") != null && !request.getParameter("employe.matricule").isEmpty()) {
			Long idemploye = Long.parseLong(request.getParameter("employe.matricule"));
	        departementNew.setResponsable(daoEmploye.findByKey(idemploye));
			daoDepartment.insert(departementNew);
		} if(request.getParameter("id") != null){
			 Long id = Long.parseLong(request.getParameter("id"));
	         departementNew.setId(id);
	         daoDepartment.update(departementNew);
		}
		else {
			daoDepartment.insert(departementNew);
			
		}
		return list(request, response);
		
		
	}

}
