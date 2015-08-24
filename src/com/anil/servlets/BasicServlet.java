package com.anil.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet {

	/**
	 * Standard doGet() method
	 * 
	 * Ideally it should run with the ServletException not being declared as
	 * thrown since overriding methods can widen scope and throw fewer/no
	 * exceptions. However the class compiles but does not get loaded by the web
	 * container.
	 **/
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// FileInputStream fileIn = new
		// FileInputStream("C:\\Anil Allewar\\workspace\\SCJWDAnil\\WebContent\\BeerApp\\310-081.pdf");

		// Doesn't work??
		// FileInputStream fileIn = new
		// FileInputStream("..\\..\\..\\..\\..\\BeerApp\\310-081.pdf");

		// The getResourceAsStream() method requires you to start with a forward
		// slash("/")
		// which represents the root of the web app
		InputStream fileIn = getServletContext().getResourceAsStream(
				"/BeerApp/310-081.pdf");

		// The same PDF file can be shown in browser by typing the below URL
		// http://localhost:9080/SCJWDAnil//BeerApp/310-081.pdf

		int read = 0;
		byte[] bytes = new byte[1024];

		response.setContentType("application/pdf");
		// Typically the content-type should be provided before obtaining the
		// OutputStream or the Writer
		OutputStream os = response.getOutputStream();
		while ((read = fileIn.read(bytes)) != -1) {
			os.write(bytes, 0, read);
		}

		os.flush();
		os.close();
		fileIn.close();
	}

	/**
	 * Standard doPost() method
	 **/

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}