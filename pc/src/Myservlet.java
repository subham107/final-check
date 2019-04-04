

import java.io.*;
import java.sql.*;
import java.sql.DriverManager;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.*;

import com.cognizant.user.bean.User;
import com.cognizant.userDao.UserDao;

/**
 * Servlet implementation class Myservlet
 */
@WebServlet("/Myservlet")
public class Myservlet extends HttpServlet {
	
	private 
	String name;
	int count;
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Myservlet() {
        // TODO Auto-generated constructor stub
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    public void createTable(String uname)
    {try{
    	Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/INFINITY","root","root");
        PreparedStatement ps=con.prepareStatement("Create table "+uname+"(prod_id int(11),req int(11))");
        int i=ps.executeUpdate();
        System.out.println(i);
        	
    }
    catch(Exception e)
    {
    	System.out.println(e);
    }
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String password=request.getParameter("password");
		System.out.println(uname+" "+password);
		List<User> list=new ArrayList<User>();
		UserDao ud=new UserDao();
		list=ud.getUser();int f=0;int k=0;
		for(User u:list)
		{
			if((u.getUsername().equals(uname)))
					{k=1;}
		}
		if (k==0)
			{out.println("username does not exist");
			out.println("<p>Click on <a href='login.html'>login</a> to go to login page</p>");
			}
		else
		{
			
		
		for(User u:list)
		{
			if((u.getUsername().equals(uname))&&(u.getPassword().equals(password)))
			{   
		   HttpSession session=request.getSession(true);
			session.setAttribute("key1", uname);
			session.setAttribute("key2", password);
			f=1;
			session.setMaxInactiveInterval(600);
			 if(u.getDesig().equals("user"))
		        {
				 request.getRequestDispatcher("frame3.jsp").forward(request, response);
		        }
			 else 
					request.getRequestDispatcher("frame2.html").forward(request, response);
		        }
			
		    	
			}
		
		if(f==0)
			{out.println("Invalid credentials");
			if(checkUser(uname)==3)
			{
				if(ud.LockUser(uname))
					out.println("User "+uname+"has beeen locked");
			}
			out.println("<p>Click on <a href='login.html'>login</a> to go to login page</p>");
			}
		}
		
	}// TODO Auto-generated method stub
	
	public int checkUser(String name)
	{
		if(!name.equals(this.name))
		{
			this.name=name;
			this.count=0;
		}
		else
		{
			this.count++;
		}
		return this.count;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("t1");
		long mobile=Long.parseLong(request.getParameter("t2"));
		String mail=request.getParameter("t3");String desig;
		if(request.getParameter("desig")==null)
		{desig="user";
		}
		else
			desig=request.getParameter("desig");
		String address=request.getParameter("add");
		System.out.println(desig);
		String username=request.getParameter("uname");
		
		String password=request.getParameter("pass");
		String rpassword=request.getParameter("rpass");
		if(!password.equals(rpassword))
		{response.sendRedirect("register.html");}
		User u=new User(name,username,mail,mobile,password,desig);
		u.setAddress(address);
		if(desig.equals("user"))
			 createTable(username);
		UserDao ud=new UserDao(u);
		if(ud.adduser())
		{out.println("<h1 style='text-align:center; margin-top:5%; font-size: xx-large;'>SUCCESS</h1>");
		 out.println("<p style='text-align:center; margin-top:10%;'>Back to <a href='login.html' target='_top'>login</a> page</p>");
		}
		else
			out.println("<h1>failed</h1>");
}
}
