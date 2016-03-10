package com.speedcovoit.servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.speedcovoit.model.User;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL = "/WEB-INF/register.jsp";
	public static final String FIELD_EMAIL = "email";
	public static final String FIELD_MDP = "mdp";
	public static final String FIELD_CONFIRM_MDP = "mdpConf";
	private static final String PERSISTENT_UNIT_NAME = "SpeedCovoit";
	private static EntityManager em;
	private static EntityManagerFactory fact;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Register() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("errorStatus", true);
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get form fields
		String email = request.getParameter(FIELD_EMAIL);
		String mdp = request.getParameter(FIELD_MDP);
		String mdpConfirm = request.getParameter(FIELD_CONFIRM_MDP);

		// Prepare results
		Map<String, String> erreurs = new HashMap<String, String>();
		Map<String, String> form = new HashMap<String, String>();
		String actionMessage = null;
		String msgVal = null;

		msgVal = validateEmail(email);
		if (msgVal == null) {
			form.put(FIELD_EMAIL, email);
		} else {
			erreurs.put(FIELD_EMAIL, msgVal);
		}

		msgVal = validateMdp(mdp, mdpConfirm);
		if (msgVal == null) {
			form.put(FIELD_MDP, mdp);
		} else {
			erreurs.put(FIELD_CONFIRM_MDP, msgVal);
		}

		User newUser = null;
		boolean errorStatus = true;
		LoginAction log = new LoginAction();
		if (erreurs.isEmpty() && !log.isUserExist(email, mdp)) {
			try {
				mdp = encryptMdp(mdp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			newUser = new User(email, mdp);
			actionMessage = "Succès de l'inscription pour : " + email;
			form = new HashMap<String, String>();
			errorStatus = false;

			fact = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
			em = fact.createEntityManager();
			em.getTransaction().begin();
			em.persist(newUser);
			em.getTransaction().commit();
			em.close();

		} else {
			actionMessage = "Echec de l'inscription";
			errorStatus = true;
		}
		request.setAttribute("newUser", newUser);
		request.setAttribute("form", form);
		request.setAttribute("erreurs", erreurs);
		request.setAttribute("errorStatus", errorStatus);
		request.setAttribute("actionMessage", actionMessage);
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
	}

	private String validateEmail(String email) {
		if (email != null && email.trim().length() != 0) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				return "Veuillez saisir une adresse mail valide";
			}
		} else {
			return "L'adresse mail est obligatoire";
		}
		return null;
	}

	private String validateMdp(String mdp, String mdp2) {
		return (mdp.equals(mdp2)) ? null : "Veuillez confirmer le mot de passe";
	}
	
	public String encryptMdp(String password) throws Exception {
        String generatedPassword = null;
        String key = Long.toHexString(Double.doubleToLongBits(Math.random()));
        try {
            password = key + password + key;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

}
