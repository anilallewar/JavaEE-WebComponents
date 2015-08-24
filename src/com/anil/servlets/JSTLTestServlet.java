/**
 * 
 */
package com.anil.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anil.model.CMSPageContent;
import com.anil.model.Employee;

/**
 * @author anila
 * 
 */
@SuppressWarnings("serial")
public class JSTLTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		CMSPageContent content = new CMSPageContent();
		content.setCurrentTip("<b></b> This displays text in bold!");
		String[] movieList = { "Amelie", "Return of the King", "Mean Girls" };
		content.setMovieList(Arrays.asList(movieList));
		
		Map<String, Employee> employeeList = new HashMap<String, Employee>();
		Employee e1 = new Employee();
		e1.setEmployeeId(1);
		e1.setName("Anil");
		employeeList.put("Emp1", e1);
		Employee e2 = new Employee();
		e2.setEmployeeId(2);
		e2.setName("Allewar");
		employeeList.put("Emp2", e2);
		Employee e3 = new Employee();
		e3.setEmployeeId(3);
		e3.setName("Pallavi");
		employeeList.put("Emp3", e3);
		
		content.setEmployeeList(employeeList);
		request.setAttribute("pageContent", content);

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsps/JSTLTestJSP.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		doGet(request, response);
	}
}
