/*
 * Created on Jan 10, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.anil.listenerexample.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author aallewar
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class SessionTestingServlet extends HttpServlet {

	private int count = 0;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out
				.println("<H2>Adding an attribute in session and trying to access it after setting the MaxInactiveInterval to 10<BR><Br>" + 
						"What this means is that the session will be invalidated every 10 seconds.");

		HttpSession session = request.getSession();
		// Try to get session attribute that is set at the end of this
		// method..If the setMaxInactiveInterval(0)
		// method does not work then the value will be value set when the user
		// calls the servlet 2nd time from the same browser

		String bar = (String) session.getAttribute("Allewar");
		out
				.println("The value of session variable set at the end of the method is: "
						+ bar + "<BR><BR>");

		session.setAttribute("Anil", "Allewar");
		/*
		 * If this works with Max Inactive Interval 0;you would get following exception on the next line
		 * java.lang.IllegalStateException: getAttribute: Session already invalidated
		 */
		session.setMaxInactiveInterval(10);
		// Try to get session attribute that is set at the start..If the
		// setMaxInactiveInterval(0)
		// method does not work then the value will be value set when the method
		// retrieves it from session
		String foo = (String) session.getAttribute("Anil");
		out
				.println("The value of session variable set before calling session.setMaxInactiveInterval(10) is: "
						+ foo + "<BR><BR>");
		if (session.isNew()) {
			out.println("This is a new session<BR>");
		} else {
			out.println("Welcome back<BR>");
		}
		session.setAttribute("Allewar", "Pallavi");

		out.println("Checking out the cookies sent by the request: <BR><BR>");

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int j = 0; j < cookies.length; j++) {
				out.println("The cookie name is: " + cookies[j].getName()
						+ " and the value is: " + cookies[j].getValue()
						+ "<BR>");
			}
		}

		// Setting a cookie
		Cookie nameCookie = new Cookie("Name", "AnilGreat" + count++);
		// Setting cookie max age to -1 causes the cookie to be destoyed when
		// client browser closes
		out.println("The cookie max age in seconds set by default is: "
				+ nameCookie.getMaxAge() + "<BR><BR>");
		response.addCookie(nameCookie);
		out.flush();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
