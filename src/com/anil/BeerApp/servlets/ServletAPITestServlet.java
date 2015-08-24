/*
 * Created on Jan 1, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.anil.BeerApp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author aallewar
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class ServletAPITestServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("The server port where the request first came is: "
				+ request.getServerName() + " : request.getServerPort(): "
				+ request.getServerPort() + "<br>");
		out.println("The server post where the request ended finally is: "
				+ request.getLocalName() + " : request.getLocalPort(): "
				+ request.getLocalPort() + "<br>");
		out.println("The client port from where the request was initiated: "
				+ request.getRemoteHost() + " request.getRemotePort() : "
				+ request.getRemotePort() + "<br>");

		// Will be null if POST request is not used.
		// Rememeber the parameters for get are part of resource request; not
		// part of resource body
		String contentLength = request.getHeader("Content-Length");
		int intMaxForWard = (contentLength == null ? 0 : Integer
				.parseInt(contentLength));
		out
				.println("The content Length using the request.getHeader() method is: "
						+ intMaxForWard + " : " + contentLength + "<br>");

		String contentTypeAccept = request.getHeader("Accept");
		out
				.println("The browser said that it can accept the following type of MIME types: "
						+ contentTypeAccept + "<br>");

		// Checking out with request.getIntHeader() method
		intMaxForWard = request.getIntHeader("Max-Forwards");
		out
				.println("The number of max hops using the request.getIntHeader() method is: "
						+ intMaxForWard + "<br>");

		// This will give an IllegalStateException when we are redirecting
		// because we have already written to the stream
		// before redirecting. However we can still continue writing to the same
		// stream.
		// out.flush();

		// Will give an error because the Writer has already been obtained
		// response.getOutputStream().write(32);

		out.println("Checking out the cookies sent by the request: <BR><BR>");

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int j = 0; j < cookies.length; j++) {
				out
						.println("The cookie name is: "
								+ cookies[j].getName()
								+ " and the value is: "
								+ cookies[j].getValue()
								+ " and cookie max age is(-1 makes the cookie disappear when the browser exists): "
								+ cookies[j].getMaxAge() + "<BR>");
			}
		}

		String redirect = request.getParameter("whetherRedirect");
		if ("NO".equalsIgnoreCase(redirect)) {
			Date date = new Date();
			out.println("<h2>Todays date is: " + date.toString() + "</h2>");
		} else {
			// If the redirect parameter is not there or it not equal to NO,
			// send the user to another URL
			/*
			 * The encodeRedirectURL() method is used to force URL-rewriting
			 * when you want to redirect the request to a different URL , but
			 * use the existing session.
			 * 
			 * If you want to forward to another resource in the same web app
			 * using RequestDispatcher, then use response.encodeURL() to force
			 * the container to do URL-rewriting.
			 */
			response.sendRedirect(response.encodeRedirectURL("basicservlet"));
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}