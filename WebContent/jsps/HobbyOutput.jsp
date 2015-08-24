<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.ArrayList,java.util.Iterator"%>
<%--This statement will cause the EL on this page to be ignored --%>
<%@page isELIgnored="false" %>
<%--EL can also be ignored by specifying the value if <el-ignored> tag to true within
	the <jsp-property-group> tag within the <jsp-config> tag of web.xml.
	However the attribute in the JSP takes precedence over web.xml definition--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hobby Output!!</title>
</head>
<body>
	<%!//Overeride the JSP init method that gets called everytime the JSP servlet is initialized
	public void jspInit() {
		System.out
				.println("HobbyOutput.jsp : The jspInit() method is being called");
	}%>
	<h1 style="color:red"> The friends who share your hobby of <%=request.getParameter("selectHobby") %> are: </h1>
	<br><br>
	<%
		ArrayList list = (ArrayList)request.getAttribute("names");
		Iterator iterator = list.iterator();
		if (iterator!=null){
	%>		
		<ul>
			<%	while(iterator.hasNext()){
			%>
				<li> <%=iterator.next() %></li>
			<%		
			}
			%>
		</ul>		
	<%
		}
	%>
	<table border="1">
		<th>Accessed Using</th>
		<th> Attribute value </th>
		
		<tr>
			<% Float one = new Float(43.5);
				pageContext.setAttribute("foo", one);%>
			<td>pageContext.getAttribute("foo")</td>
			<td><%=pageContext.getAttribute("foo") %></td>
		</tr>
		<tr>
			<% Float two = new Float(22.4);
				pageContext.setAttribute("boo",two,PageContext.SESSION_SCOPE);%>
			<td>pageContext.getAttribute("boo", PageContext.SESSION_SCOPE)</td>
			<td><%=pageContext.getAttribute("boo", PageContext.SESSION_SCOPE) %></td>
		</tr>
		<tr>
			<td>session.getAttribute("boo")</td>
			<td><%=session.getAttribute("boo") %></td>
		</tr>
		<TR>
			<%Float three = new Float(17653.56);
				pageContext.setAttribute("coo",three, PageContext.APPLICATION_SCOPE); %>
			<td>pageContext.getAttributesScope("coo") - This returns an int specifying the scope of the attribute</td>
			<td><%=pageContext.getAttributesScope("coo") %></td>
		</TR>
		<tr>
			<td>pageContext.getAttribute("coo", PageContext.APPLICATION_SCOPE)</td>
			<td><%=pageContext.getAttribute("coo", PageContext.APPLICATION_SCOPE) %></td>
		</tr>
		<tr>
			<td>pageContext.getAttribute("coo", PageContext.REQUEST_SCOPE)</td>
			<td><%=pageContext.getAttribute("coo", PageContext.REQUEST_SCOPE) %></td>
		</tr>
		<tr>
			<td>Finding the variable without specifying scope using the <b>findAttribute()</b> method..The order in which it is 
			searched is PageContext -> Request -> Session -> Application Context <br>
			pageContext.findAttribute("coo")</td>
			<td><%=pageContext.findAttribute("coo") %></td>
		</tr>
		<tr>
			<td>\${applicationScope.coo} -- If isELIgnored then next column will have the EL expression</td>
			<td>&nbsp;${applicationScope.coo}</td>
		</tr>
		
		<%--If the class attribute is not specified, then the bean must exist in the 
		specified scope for the useBean tag to work --%>
		<jsp:useBean id="person" type="com.anil.model.Person" scope="request">
			<jsp:setProperty name="person" property="name" value="DefaultNameSetConditionally"/>
		</jsp:useBean>
		<tr>
			<td>The person object set in request and acessed using JSP standard action is</td>
			<td><jsp:getProperty name="person" property="name"/></td>
		</tr>
		
		<%-- We are specifying the reference type as Person and the object type as Employee--%>
		<jsp:useBean id="personNotExisting" type="com.anil.model.Person" class="com.anil.model.Employee" scope="request">
			<%-- This causes the name property to be set only if the bean is created new by the 
			underlying servlet--%>
			<jsp:setProperty name="personNotExisting" property="name" value="DefaultNameSetConditionally"/>
		</jsp:useBean>
		<tr>
			<td>The person object NOT set anywhere. The object is newly initialzed and hence the name would be set using the setProperty action</td>
			<td><jsp:getProperty name="personNotExisting" property="name"/></td>
		</tr>
	</table>
	
</body>
</html>