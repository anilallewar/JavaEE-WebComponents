package com.anil.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anil.model.Employee;
import com.anil.model.Person;

@SuppressWarnings("serial")
public class HobbyServlet extends HttpServlet {

	private static ArrayList<String> skiing = new ArrayList<String>();
	private static ArrayList<String> extremeknitting = new ArrayList<String>();
	private static ArrayList<String> alpineskating = new ArrayList<String>();
	private static ArrayList<String> speeddating = new ArrayList<String>();
	private static HashMap<String, ArrayList<String>> hobbyMap = new HashMap<String, ArrayList<String>>();

	static {
		// Add skiing data
		skiing.add("Anil");
		skiing.add("Allewar");
		hobbyMap.put("skiing", skiing);

		// Add extrem knitting data
		extremeknitting.add("Vinayak");
		extremeknitting.add("Shinde");
		hobbyMap.put("extreme knitting", extremeknitting);

		// Add alpine skating data
		alpineskating.add("Avinash");
		alpineskating.add("Shete");
		hobbyMap.put("alpine skating", alpineskating);

		// Add speed dating data
		speeddating.add("Deepak");
		speeddating.add("Gupta");
		hobbyMap.put("speed dating", speeddating);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String selectedHobby = request.getParameter("selectHobby");
		System.out
				.println("com.anil.servlets.HobbyServlet	: The selected hobby is: "
						+ selectedHobby);
		request.setAttribute("names", hobbyMap.get(selectedHobby));

		// Put the Person in the request scope
		Person p = new Employee();
		p.setName("Anil");
		request.setAttribute("person", p);

		System.out
				.println("com.anil.servlets.HobbyServlet	: request.isUserInRole(\"Funky\"): "
						+ request.isUserInRole("Funky"));
		if (request.isUserInRole("Funky")) {
			response
					.sendError(
							HttpServletResponse.SC_FORBIDDEN,
							"Well LOL:), I decided not to allow FUNKY role to access!!. Check web.xml for the actual mapping of the <role-link> "
									+ "element under <servlet> - <security-role-ref> to find the actual mapping to the <security-role> element");
			response.flushBuffer();
		} else if (request.isUserInRole("admin")) {
			response
					.sendError(
							HttpServletResponse.SC_FORBIDDEN,
							"Well LOL:), I decided not to allow ADMIN role to access!!. Check web.xml for the actual mapping of the <role-link> "
									+ "element under <servlet> - <security-role-ref> to find the actual mapping to the <security-role> element");
			response.flushBuffer();
		} else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/jsps/HobbyOutput.jsp");
			rd.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
