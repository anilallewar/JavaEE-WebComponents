/*
 * Created on Jan 4, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.anil.listenerexample.listners;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.anil.listenerexample.model.Dog;

/**
 * @author aallewar
 * 
 *         TODO To change the template for this generated type comment go to
 *         Window - Preferences - Java - Code Style - Code Templates
 */
public class BeerAppContextListener implements ServletContextListener {
	/*
	 * //SQL Server database private final static String strConnDriver =
	 * "com.microsoft.jdbc.sqlserver.SQLServerDriver"; private final static
	 * String strConnURL =
	 * "jdbc:microsoft:sqlserver://10.10.11.6;User=sa;Password=wuteam;DATABASENAME=Agentlink2UAT;"
	 * ;
	 */

	// mySQL database
	private final static String strConnDriver = "com.mysql.jdbc.Driver";
	private final static String strConnURL = "jdbc:mysql://localhost:3306/lisa";

	/**
	 * This life cycle method is called when the application is initialized i.e.
	 * deployed by the container
	 * 
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet
	 *      .ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent contextEvent) {
		System.out
				.println("com.anil.listenerexample.listners.BeerAppContextListener	:"
						+ "*********I am initilizing the context from BeerAppContextListener**********");
		ServletContext context = contextEvent.getServletContext();

		// Create a new Dog object by getting the breed name from context and
		// then
		// add it to ServletContext
		String dogBreedName = context.getInitParameter("DogBreed");
		Dog dog = new Dog(dogBreedName);
		context.setAttribute("DogObject", dog);

		// Get the JNDI name and create the connection
		String jdbcName = context.getInitParameter("DataSourceName");
		try {
			Class.forName(strConnDriver);
			Connection con = DriverManager.getConnection(strConnURL, "root",
					"password");
			context.setAttribute(jdbcName, con);
			System.out
					.println("com.anil.listenerexample.listners.BeerAppContextListener	:"
							+ "The connection object is created and stored in context");
		} catch (SQLException sqe) {
			System.out
					.println("com.anil.listenerexample.listners.BeerAppContextListener	:"
							+ "SQL Server exception: " + sqe.getMessage());
		} catch (ClassNotFoundException cnfe) {
			System.out
					.println("com.anil.listenerexample.listners.BeerAppContextListener	:"
							+ "Class Not Found exception: " + cnfe.getMessage());
		}
	}

	/**
	 * This life cycle method is called when the container un-deploys this
	 * application
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 *      ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent contextEvent) {
		// TODO Auto-generated method stub
		System.out
				.println("com.anil.BeerApp.listeners.BeerAppContextListener:	 The application is being undeployed");
		ServletContext context = contextEvent.getServletContext();
		String jdbcName = context.getInitParameter("DataSourceName");

		try {
			Connection conn = (Connection) context.getAttribute(jdbcName);
			conn.close();
			System.out
					.println("Closed the connection set in Application context");
		} catch (SQLException sqe) {
			System.out
					.println("com.anil.listenerexample.listners.BeerAppContextListener	:"
							+ "SQL Server exception: " + sqe.getMessage());
		}

		context.removeAttribute(jdbcName);
	}

}
