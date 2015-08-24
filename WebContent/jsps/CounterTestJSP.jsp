
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Counter Testing</title>
</head>
<body>
<script language="javascript">
	document.writeln("Hostname is :"+location.host);
	for(i in navigator){
		document.writeln("<li>"+i+" = "+eval('navigator.'+i));
	}
</script>
	<%!
		private int changeCount(){
			count*=2;
			return count;
		}
	%>
	
	<hr width="100%" style="border: 3px dotted #0099CC" color="#000000" size="4">
	
	<%--JSP Comments - Java allows forward references --%>
	<%! private static int count=1; %>
	<br>
	<h1>The count of times the page has been hit is: <%=changeCount()%></h1>

	<hr width="100%" style="border: 3px dotted #0099CC" color="#000000" size="4">

	<%=(int)new Character('\u597d').charValue() %>
	&#22909;
	<br>
	
	<hr width="100%" style="border: 3px dotted #0099CC" color="#000000" size="4">
	
	<% int[] nums={12,45,34};
	    request.setAttribute("foo", nums); %>
	 ${5 + 3 lt 6} <br>
	 ${requestScope['foo'][0] ne 10 div 0} <br>
	 ${10 div 0} <br>
	 ${header['User-Agent']}<br>
	 ${pageContext.request.requestURI}<br>
     ${requestURI } - direct access <br>
     
     <hr width="100%" style="border: 3px dotted #0099CC" color="#000000" size="4">
     
	 <% x=3; %>
     <% int x=5; %>
     <%! int x=7; %>
     <br>
     <pre> 
     	value for
     	  &lt;% x=3; %&gt;
     	  &lt;% int x=5; %gt;
          &lt;%! int x=7; %gt;
     </pre>
     local x = <%=x%>, instance x = <%=this.x%>
     <br>
     
     <hr width="100%" style="border: 3px dotted #0099CC" color="#000000" size="4">
     
     	The color got from request is <b> <%=request.getParameter("color")%> </b>
     	<br><br>
     	Now including the JSP to which 2 more param with name="color" gets passed. Note that the 
     	param passed using the jsp standard action take precedence over the parameters already present in the request.
     	<br><br>
     	<jsp:include page="includedJSP.jsp" >
			<jsp:param name="color" value="red" />
			<jsp:param name="color" value="green" />
		</jsp:include>
		<br><br>
		The param passed to the included JSP are only available in the included JSP and are removed from
		the request once control returns to the calling JSP.
		<br><br>
		The color got from request AFTER call to include the JSP is <b><%=request.getParameter("color")%></b>
     	<br>
     	<!--  Today is <%= new java.util.Date() %>.Hava a nice day -->
</body>
</html>