<%@page import="com.bean.Vehicle" %>
<%@page import="com.dao.DatabaseHandler" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Automobile Management System</title>
</head>
<body>
<%
	List<Vehicle> list=DatabaseHandler.getVehicles();
%>
<table border="1" width="100%" cellpadding=5 cellspacing=5>
	<tr style="background-color:silver">
		<th>Vehicle ID</th>
		<th>Year</th>
		<th>Vehicle Brand</th>
		<th>Model</th>
		<th>Update</th>
		<th>Delete</th>
	</tr>
<%
	for(Vehicle s:list) {
%>
<tr>
		<td><%=s.getId() %></td>
		<td><%=s.getYear() %></td>
		<td><%=s.getMake() %></td>
		<td><%=s.getModel() %></td>
	<td>
		<form action="ActionController" method="post">
			<input type="hidden" name="id" value="<%=s.getId()%>">
			<input type="submit" name="action" value="edit">
		</form>
	</td>
	<td>
		<form action="ActionController" method="post">
			<input type="hidden" name="id" value="<%=s.getId()%>">
			<input type="submit" name="action" value="delete">
		</form>
	</td>
</tr>
<% } 
%>
</table>
<br><a href="index.jsp">Insert again</a>
</body>
</html>