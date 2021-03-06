package org.simbiosis.sso;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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

	String domainName = "";

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
		readProperties();
		//
		String urlRedirect = request.getParameter("redirect");
		String hash = request.getParameter("hash");
		String sessionName = request.getParameter("session");
		// New location to be redirected
		response.setHeader("Refresh", "1;url=" + urlRedirect
				+ (hash != null ? ("#" + hash) : ""));
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

	private void readProperties() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream(
					"/home/simbiosis/global/simbiosis.properties");

			// load a properties file
			prop.load(input);

			// get the property value and print it out
			domainName = prop.getProperty("domain");

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
