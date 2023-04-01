<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file= "menu.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
<%
HttpSession v = request.getSession(false);
if(v.getAttribute("email")!=null){
%>
<form action="Update" method = "Post">
			Email <input type = "text" name = "email" value= "<%=request.getAttribute("email") %>"/>
			Mobile <input type = "text" name = "mobile" value= "<%=request.getAttribute("mobile") %>"/>
			<input type = "submit" name = "Update">
</form>
<%} else {
	RequestDispatcher rd = request.getRequestDispatcher("StudentLogin.jsp");
	rd.forward(request, response);
	}%>
</body>
</html>