<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP Counter Testing</title>
</head>
<body>

<table>
	<%
	Connection con=null;
	ResultSet rs=null;
	Statement st=null;
	String tid=null;
	try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
	}catch(ClassNotFoundException ce){
			out.println(ce);
	}
    try{
        con = DriverManager.getConnection("jdbc:mysql://localhost/dbo","root", "password");
        st = con.createStatement();

        rs=st.executeQuery("SELECT * FROM billing_details b;");
		
        while (rs.next()) {
             tid=rs.getString(1);
            %>
            <tr onmouseover="javascript:this.style.background='#FFFFFF';" onmouseout="javascript:this.style.background='#CCCCCC';"  bgcolor="#CCCCCC">

                <td align="center" class="style10"><label name="tt">
                  <a href="ticketdetails.jsp"  target="_blank" >
                    <%=tid%></a></label>
				</td>
            </tr>
            <%}
        }
            catch(Exception e){}
           
         %>
                      </table>
        
</body>
</html>