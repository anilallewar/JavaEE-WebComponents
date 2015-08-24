<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hobby Selection!!</title>
</head>
<body>
	<form action="/SCJWDAnil/hobbyOut.do" method="post">
		<h1 style="color:red;">Please select your hobby.. </h1>
		<select name="selectHobby">
			<option value="skiing">SKIING</option>
			<option value="extreme knitting">EXTREME KNITTING</option>
			<option value="alpine skating">ALPINE SKATING</option>
			<option value="speed dating">SKIING</option>
		</select> 
		<br><br>
		<input type=submit value="Submit"/>
		<br><br>
		<h2> The init param that comes from web.xml: The application throws a "org.apache.jasper.JasperException : scripting Scripting elements ( &lt;%!, &lt;jsp:declaration, &lt;%=, &lt;jsp:expression, &lt;%, &lt;jsp:scriptlet ) are disallowed here" if &lt;scripting-invalid&gt; tag is true for this JSP in web.xml</h2> <br> <br>
		<h3>
			<%-- 
			<%=config.getInitParameter("HobbyInputParam") %>
			--%>			
			${pagecontext.servletConfig.HobbyInputParam} 
		</h3>
	</form>
</body>
</html>