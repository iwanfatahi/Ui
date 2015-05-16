package org.simbiosis.sso;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SSOLogout
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class SSOLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// FIXME : domain name harus diset, tapi sekarang masih hardcoded
	String domainName = "croowd.co.id";

	// String domainName = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SSOLogin() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//
		String urlRedirect = request.getParameter("redirect");
		String sessionName = request.getParameter("session");
		// New location to be redirected
		response.setHeader("Refresh", "1;url=" + urlRedirect);
		//
		Cookie cookie = new Cookie("simbiosis", sessionName);
		if (!domainName.isEmpty()) {
			cookie.setDomain(domainName);
		}
		cookie.setMaxAge(24 * 60 * 60); // 24 hours.
		cookie.setPath("/");
		response.addCookie(cookie);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
