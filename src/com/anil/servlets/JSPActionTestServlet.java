package com.anil.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anil.listenerexample.model.Dog;
import com.anil.model.Employee;
import com.anil.model.Person;

public class JSPActionTestServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		Employee p = new Employee();
		p.setName("Anil");
		p.setPet(new Dog("Doberman"));

		request.setAttribute("person", p);

		ArrayList<String> musicList = new ArrayList<String>();
		musicList.add("Mozart");
		musicList.add("Beethovan");
		musicList.add("Van Gogh");
		
		request.setAttribute("musicList", musicList);
		
		//Using this attribute as a normal EL will not work because of the . operator inbetween
		
		request.setAttribute("com.anil.anotherPerson", p);
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/jsps/JSPActionTest.jsp");
		rd.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
	}
}
