package com.cognizant.userDao;
import java.sql.*;
import java.util.List;
import java.io.*;
import java.util.*;

import com.cognizant.user.bean.*;
public class UserDao {
	User u=new User();
public UserDao(User u)
{ this.u=u;
}
public UserDao(){
	
}
public boolean adduser()
{try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/INFINITY","root","root");
	PreparedStatement ps=con.prepareStatement("insert into use2(name,username,mobile,mail,password,designation,address) values(?,?,?,?,?,?,?)");
	ps.setString(1,u.getName());
	ps.setString(2,u.getUsername());
	ps.setLong(3,u.getMobile());
	ps.setString(4,u.getMail());
	ps.setString(5, u.getPassword());
	ps.setString(6, u.getDesig());
	ps.setString(7, u.getAddress());
	int i=ps.executeUpdate();

	if(i>0)
		return true;
	}
catch(Exception e)
{
	System.out.println(e);
}
return false;
}
public List<User> getUser()
{  List<User> list=new ArrayList<User>();
	try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/INFINITY","root","root");
	PreparedStatement ps=con.prepareStatement("select * from use2");
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
	User u=new User();
	u.setName(rs.getString("name"));
	u.setUsername(rs.getString("username"));
	u.setMail(rs.getString("mail"));
	u.setMobile(rs.getLong("mobile"));
	u.setId(rs.getInt("id"));
	u.setPassword(rs.getString("password"));
	u.setDesig(rs.getString("designation"));
	u.setAddress(rs.getString("address"));
	list.add(u);
	}}
catch(Exception e)
{
	System.out.println(e);
}
	return list;
	
}
public boolean LockUser(String uname)
{try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/INFINITY","root","root");
	PreparedStatement ps=con.prepareStatement("Delete from use2 where username=?");
	ps.setString(1,uname);
	if(ps.executeUpdate()>0)
		return true ;
}
catch(Exception e)
{System.out.println(e);
}
return false;
}

}

