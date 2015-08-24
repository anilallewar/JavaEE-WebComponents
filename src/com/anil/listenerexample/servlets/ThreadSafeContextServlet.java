/*
 * Created on Jan 6, 2009
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.anil.listenerexample.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author aallewar
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ThreadSafeContextServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		
		PrintWriter out = response.getWriter();
		out.println("<H2>The context attribute need to be made thread safe..<BR>");
		out.println("The only way to make context attributes thread safe is to synchronize on the <br>");
		out.println("app specific single ServletContext object.<br><br><br>");
		
		out.println("However, other parts of the application(other servlets/JSPs have to ensure that they <br>)");
		out.println("synchronize of the ServletContext object or else the thread synchronization will not be possible. <br><br>");
		
		//Synchronize on the ServletContext so that no other synchronized thread in the application uses it
		synchronized(getServletContext()){
			ServletContext context = getServletContext();
			context.setAttribute("foo", "42");
			context.setAttribute("bar", "84");
			
			out.println("The value of foo is: " + context.getAttribute("foo"));
			out.println("The value of bar is: " + context.getAttribute("bar"));
		}
		
		//The Session attributes also need to be synchronized..otherwise when the user opens
		//a new browser window, the container can use the same session for the client
		out.println("<BR><BR><H2>The Session attributes also need to be made thread safe..<BR>");
		out.println("The only way to make SESSION attributes thread safe is to synchronize on the <br>");
		out.println("HttpSession specific single session object.<br><br><br>");
		
		//Synchronize on the HttpSession so that no other request from the same client can
		//change it concurrently
		HttpSession session= request.getSession();
		synchronized(session){
			session.setAttribute("fooSession", "12");
			session.setAttribute("barSession", "06");
			
			out.println("The value of fooSession is: " + session.getAttribute("fooSession"));
			out.println("The value of barSession is: " + session.getAttribute("barSession"));
		}
		out.println("</H2>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doGet(request, response);
	}
	
}
