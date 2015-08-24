<%@ attribute name="subTitle" required="true" rtexprvalue="true" %>
<%@ attribute name="fontColor" required="true" rtexprvalue="false" %>

<!-- Means that the tag body is considered plaintext and EL/scriptlet etc are 
	NOT evaluated. The only other legal values are "empty" and "scriptless" -->
<%@ tag body-content="tagdependent" dynamic-attributes='tagAttribs'%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<b> I added the Tag header here!!</b>
<h5>Todays date is <%=new java.util.Date()%> </h5>
The subTitle is evaluated if its an expression : <br>
<h5 style="color:green">${subTitle}</h5>
<h5><font color="$fontColor"><jsp:doBody/></font></h5>
<h5>The dynamic attrbutes passed are:</h5>
<div style="color:pink;">
	<c:forEach var="attribute" items="${tagAttribs}">
		<c:out value="${attribute.key} = ${attribute.value} ::"/>
	</c:forEach>
</div>
<br><br>
