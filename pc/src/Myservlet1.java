

import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.cognizant.productBean.*;
import com.cognizant.productDao.ProductDao;
import com.oreilly.servlet.MultipartRequest; 
/**
 * Servlet implementation class Myservlet1
 */
@WebServlet("/Myservlet1")
public class Myservlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Myservlet1() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void disp()
    {   
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ServletContext context=getServletContext();
		String dirName=context.getRealPath("//");
		System.out.println(dirName);
		String parameter=null;
		File file1=null;
		long size=0;
		String filePath="";String name="",desc="",brand="",price="",category="";int instock=0;
		try{
			MultipartRequest multi=new MultipartRequest(request, dirName,10*1024*1024);
		    
			Enumeration files=multi.getFileNames();
			while(files.hasMoreElements())
			{
				parameter=(String)files.nextElement();
				System.out.println(parameter);
				if(parameter.equalsIgnoreCase("photo"))
				{
					
					filePath=multi.getFilesystemName(parameter);
					System.out.println(filePath);
					String final_filePath=dirName+"\\"+filePath;
					System.out.println(final_filePath);
					file1=new File(final_filePath);
					size=file1.length();
					FileInputStream finput=new FileInputStream(file1);
					FileOutputStream fout=new FileOutputStream(new File("D://UploadImageDemo"+filePath));
					System.out.println("ok");
					int j=0;
					while((j=finput.read())!=-1)
					{
			fout.write((byte)j);
					}
					finput.close();
					fout.close();
					
				}
		}
			Enumeration e=multi.getParameterNames();
			while(e.hasMoreElements())
			{
				parameter=(String)e.nextElement();
				if(parameter.equalsIgnoreCase("pname"))
				{
					name=multi.getParameter(parameter);
				}
				
				if(parameter.equalsIgnoreCase("cat"))
				{
					category=multi.getParameter(parameter);
				}
				if(parameter.equalsIgnoreCase("instock"))
				{
					instock=Integer.parseInt(multi.getParameter(parameter));
				}
				if(parameter.equalsIgnoreCase("desc"))
				{
					desc=multi.getParameter(parameter);
				}
				if(parameter.equalsIgnoreCase("brand"))
				{
					brand=multi.getParameter(parameter);
				}
				if(parameter.equalsIgnoreCase("price"))
				{
					price=multi.getParameter(parameter);
				}
			}
		}catch(Exception e)
		{System.out.print(e);}
/*			String file=request.getParameter("photo");
		
		System.out.print(file);
		=request.getParameter("pname");
		=Integer.parseInt(request.getParameter("pid"));
		String category=request.getParameter("cat");
		String desc=request.getParameter("desc");
		String brand=request.getParameter("brand");
		String price=request.getParameter("price");
		
	*/	Product p=new Product(category,name,desc,
			price,brand,filePath,instock);
		ProductDao pd=new ProductDao(p);
		if(pd.addProduct()) 
		{
			out.println("Succesfully added");
			response.sendRedirect("view.jsp");
		}
			
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


