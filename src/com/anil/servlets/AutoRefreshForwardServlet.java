package com.anil.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutoRefreshForwardServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String whetherRefresh = request.getParameter("refresh");
		System.out.println("The refresh parameter is: " + whetherRefresh);
		if ("true".equalsIgnoreCase(whetherRefresh)){
			request.getSession().setAttribute("refresh", "true");
		}else{
			request.getSession().setAttribute("refresh", "false");
		}

		RequestDispatcher rd = request
				.getRequestDispatcher("/jsps/AutoRefreshExample.jsp");
		rd.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		doGet(request, response);
	}
}
