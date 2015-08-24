<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
			pageEncoding="ISO-8859-1"%>
		<META http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<META name="GENERATOR" content="IBM Software Development Platform">
		<META http-equiv="Content-Style-Type" content="text/css">
		<LINK href="../theme/Master.css" rel="stylesheet"
			type="text/css">
		<TITLE>CounterJSP.jsp</TITLE>
	</HEAD>
	<BODY>
		<%!
			private int doubleCount(){
				count *=2;
				return count;
			}
		%>

		<%!int count=1; %>
		<H2>The page counter value is: <%=doubleCount() %> </H2>
	</BODY>
</HTML>
