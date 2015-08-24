<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="dice" uri="/tlds/DiceFunctions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Action Output!!</title>
</head>
<body>
	Statically adding the header file to this JSP. This copies the source of the header JSP at compilation time <br><br>
	<%@include file="Header.jsp"%>
	Now including the file using jsp:include. This includes the response of Header jsp at runtime. There is additional overhead of evaluating the 
	JSP every time this JSP is called <br><br>
	<jsp:include page="Header.jsp"/>
	<h1 style="color:red"> The samples using JSP standard action and Expression Language(EL) are below: </h1>
	<br><br>
	<table border="1">
		<th>Accessed Using</th>
		<th> Attribute value </th>
		<tr>
			<jsp:useBean id="person" type="com.anil.model.Person" class="com.anil.model.Employee" scope="request">
				<jsp:setProperty name="person" property="name" value="NameNotSetAlready"/>
			</jsp:useBean>
			<td>The JSP attribute that is obtained from the Person object in the request is:</td>
			<td style="color:red"><jsp:getProperty name="person" property="name"/></td>
		</tr>
		<tr>
			<jsp:useBean id="personNotExisting" type="com.anil.model.Person" class="com.anil.model.Employee">
				<jsp:setProperty name="personNotExisting" property="name" value="NameNotSetAlready"/>
			</jsp:useBean>
			<td>The JSP attribute that is obtained from the Person object that is not there in any scope and newly created:</td>
			<td style="color:red"><jsp:getProperty name="personNotExisting" property="name"/></td>
		</tr>

		<tr>
			<jsp:useBean id="personFromRequest" class="com.anil.model.Employee">
				<jsp:setProperty name="personFromRequest" property="name"/>
				<jsp:setProperty name="personFromRequest" property="employeeId" param="userId"/>
				<%--
					This causes an "java.lang.IllegalArgumentException: argument type mismatch"
					exception as JPS will not do the implicit conversion from String to primitive 
					if you do not use the param attribute
						<jsp:setProperty name="personFromRequest" property="employeeId" value="<%=request.getParameter("userId")%>"/>
				--%>
			</jsp:useBean>
			<td>The JSP attribute that is obtained from the Person object that is created from request data:</td>
			<td style="color:red"><jsp:getProperty name="personFromRequest" property="name"/> : <jsp:getProperty name="personFromRequest" property="employeeId"/></td>
		</tr>

		<tr>
			<td>The Dog attribute that is obtained from the Person object in the request and displayed using EL <b style="color:blue">\${requestScope.person.pet.breed}</b> is:</td>
			<td style="color:red">${requestScope.person.pet.breed}</td>
		</tr>

		<tr>
			<td>The dog attribute using [] notation and displayed using EL <b style="color:blue">\${requestScope.person.pet["breed"]}</b> is:</td>
			<td style="color:red">${requestScope.person.pet["breed"]}</td>
		</tr>

		<tr>
			<td>The music ArrayList is obtained from request and displayed using EL <b style="color:blue">\${requestScope.musicList}</b> is:</td>
			<td style="color:red">${requestScope.musicList}</td>
		</tr>

		<tr>
			<td>The 2nd item in the music ArrayList is obtained from request and displayed using EL <b style="color:blue">\${requestScope.musicList["1"]}</b> is:</td>
			<td style="color:red">${requestScope.musicList["1"]}</td>
		</tr>
		
		<tr>
			<td>The 1st Food parameter is obtained from request(if using <code>param</code> and not <code>paramValues</code>) and displayed using EL <b style="color:blue">\${param.food}</b> is:</td>
			<td style="color:red">${param.food}</td>
		</tr>
		
		<tr>
			<td>The 2nd Food parameter is obtained from request(multiple values for same param) and displayed using EL <b style="color:blue">\${paramValues.food[1]} : $\{paramValues["food"][1]} : $\{paramValues["food"]["1"]}</b> is:</td>
			<td style="color:red">${paramValues.food[1]} : ${paramValues["food"][1]} : ${paramValues["food"]["1"]}</td>
		</tr>
		
		<tr>
			<td>Using the header object to find the host and displayed using EL <b style="color:blue">\${header.host}</b> is:</td>
			<td style="color:red">${header.host}</td>
		</tr>
		
		<tr>
			<td>The requestScope is not request object; but a map of request attributes. You need to access request object through the pageContext object <b style="color:blue">\${pageContext.request.method}</b>:</td>
			<td style="color:red">${pageContext.request.method}</td>
		</tr>

		<tr>
			<td> Using this attribute as a normal EL will not work because of the . operator inbetween. Hence we use the request Scope [] operator to access it <b style="color:blue">\${requestScope["com.anil.anotherPerson"].name}</b>:</td>
			<td style="color:red">${requestScope["com.anil.anotherPerson"].name}</td>
		</tr>
		
		<tr>
			<td> Using Using the cookie array to get the JSESSIONID cokie value. Displayed through EL using <b style="color:blue">\${cookie.JSESSIONID.value}</b>:</td>
			<td style="color:red">${cookie.JSESSIONID.value}</td>
		</tr>
		
		<tr>
			<td> The context parameters are available to the EL but remember these are CONTEXT init parameters and NOT Servlet init parameters. Displayed through EL using <b style="color:blue">\${initParam.DataSourceName}</b>:</td>
			<td style="color:red">${initParam.DataSourceName}</td>
		</tr>
		
		<tr>
			<td>Using tag lib to call standard Java static function that is defined through tag library. Displayed through EL using <b style="color:blue">\${dice:rollIt(6)}</b>:</td>
			<td style="color:red">${dice:rollIt(6)}</td>
		</tr>
		
	</table>
</body>
</html>