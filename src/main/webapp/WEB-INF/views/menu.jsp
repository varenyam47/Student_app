<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<%
HttpSession s = request.getSession(false);
if(s.getAttribute("email")!=null){
%>
<a href ="newReg" >New Registration</a>
<a href ="listall" >All Registration</a>
<form action="Logout" method="Post">
<input type = "submit" value = "Logout"/>
</form>
<%} else {
	RequestDispatcher rd = request.getRequestDispatcher("StudentLogin.jsp");
	rd.forward(request, response);
	}%>
</body>
</html>