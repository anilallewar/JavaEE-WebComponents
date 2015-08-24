<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.List, java.util.Iterator, java.io.IOException" %>

<HTML>
	<HEAD>
		<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
			pageEncoding="ISO-8859-1"%>
		<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<META name="GENERATOR" content="IBM Software Development Platform">
		<META http-equiv="Content-Style-Type" content="text/css">
		<LINK href="../theme/Master.css" rel="stylesheet"
			type="text/css">
		<TITLE>Beer Select Advice</TITLE>
	</HEAD>

	<BODY>
		<h1 align="center"> BEER ADVICE JSP!!</h1>
		<P>
			<%
				List result = (List)request.getAttribute("beerResults");
				Iterator iterator = result.iterator();
			%>
			<h2>
			<ul>
			<%
				try{
					out.println("The list size is: " + result.size());
					out.println();
					while (iterator.hasNext()){
			%>
				<li>
			<%
						out.println(iterator.next());
			%>
				</li>	
			<%
					}
			%>
			</ul>
			</h2>
			<BR><BR>
			<h2>The beer size requested by the client is:
			<ul>
			
			<%
					String[] sizes = (String[])request.getAttribute("beerSize");
					if (sizes != null){
						for(int i=0; i<sizes.length; i++){
			%> 
				<li>
			<%
						out.println(sizes[i]);
			%>
				</li>
			<%			}
					}
			%>
			</ul>
			</h2>
			<BR><BR>
			<h2>
				The admin email id is:
			<%
					out.println(request.getAttribute("adminEmail"));
				} catch (IOException ie){
					ie.printStackTrace(System.out);
			}
			%>
			</h2>
			<BR><BR>
			The servlet initialization parameters can be tested at:
			<A href="initTesting.do">Initialization Parameter Testing</A>
		</P>	
		<br><br>
			The request method used is: <%=request.getMethod()%><br><br>
			The browser from which this request was sent is: <%=request.getHeader("User-Agent")%>
	</BODY>
</HTML>
