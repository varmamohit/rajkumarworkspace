<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border=2>
<tr>
<td>Username</td>
<td>Branch</td>
<td>address</td>
</tr>

<%

    Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
PreparedStatement pst = conn.prepareStatement("select username,branch,address from voot where address=' '");
   ResultSet rs = pst.executeQuery();
   while(rs.next())
   {
	  
	   %>
	   <tr>
	  <td> <%=rs.getString("username") %></td>
	   <td><%=rs.getString("branch") %></td>
        <td><%=rs.getString("address") %></td>
        </tr> 	   
	   
<% 	   
	   
   }

%>


















</table>
</body>
</html>