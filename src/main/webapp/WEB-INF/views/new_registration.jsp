<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file= "menu.jsp"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New</title>
</head>
<body>
<%
HttpSession v = request.getSession(false);
if(v.getAttribute("email")!=null){
%>
<h2>New Registration</h2>
	<form action="newReg" method = "Post">
	<pre>
	<b>
			Name <input type = "text" name = "name"/>
			City <input type = "text" name = "city"/>
			Email <input type = "text" name = "email"/>
			Mobile <input type = "text" name = "mobile"/>
			<input type = "submit" value = "save"/>
	</b>		
	</pre>
	</form>
	<%
		if(request.getAttribute("msg")!=null){
			out.println(request.getAttribute("msg"));
		}
	%>
	<%} else {
	RequestDispatcher rd = request.getRequestDispatcher("StudentLogin.jsp");
	rd.forward(request, response);
	}%>
</body>
</html>