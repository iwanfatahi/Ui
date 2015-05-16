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
@WebServlet(name = "logout", urlPatterns = { "/logout" })
public class SSOLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Masih di hardcode juga
	String domainName = "croowd.co.id";

	// String domainName = "";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SSOLogout() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase("simbiosis")) {
					//
					String urlRedirect = request.getParameter("redirect");
					// New location to be redirected
					response.setHeader("Refresh", "1;url=" + urlRedirect);
					//
					cookie.setValue(null);
					if (!domainName.isEmpty()) {
						cookie.setDomain(domainName);
					}
					cookie.setMaxAge(0);
					cookie.setPath("/");
					response.addCookie(cookie);
				}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
