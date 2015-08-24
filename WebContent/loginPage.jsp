<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Login to Anil's application</title>
	</head>
	<body>
		<form method="POST" action="j_security_check">
			<label width="100"> User Id: </label>
			<input type="text" name="j_username" width="200"/> <br>
			<label width="100"> Password: </label>
			<input type="password" name="j_password" width="200"/> <br>
			<input type="submit" value="Enter"/>
		</form>
	</body>
</html>