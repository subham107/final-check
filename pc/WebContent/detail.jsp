<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.cognizant.productDao.*" %>
    <%@ page import="com.cognizant.productBean.*" %>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.image{
text-align: center;
}
.contain{
font-size:xx-large; 
display:block;
margin-bottom: 10%;
}
</style>
</head>
<body style="text-align:center;">
<%! Product p; %>
<% ProductDao pd=new ProductDao();
int id=Integer.parseInt(request.getParameter("val"));
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/INFINITY","root","root");
PreparedStatement ps=con.prepareStatement("select * from product where prod_id=?");
ps.setInt(1,id);
ResultSet rs=ps.executeQuery();
 p=new Product();
while(rs.next())
{   p.setFilePath(rs.getString("photo"));
	p.setName(rs.getString("name"));
	p.setDesc(rs.getString("description"));
	p.setCategory(rs.getString("category"));

out.println("<img src='"+p.getFilePath()+"' class='image'><br>");
out.println("<div class='contain'>");
out.println("<b>Name</b>="+p.getName()+"<br> "+"<b>Category</b>="+p.getCategory()+"<br> "+"<b>Description</b>="+p.getDesc()+"<br><b>Stock<b>="+p.getInstock());
out.println("</div>");
} %>
</body>
</html>