<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String s1=session.getAttribute("key1").toString();
String s2=session.getAttribute("key2").toString();
s1=null;s2=null;
session.invalidate();
//System.out.println();
//System.out.println(session.getAttribute("key2"));
response.sendRedirect("login.html");
%>
</body>
</html>