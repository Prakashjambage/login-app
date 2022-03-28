<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String name  =(String) session.getAttribute("username");
if(name==null){
	response.sendRedirect("login.jsp");
}
%>
<h1>WELCOME TO PROFILE PAGE</h1>
<h2><a href="home.jsp">home</a></h2>
<h2><a href="logout">logout</a></h2>
</body>
</html>