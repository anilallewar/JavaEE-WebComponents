/*
 * Created on Jan 10, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.anil.listenerexample.listners;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anil.listenerexample.model.Cat;

/**
 * @author aallewar
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RequestAttributeTestServlet extends HttpServlet implements ServletRequestAttributeListener{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
	
		PrintWriter out = response.getWriter();
		out.println("<H3>");
		
		out.println("Inside the RequestAttributeTestServlet doGet() method and testing ServletRequestAttributeListener.......<BR>");
		request.setAttribute("Anil", "Pallavi");
		out.println("The attribute value set in request is: " + request.getAttribute("Anil") + "<BR>");
		request.removeAttribute("Anil");
		
		Cat cat = new Cat();
		request.setAttribute("Cat", cat);
		Cat cat2 = cat;
		request.setAttribute("Cat", cat2);
		out.println("The attribute value set in request is: " + ((Cat)request.getAttribute("Cat")).toString() + "<BR>");
		request.removeAttribute("Cat");
		
		out.println("CHECK WHETHER THE ORDER IN WHICH LISTENERS ARE DESCRIBED IN DD AFFECTS THE NOTIFICATION ORDER");
		out.println("<BR><BR>");
		out.println("THE ServletRequestAttributeListener CLASSES ARE CALLED IN THE ORDER THEY ARE DEFINED IN THE DEPLOYMENT DESCRIPTOR");
		out.println("</H3>");
		out.flush();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		doGet(request, response);
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestAttributeListener#attributeAdded(javax.servlet.ServletRequestAttributeEvent)
	 */
	public void attributeAdded(ServletRequestAttributeEvent event) {
		System.out.println("com.anil.listenerexample.listners.RequestAttributeTestServlet	:" + "The request attribute added: " + event.getName() + " and the value is: " + event.getValue());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestAttributeListener#attributeRemoved(javax.servlet.ServletRequestAttributeEvent)
	 */
	public void attributeRemoved(ServletRequestAttributeEvent event) {
		System.out.println("com.anil.listenerexample.listners.RequestAttributeTestServlet	:" + "The request attribute removed: " + event.getName() + " and the value is: " + event.getValue());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestAttributeListener#attributeReplaced(javax.servlet.ServletRequestAttributeEvent)
	 */
	public void attributeReplaced(ServletRequestAttributeEvent event) {
		System.out.println("com.anil.listenerexample.listners.RequestAttributeTestServlet	:" + "The request attribute replaced: " + event.getName() + " and the value is: " + event.getValue());
	}
}
