package com.speedcovoit.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/login")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// View
	public static String VIEW_PAGES_URL = "/WEB-INF/login.jsp";

	// Form fields
	public static final String FIELD_EMAIL = "email";
	public static final String FIELD_PWD = "mdp";
	private static final String PERSISTENT_UNIT_NAME = "SpeedCovoit";
	private static EntityManager em;
	private static EntityManagerFactory fact;

	// Request attributs
	Map<String, String> error;// = new HashMap<String, String>();
	Map<String, String> form;// = new HashMap<String, String>();
	String statusMessage = "";
	boolean statusOk = false;
	
	Register reg;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginAction() {
		super();
		this.reg = new Register();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Prepare model to view
		request.setAttribute("statusOK", false);
		request.setAttribute("statusMessage", "");

		// Build view
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get form fields
		String email = request.getParameter(FIELD_EMAIL);
		String mdp = request.getParameter(FIELD_PWD);

		// Prepare data for view (attributs)
		error = new HashMap<String, String>();
		form = new HashMap<String, String>();
		statusMessage = null;

		// Validate page
		String msgVal = null;
		if (msgVal == null) {
			form.put(FIELD_EMAIL, email);
		} 
		
		msgVal = validatePwd(mdp);
		if (msgVal == null) {
			form.put(FIELD_PWD, mdp);
		} else {
			error.put(FIELD_PWD, msgVal);
		}

		if (error.isEmpty() && isUserExist(email, mdp)) {
			statusOk = true;
			statusMessage = "Connecté";
		} else {
			statusOk = false;
			statusMessage = "Connexion refusée";
		}

		// Prepare model to view
		request.setAttribute("form", form);
		request.setAttribute("error", error);
		request.setAttribute("statusOK", statusOk);
		request.setAttribute("statusMessage", statusMessage);

		// Build view
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
	}

	private String validatePwd(String pwd) {
		return (pwd == null || pwd.equals("")) ? "Le mot de passe doit être renseigné" : null;
	}

	private boolean isUserExist(String email, String mdp) {
		fact = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
		em = fact.createEntityManager();
		em.getTransaction().begin();
		Query q = em.createQuery("SELECT u FROM User u WHERE u.email ='"+email+"' AND u.mdp='"+mdp+"'");
		boolean isUserExist = (q.getResultList().size() == 1);
		em.getTransaction().commit();
		em.close();
		return isUserExist;
	}

}
