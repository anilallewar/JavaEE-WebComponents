
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.util.List,java.util.ArrayList, com.anil.model.Employee, com.anil.listenerexample.model.Dog" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="customTag" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="developedTags" uri="http://com.anil.tags.customtags"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Custom Tag Examples!!</title>
	</head>
	
	<customTag:Header subTitle="${header['User-Agent']}" fontColor="#660099" attribute1="Anil" attribute2="Allewar">
		Body of the really long tag that we did 
		not want to add to the tag since it would have looked stupid
		with so much of text!!
	</customTag:Header>
	
	<hr width="100%" style="border: 3px dotted #0099CC" color="#000000" size="4">

	<body>
		About to do a risky thing and catching with <b style="color:blue">c:catch</b> tag: <br>
		<c:catch var="caughtException">
			<% int x = 10/0; %>
			After the catch...
		</c:catch>
		If this prints; we survived <b style="color:blue">${caughtException.message}</b> exception!!
	</body>
	<br>
	
	<hr width="100%" style="border: 3px dotted #0099CC" color="#000000" size="4">
		
	<h3 style="color:red;">Using the SIMPLE output tag to print messages in user provided font color</h3>
	
	<developedTags:output output="Printed using custom tag handler" fontColor="#660099">
		This is not printed!!
	</developedTags:output>
	
	<br>
	<developedTags:output output="Second line" fontColor="#AA0099">
		The Message that is set in the tag is : ${message}
	</developedTags:output>
	
	<br>
	<developedTags:output output="${header['User-Agent']}" fontColor="#AA7309"/>
	<br>
	
	<hr width="100%" style="border: 3px dotted #0099CC" color="#000000" size="4">	
	
	<h3 style="color:red;">Using the SIMPLE iterate tag to roll over a Employee collection</h3>
	<% 
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee e1 = new Employee();
		e1.setEmployeeId(1);
		e1.setName("Sam");
		employeeList.add(e1);
		Employee e2 = new Employee();
		e2.setEmployeeId(2);
		e2.setName("Brown");
		employeeList.add(e2);
		Employee e3 = new Employee();
		e3.setEmployeeId(3);
		e3.setName("Casandra");
		employeeList.add( e3);
		request.setAttribute("EmployeeList", employeeList);
	%>
	
	<div style="color:brown;">
		<developedTags:iterate items="${requestScope.EmployeeList}" varName="currentEmployee">
			The current employee is: ${currentEmployee.employeeId} - ${currentEmployee.name}
			<br>
		</developedTags:iterate>
	</div> 

	<hr width="100%" style="border: 3px dotted #0099CC" color="#000000" size="4">
	
	<br>
	
	<h3 style="color:red;">Explaination of values returned by the CLASSIC tag methods</h3>
	
	<table BORDER="1" BORDERCOLOR="#FF6342">
		<th style="color:#A62335;"> Method </th>
		<th style="color:#A62335;"> Classic Tag Return Value </th>
		<th style="color:#A62335;"> What it means </th>
	
		<tr>
			<td rowspan="2"><b>doStartTag()</b></td>
			<td style="text-decoration: underline;"> SKIP_BODY (Default if you don't overide)</td>
			<td> This tells not to evaluate the body and go straight to the doEndTag()
		 		 method
		 	</td>
		</tr>
		
		<tr>
			<td> EVAL_BODY_INCLUDE </td>
			<td> This tells the container to evaluate the body ONLY once </td>
		</tr>
		
		<tr>
			<td rowspan="2"><b>doAfterBody()</b></td>
			<td style="text-decoration: underline;"> SKIP_BODY (Default if you don't overide)</td>
			<td> This tells not to evaluate the body and go straight to the doEndTag()
		 		 method
		 	</td>
		</tr>
		
		<tr>
			<td> EVAL_BODY_AGAIN</td>
			<td> This tells the container to evaluate the body again. Once the body is evaluated, the control
			comes back to the doAfterBody() method. </td>
		</tr>
		
		<tr>
			<td rowspan="2"><b>doEndTag()</b></td>
			<td style="text-decoration: underline;"> EVAL_PAGE (Default if you don't overide)</td>
			<td> This tells the container to continue evaluating the rest of the page. </td>
		</tr>
		
		<tr>
			<td> SKIP_PAGE </td>
			<td> If you return a SKIP_PAGE it is basically same as throwing a SkipPageException 
				and will cause rest of the page to NOT render.
		 	</td>
		</tr>
		
		<tr>
			<td> </td>
			<td> </td>
		</tr>
	</table>
	
	<hr width="100%" style="border: 3px dotted #0099CC" color="#000000" size="4">
	
	<h3 style="color:red;">Using the CLASSIC output tag to print some messages</h3>
	<div style="color:green;">
		<developedTags:classicoutput output="This is data passed to classic output tag!">
			Body of the tag printing JSESSIONID value: ${cookie.JSESSIONID.value}
			<br>
		</developedTags:classicoutput>
	</div>	

	<hr width="100%" style="border: 3px dotted #0099CC" color="#000000" size="4">
	
	<h3 style="color:red;">Using the CLASSIC iterate tag to roll over dog collection</h3>
	
	<% 
		List<Dog> dogList = new ArrayList<Dog>();
		Dog d1 = new Dog("Doberman");
		dogList.add(d1);
		Dog d2 = new Dog("German Shepherd");
		dogList.add(d2);
		request.setAttribute("DogList", dogList);
		request.setAttribute("DogList2", new ArrayList());
	%>
	
	<div style="color:#B45F04;">
		<developedTags:classiciterate listitems="${requestScope.DogList}" variable="currentDog">
			The current dog breed is: ${currentDog.breed}
			<br>
		</developedTags:classiciterate>
	</div>
	
	<div style="color:#B45F04;">
		<developedTags:classiciterate listitems="${requestScope.DogList2}" variable="currentDog">
				The current dog breed from second list is: ${currentDog.breed}
				<br>
		</developedTags:classiciterate>
	</div>
	
	<hr width="100%" style="border: 3px dotted #0099CC" color="#000000" size="4">
	
	<h3 style="color:red;">Using the create SELECT tag to create a combo-box from the employee collection</h3>
	
	<div style="color:yellow;">
		<developedTags:createSelect items="${requestScope.EmployeeList}" name="employeeSelect" multiple="false" style="color:#717D7D;"/>
	</div> 
	
	<hr width="100%" style="border: 3px dotted #0099CC" color="#000000" size="4">
	
	<h3 style="color:red;">Using the Menu tag to pass the menu items that could potentially be used to build menus</h3>
	
	<div style="color:cyan;">
		<developedTags:menu>
			<developedTags:menuitem itemValue="Monica"/>
			<developedTags:menuitem itemValue="Jerry"/>
			<developedTags:menuitem itemValue="Veronica"/>
			<developedTags:menuitem itemValue="Ashley"/>
		</developedTags:menu>
	</div> 
	
	<hr width="100%" style="border: 3px dotted #0099CC" color="#000000" size="4">
	
	<h3 style="color:red;">Checking whether with Tagdependent body-content scriptlets/expression are evaluated - scriptlets not evaluated while the expression
	are passed to the Tag as-is. It is for the tag to interpret the expression and change them; that's why the body-content is called <b>tagdependent</b></h3>

	<developedTags:printbody>
		Testing : <%=(3+2)%> :${requestScope.DogList[0].breed} : <% out.println("Anil Testing"); %>
	</developedTags:printbody>
	<hr width="100%" style="border: 3px dotted #0099CC" color="#000000" size="4">
	
	<h3 style="color:red;">About to throw an SkipPageException using a SIMPLE tag. This will render everything
	till the exception is thrown but will NOT print anything after the exception</h3>
	
	<developedTags:throwexception/>
	
	<h3 style="color:red;">This will NOT be printed!!</h3>
</html>