<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.cognizant.productDao.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ProductDao pd=new ProductDao();
int id=Integer.parseInt(request.getParameter("val1"));
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/INFINITY","root","root");
PreparedStatement ps=con.prepareStatement("Delete from product where prod_id=?");
ps.setInt(1,id);
ps.executeUpdate();
out.println("Success");
response.sendRedirect("view.jsp");
%>
</body>
</html>