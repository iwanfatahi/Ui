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
@WebServlet(name = "logout", urlPatterns = { "/logout" })
public class SSOLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String domainName = "";

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
		readProperties();
		//
		boolean hasCookie = false;
		Cookie myCookie = null;
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase("simbiosis")) {
					myCookie = cookie;
					hasCookie = true;
				}
			}
		}

		if (hasCookie) {
			//
			myCookie.setValue(null);
			if (!domainName.isEmpty()) {
				myCookie.setDomain(domainName);
			}
			myCookie.setMaxAge(0);
			myCookie.setPath("/");
			response.addCookie(myCookie);
		}
		//
		String urlRedirect = request.getParameter("redirect");
		// New location to be redirected
		response.setHeader("Refresh", "1;url=" + urlRedirect);
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
