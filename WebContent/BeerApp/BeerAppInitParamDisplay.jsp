<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import = "java.util.ArrayList, java.util.ListIterator, java.io.IOException, com.anil.listenerexample.model.Dog"%>

<HTML>
<HEAD>
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		pageEncoding="ISO-8859-1"%>
	<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<META name="GENERATOR" content="IBM Software Development Platform">
	<META http-equiv="Content-Style-Type" content="text/css">
	<LINK href="../theme/Master.css" rel="stylesheet"
		type="text/css">
	<TITLE>BeerApp Initilization Parameters</TITLE>
</HEAD>
<BODY>
	<H1>Here are the Beep Application Initialization Parameters</H1>
	<br><br>
	<H2>The Application Context Initialization parameters are shared across
		all Servlets and JSPs in the BeerApp application: </H2>
	<BR><BR>
	<H3>
		<Table border="1">
			<TH>Sr #</TH>
			<TH>Init Param Name</TH>
			<TH>Init Param Value</TH>
			<%
				try{
					int count=1;
					ArrayList contextList= (ArrayList)request.getAttribute("ContextParam");
					ListIterator listIterate = contextList.listIterator();
					while (listIterate.hasNext()){
			%>
			<TR>
				<TD><%=count++ %></TD>
				<TD><% out.println(listIterate.next()); %></TD>
				<TD><% out.println(listIterate.next()); %></TD>		
			</TR>
			<%} %>
		</Table>
	</H3>	
	<BR><BR>
	<H2>The Servlet Config Initialization parameters that were passed by
		the calling servlet: </H2>
	<BR><BR>
	<H3>
		<Table border="1">
			<TH>Sr #</TH>
			<TH>Init Param Name</TH>
			<TH>Init Param Value</TH>
			<%
					count=1;
					ArrayList configList= (ArrayList)request.getAttribute("ServletInitParam");
					listIterate = configList.listIterator();
					while (listIterate.hasNext()){
			%>
			<TR>
				<TD><%=count++ %></TD>
				<TD><% out.println(listIterate.next()); %></TD>
				<TD><% out.println(listIterate.next()); %></TD>		
			</TR>
			<%		}
				}catch(IOException ie){
					System.out.println(ie.getMessage());
				} %>
		</Table>
	</H3>	
	<BR><BR>
	<H2>The query execution results for the query Select count(*) from INFORMATION_SCHEMA.TABLES is: 
		<%=request.getAttribute("QueryResult") %>
	</H2>	
	<BR><BR>
	<H2>The Dog that was available in session is:
		<%=((Dog)session.getAttribute("DogObject")).getBreed()%>
	<BR>
	Removing the Dog object from Session....
	<% session.removeAttribute("DogObject"); %>
	</H2>
	
</BODY>
</HTML>
