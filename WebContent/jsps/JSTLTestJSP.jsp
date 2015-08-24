<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.anil.model.Employee"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL tag testing!!</title>
</head>
<body>
	<c:import url="Header.jsp">
		<c:param name="subTitle" value="This is subtitle passed from calling JSP"/>
	</c:import>
	<h1 style="color:red"> The samples using JSTL tags are below: </h1>
	<br><br>
	<table border="1">
		<th>Accessed Using</th>
		<th> Attribute value </th>
		<tr>
			<td>The currentTip attribute that is obtained from the pageContent object in the request and displayed using EL \${requestScope.pageContent.currentTip}</b> is:</td>
			<td style="color:red">${requestScope.pageContent.currentTip}</td>
		</tr>
		<tr>
			<td>The currentTip attribute that is obtained from the pageContent object in the request and displayed using JSTL tags is:</td>
			<td style="color:red"><c:out value="${requestScope.pageContent.currentTip}" escapeXml="true"/></td>
		</tr>
		<tr>
			<td>The currentTip attribute that is obtained from the pageContent object in the request and displayed using JSTL tags but escapeXml="false" is:</td>
			<td style="color:red"><c:out value="${requestScope.pageContent.currentTip}" escapeXml="false"/></td>
		</tr>
		<tr>
			<td>The User-Agent header \${header['User-Agent']} and displayed using JSTL tags is:</td>
			<c:set var="browser" value="${header['User-Agent']}" scope="request"/>
			<td style="color:red"><c:out value="${browser}"/></td>
		</tr>
		
		<tr>
			<td>The User default value \${requestScope.user} and displayed using JSTL SET and OUT tags is:</td>
			<td style="color:red"><c:out value="${requestScope.user}" default="Guest"/></td>
		</tr>
		
		<tr>
			<td>Using the <b style="color:blue">c:forEach</b> loop to iterate over the movie collection</td>
			<td style="color:red">
				<table border="1">
					<c:forEach var="movie" items="${requestScope.pageContent.movieList}" varStatus="movieLoopCount">
						<tr>
							<c:if test="${movie eq 'Return of the King'}">
								<td>The movie is tested with if and is ${movie}</td>
							</c:if>
							<td>${movie} :and the count is: ${movieLoopCount.count}</td>
						</tr>
					</c:forEach>
				</table>
				<br>
				<b> Iterate a Map using c:forEach:</b>
				<br>
				<table border="1">
					<c:forEach var="employee" items="${requestScope.pageContent.employeeList}" varStatus="employeeLoopCount">
						<tr>
							<td>${employee.value.employeeId} :and the count is: ${employeeLoopCount.count}</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		
		<tr>
			<td>Showing the <b style="color:blue">c:choose</b> usage to print the breaks based on user choice that you can pass by appening the request param ?userPref= to the URL: ${param.userPref}</td>
			<td style="color:red">
				<c:choose>
					<c:when test="${param.userPref == 'performance'}">
						Now you can stop even if you <em>do</em> drive insanely fast.
					</c:when>
					<c:when test="${param.userPref == 'safety'}">
						Our brakes will never lock up, no matter how bad a driver you are.
					</c:when>
					<c:when test="${param.userPref == 'maintenance'}">
						Lost your tech job? No problem--you won't have to service these brakes
					for at least three years.
					</c:when>
					<c:otherwise>
						Our brakes are the best.
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
		
		<tr>
			<td> Using the <b style="color:blue">c:set</b> tag to set up values for the employees. Note that the value set can only be String or one of the primitives: </td>
			<td style="color:red">
				<c:set target="${requestScope.pageContent.employeeList}" property="Emp1">
					 new Employee
				</c:set>
				<c:out value="${requestScope.pageContent.employeeList['Emp1']}"/>
			</td>
		</tr>
		
		<tr>
			<td> Using the <b style="color:blue">c:remove</b> tag to remove the browser variable set in the request scope: </td>
			<td style="color:red">
				<c:remove var="browser" scope="request"/>
				<c:out value="${browser}"/>
			</td>
		</tr>
		
		<tr>
			<td> Using the <b style="color:blue">c:import</b> tag to import a page external to the web application:</td>
			<td> 
				<iframe height="200" width="200" scrolling="auto" >
					<c:import url="http://www.wickedlysmart.com/skyler/horse.html"/>
				</iframe>
			</td>
		</tr>
		
		<c:set var="last" value="Hidden Cursor" />
		<c:set var="first" value="Crouching Pixels"/>
		
		<c:url value="/inputComments.jsp" var="inputURL" >
			<c:param name="firstName" value="${first}" />
			<c:param name="lastName" value="${last}" />
		</c:url>

		<tr>
			<td> Using the <b style="color:blue">c:url</b> tag to encode a URL and to add the URL-rewriting if cookies are disabled. To disable cookies; set the security level to highest and you will see the appended SESSIONID if you open this link in a new browser:</td>
			<td>${inputURL}</td>
		</tr>
	</table>
	<c:set var="spouseAmt" value=".00"/>
	<br> The formatted number is 
	<fmt:parseNumber var="j" type="number" value="${spouseAmt}" />
	<c:out value="${j}"/>
	<br>
	<jsp:useBean id="pageContent" class="com.anil.model.CMSPageContent" scope="request">
	<%=pageContent.getCurrentTip() %>
	</jsp:useBean>
</body>
</html>