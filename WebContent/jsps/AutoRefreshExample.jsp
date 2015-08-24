<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>JSP Counter Testing</title>
		<script language="javascript">
			var t;
			var timer_is_on=0;
			var c=0;
			
			function timedRefresh(){
				//window.location.reload();
				document.getElementById('txt').value=c;
				c=c+1;
			    t=setTimeout("timedRefresh()",1000);
			}
			
			function doTimer(){
				if (!timer_is_on){
					  timer_is_on=1;
					  timedRefresh();
				}
			}
			
			function stopRefresh()
			{
				clearTimeout(t);
				timer_is_on=0;
			}
			
			function autoRefreshOn(){
				document.getElementById('refresh').value="true";
			  	//Send request to a servlet that would send set the session attribute to false but send the user to same JSP
			 	document.sampleform.submit();
			}
			
			function stopAutoRefresh(){
				document.getElementById('refresh').value="false";
				//Send request to a servlet that would send set the session attribute to false but send the user to same JSP
				document.sampleform.submit();
			}
		
		</script>
		<style type="text/css">
			body{
				line-height: 1.5em;
				font-family: Arial, Helvetica, "Helvetica Neue", Geneva, sans-serif;
				margin: 0;
				padding: 10px;
			}
			table, th, td {
					border: 1px solid black;
					line-height: 1.5em;
					font-family: Arial, Helvetica, "Helvetica Neue", Geneva, sans-serif;
					margin: 0;
					padding: 5px;
			}
			th	{
					background-color:green;
					color:white;
			}
			.padded {
					padding: 15x;
			}
		
</style>
	</head>
<body>
	<%! int count=0;%>
	             
	<form action="simpleServlet" name="sampleform">
		<p>
			<h2>
				The following example shows the timer events using JavaScript and way to auto-refresh the 
				page programatically
			</h2>
		</p>
		<br><br>
		<table border="1" width="500">
			<tr>
				<td colspan="3">
					<p>
						Use the following example to use the JavaScript times. Clicking on the "Java Script Refresh On"
						button will start the JavaScript timer which will increment the value in the text box below every
						second.
					</p>
				</td>
			</tr>
			<tr>
				<td width="30%">
					<input type="button" value="Java Script Refresh On" onClick="doTimer()"/>
				</td>
				<td width="40%">
					<input type="text" id="txt" name="txt">
				</td>
				<input type="hidden" id="refresh" name="refresh">
				<td width="30%">
					<input type="button" value="Java Script Refresh Off" onClick="stopRefresh()"/>
				</td>
			</tr>
			
			<tr>
				<td colspan="3">
					<p>
						Use the following example to check the page autorefresh example. The page is initially
						set to auto-refresh automatically every 10 seconds. You can use the "Page Refresh Off"
						button to stop the auto-refresh of the page and "Page Refresh On" button to start the 
						auto refresh again.
					</p>
				</td>
			</tr>
			<tr>
				<td width="30%" align="center">
					<input type="button" value="Page Refresh On" onClick="autoRefreshOn()"/>
				</td>
				<td width="40%" align="center">
					<label name="place">PlaceHolder</label>
				</td>
				<td width="30%" align="center">
					<input type="button" value="Page Refresh Off" onClick="stopAutoRefresh()"/>
				</td>
			</td>
		</table>
		<br><br>
		<h2>
			<%="Count is:" + count++ +":" + session.getAttribute("refresh")%>
		</h2>
		<% if (!("false".equalsIgnoreCase((String)session.getAttribute("refresh")))){
					session.setAttribute("refresh","true");
					response.setHeader("Refresh", "10");
	}%>
	</form>
</body>
</html>