<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.cognizant.user.bean.*" %>
    <%@page import="com.cognizant.userDao.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String str=request.getParameter("val");
UserDao ud=new UserDao();
List<User> l=new ArrayList<User>();
l=ud.getUser();int f=0;
for(User u:l)
{   
	if(u.getUsername().equals(str))
	{
	 out.print("<img src='cross.png' alt='wrong' width='40' height='40' align='middle'>USERNAME EXISTS");
	 f=1;
	}
	
}
if(f==0)
	out.print("<img src='tick.png' alt='wrong' width='42' height='42' align='middle'>USERNAME VALID");

%>
</body> 
</html>