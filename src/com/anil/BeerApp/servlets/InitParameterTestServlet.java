/*
 * Created on Jan 4, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.anil.BeerApp.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.anil.listenerexample.model.Dog;

/**
 * @author aallewar
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class InitParameterTestServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		ArrayList initConfigList = null;
		ArrayList initContextList = null;
		//Get the servlet initialization parameters. These are availale only to the servlet
		//for which the initialization parameters are defined
		ServletConfig config = getServletConfig();
		Enumeration enumaration = config.getInitParameterNames();
		while(enumaration.hasMoreElements()){
			if (initConfigList==null){
				initConfigList=new ArrayList();
			}
			String paramName = (String)enumaration.nextElement();
			initConfigList.add(paramName);
			// Remember that the getInitParameter() takes a String argument and also returns a String
			initConfigList.add(config.getInitParameter(paramName));
		}
		
		System.out.println("The config parameter list size is: " + initConfigList.size());
		request.setAttribute("ServletInitParam", initConfigList);
		
		//Get the application context parameters. These are available to all the servlets and
		//JSPs within the webapp for which the context initialization parameters are defined
		
		//We use the same enumeration to get reference to context parameters
		ServletContext context = getServletConfig().getServletContext();
		enumaration = context.getInitParameterNames();
		while(enumaration.hasMoreElements()){
			if(initContextList == null){
				initContextList = new ArrayList();
			}
			String paramName = (String)enumaration.nextElement();
			initContextList.add(paramName);
			// Remember that the getInitParameter() takes a String argument and also returns a String
			initContextList.add(context.getInitParameter(paramName));
		}
		
		System.out.println("The context parameter list size is: " + initContextList.size());
		request.setAttribute("ContextParam", initContextList);
		
		Dog dog = (Dog)context.getAttribute("DogObject");
		//Get the session and set the Dog object in the session. We will remove it from session in the JSP
		HttpSession session = request.getSession();
		session.setAttribute("DogObject", dog);
		
		//Checking out the database object that was set in the context by the listner
		String jdbcName = context.getInitParameter("DataSourceName");
		Connection con = (Connection)context.getAttribute(jdbcName);
		
		try{
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("Select count(*) from INFORMATION_SCHEMA.TABLES");
			if (rs.next()){
				String count = rs.getString(1);
				System.out.println("The results obtained after executing the query is: " + count);
				request.setAttribute("QueryResult", count);
			}
		}catch(SQLException sqe){
			System.out.println(sqe.getMessage());
		}
		//Dispatch the request to the view JSP
		//The Dispatcher can also be obtained from the Servlet Context. If the RequestDispather is through ServletContext
		//it would require the path relative to the web app root
		RequestDispatcher view = getServletContext().getRequestDispatcher(response.encodeURL("/BeerApp/BeerAppInitParamDisplay.jsp"));
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		//Call the doGet() method
		doGet(request, response);
	}
}
