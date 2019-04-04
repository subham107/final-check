<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cognizant.userDao.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="com.cognizant.user.bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.image{

border-radius:50%;
height: 7cm;
width:5cm;
}
.design{

display: inherit;}

input[button]{
position: inherit;
margin-top: 5%;

}
.contain{
text-align:center;
font-family:Times New Roman;
font-size: x-large;
}
</style>
<title>Insert title here</title>
</head>
<body style="background-color: #D7EBFB; font-family: Arial Black; text-align: center;">
<h1 style="background-color: #0597C6; color: white; border-radius: inherit; font-family: Times New Roman; margin-top: 0.1%;">PROFILE</h1>
<div class="design" >
<img src="foxy.jpg" alt="logo" class="image">


<%
UserDao ud=new UserDao();
List<User> list=new ArrayList<User>();
list=ud.getUser();
out.println("<div class='contain'>");
for(User u:list)
{
	if((u.getUsername().equals(session.getAttribute("key1")))&&(u.getPassword().equals(session.getAttribute("key2"))))
	{out.println("<p>Name : "+u.getName()+"</p>");
	out.println("<p>Designation : "+u.getDesig()+"</p>");
	out.println("<p>Mobile : "+u.getMobile()+"</p>");
	out.println("<p>Mail : "+u.getMail()+"</p>");
	}
}
out.println("</div>");
%>
</div>
</body>
</html>