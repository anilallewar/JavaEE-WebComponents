package com.anil.BeerApp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anil.BeerApp.model.BeerExpert;

public class BeerSelectServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		System.out.println("You have reached the doPost() method <br>");
		// Get multiple values associated with the request parameter
		String[] beerSize = request.getParameterValues("size");
		request.setAttribute("beerSize", beerSize);

		// Get the initialization parameter and set it for use by the JSP
		String adminEmailId = getServletConfig().getInitParameter("adminEmail");
		request.setAttribute("adminEmail", adminEmailId);

		String color = request.getParameter("color");
		BeerExpert expert = new BeerExpert();
		List<String> results = expert.getBeerList(color);

		/*
		 * out.println("Beer Selection Advice: <br> "); out.println("The
		 * selected color is: " + color + " <br> "); out.println("The beer
		 * suggested for your selection is: <br> "); out.println(" <ul> ");
		 * Iterator iterator = results.iterator();
		 * 
		 * while(iterator.hasNext()){ out.println(" <li> " +
		 * (String)iterator.next()); }
		 * 
		 * out.println(" </ul><br> ");
		 */

		// Set the results is request scope
		request.setAttribute("beerResults", results);
		// Get the request dispatcher and forward the request to the JSP
		// No need to add BeerApp in the Dispatcher because that is already part
		// of the context
		RequestDispatcher reqDispatcher = request
				.getRequestDispatcher("BeerSelectAdvice.jsp");
		reqDispatcher.forward(request, response);

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		// Call the doPost method to do the processing
		doPost(request, response);
		out.println("You had actually reached the doGet() method");
	}
}