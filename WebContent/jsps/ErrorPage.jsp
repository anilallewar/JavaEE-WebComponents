
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Error in sample application!!</title>
	</head>
	<body>
		<h2 style="color:green">
			<c:choose>
				<c:when test="${param.errorCode==404}">
					The requested web page cannot be found on the server and error code returned is ${param.errorCode}.
				</c:when>
				<c:when test="${param.errorCode==500}">
					There was an error while executing you request on the server and error code returned is ${param.errorCode}.The exception thrown by the server is ${pageContext.exception}.
				</c:when>
				<c:otherwise>
					Some other error on the server and error code returned is ${param.errorCode}.You caused a ${pageContext.exception} on the server.
				</c:otherwise>
			</c:choose>
		</h2>
		<br><br>
	</body>
</html>