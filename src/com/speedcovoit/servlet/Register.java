package com.speedcovoit.servlet;

import java.io.IOException;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.speedcovoit.model.User;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public static String VIEW_PAGES_URL = "/WEB-INF/register.jsp";
	public static String VIEW_URL = "/WEB-INF/login/form.jsp";
	public static final String FIELD_EMAIL = "email";
	public static final String FIELD_MDP = "mdp";
	public static final String FIELD_CONFIRM_MDP = "mdpConf";
	private static final String PERSISTENT_UNIT_NAME = "SpeedCovoit";
	private static EntityManager em;
	private static EntityManagerFactory fact;
	private static final byte[] keyValue = new byte[] { 'T', 'h', 'i', 's', 'I', 's', 'A', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y' };

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
		try {
			if (erreurs.isEmpty() && !log.isUserExist(email, mdp)) {
				try {
					mdp = encryptMdp(mdp);
				} catch (Exception e) {
					e.printStackTrace();
				}
				newUser = new User(email, mdp);
				actionMessage = "Succès de l'inscription";
				form = new HashMap<String, String>();
				errorStatus = false;

				fact = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
				em = fact.createEntityManager();
				em.getTransaction().begin();
				em.persist(newUser);
				em.getTransaction().commit();
				em.close();
				
				RequestDispatcher dispat;
				dispat = request.getRequestDispatcher(VIEW_URL);
				dispat.forward(request,response);

			} else {
				actionMessage = "Echec de l'inscription";
				errorStatus = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		Key key = generateKey();
		Cipher c = Cipher.getInstance("AES");
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encValue = c.doFinal(password.getBytes());
		String encryptedValue = new BASE64Encoder().encode(encValue);
		return encryptedValue;
	}
	
	public String decryptMdp(String passwordEncrypted) throws Exception {
	    Key key = generateKey();
	    Cipher c = Cipher.getInstance("AES");
	    c.init(Cipher.DECRYPT_MODE, key);
	    byte[] decordedValue = new BASE64Decoder().decodeBuffer(passwordEncrypted);
	    byte[] decValue = c.doFinal(decordedValue);
	    String decryptedValue = new String(decValue);
	    return decryptedValue;
	}
	
	private static Key generateKey() throws Exception {
	    Key key = new SecretKeySpec(keyValue, "AES");
	    return key;
	}

}
