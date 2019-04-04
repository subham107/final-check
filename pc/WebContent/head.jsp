<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cognizant.userDao.*" %>
    <%@ page import="java.util.*" %>
    <%@ page import="com.cognizant.user.bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function noback() {
	window.history.forward();
}
setTimeout("noback()", 10);
</script>
<style>
body{
background-color: #0597C6;}
.top{
text-align:center;
font-size: xx-large;
text-decoration: blink;
 }
.image{
width: 3.3cm;
border-radius:30%;
position: absolute; 
top: 5%;
left: 2%;
bottom: 10%;
height: 3.9cm;
}
.title{
font-family: "Castellar";
font-size: medium;
}
.contain{
color:white;
position :absolute;
right:0%;
top: 10%;
}
</style>
</head>
<body>
<div class="top">
<img src="wolf.png" alt="logo" class="image">
<h1 style="color:white; margin-bottom: 5%;  text-align: center;">GRIZZLY</h1>
<%
UserDao ud=new UserDao();
List<User> list=new ArrayList<User>();
list=ud.getUser();
out.println("<div class='contain'>");
for(User u:list)
{
	if((u.getUsername().equals(session.getAttribute("key1")))&&(u.getPassword().equals(session.getAttribute("key2"))))
	{out.println("Welcome : "+u.getName()+"<br>");
	}
}
%>
<a href='logout.jsp' target='_top'><button type='button' style='width: 25%; margin-top: 15%;' onclick="noback()">Logout</button></a>

</div>

<div class="title">

</div>
</body>
</html>