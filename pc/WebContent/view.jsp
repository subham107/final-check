<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cognizant.productBean.*" %>
    <%@ page import="com.cognizant.productDao.*" %>
    <%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
  border: 1px solid black;
  text-align: center;
}
table{
width: 90%;

border-color: gray;
}
table th{
background-color: #0597C6;
color:white;
border-color: gray;
}
table td{
border-color: gray;
}
button{
color:white;
background-color:#0597C6;
cursor:pointer; }
button:hover{
opacity:0.6;
}
</style>
</head>
<body>
<%
ProductDao pd1=new ProductDao();
List<Product> list=new ArrayList<Product>();
list=pd1.getProduct();
for(Product p1:list)
{
	System.out.println(p1.getName());
}
out.println("<table >");
out.println("<tr><th>Product Name</th><th>Brand</th><th>Category</th><th>Description</th><th>Product ID</th><th>Price</th><th>Stock</th></tr>");
for(Product p1:list)
{
	out.println("<tr><td>"+p1.getName()+"</td><td>"+p1.getBrand()+"</td><td>"+p1.getCategory()+"</td><td>"+p1.getDesc()+"</td><td>"+p1.getProd_id()+"</td><td>"+p1.getPrice()+"</td><td>"+p1.getInstock()+"</td><td><a href='detail.jsp?val="+p1.getProd_id()+"'><button style='width: 3cm; height: 1cm; border-radius: 30pt;'><p style='font-family:Arial Black; s'>VIEW</p></button></a></td><td><a href='delete.jsp?val1="+p1.getProd_id()+"'><button style='width: 3cm; height: 1cm; border-radius: 30pt;'><p style='font-family:Arial Black;  '>DELETE</p></button></a></td></tr>");
}
	out.println("</table>");



%>
</body>
</html>