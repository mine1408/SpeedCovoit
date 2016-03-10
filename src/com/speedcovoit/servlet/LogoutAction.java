package com.speedcovoit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutAction
 */
@WebServlet("/logout")
public class LogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String URL_REDIRECTION = "/UserManager/index.jsp";
	
	// View
	public static String VIEW_PAGES_URL = "/";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogoutAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Récupération et destruction de la session en cours */
        HttpSession session = request.getSession();
        session.invalidate();
        
        /* Redirection vers la page index.jsp ! */
        response.sendRedirect( URL_REDIRECTION );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Build view
		this.getServletContext().getRequestDispatcher(VIEW_PAGES_URL).include(request, response);
	}

}
