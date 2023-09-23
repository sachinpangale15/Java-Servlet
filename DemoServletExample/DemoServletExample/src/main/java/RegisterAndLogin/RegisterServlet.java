package RegisterAndLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		int Id = Integer.parseInt(req.getParameter("Id"));
		String FirstName = req.getParameter("FirstName");
		String LastName = req.getParameter("LastName");
		String Email  = req.getParameter("Email");
		String Password = req.getParameter("Password");
		String Mobile = req.getParameter("Mobile");

		
		 try {
		    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				  
				Connection con = DriverManager.getConnection("jdbc:sqlserver://SOLUSOFT28PC\\SQLEXPRESS:1433;databaseName=SachinDB;user=sa;password=123@admin;"
								+ "encrypt=true;trustServerCertificate=true;");
				
				PreparedStatement ps = con.prepareStatement("INSERT INTO RegisterData VALUES (?,?,?,?,?,?)");
				
			      ps.setInt(1, Id);
			      ps.setString(2, FirstName);
			      ps.setString(3, LastName);
			      ps.setString(4, Email);
			      ps.setString(5, Password);
			      ps.setString(6, Mobile);
			    
			      int result = ps.executeUpdate();

			    
			      if (result > 0) {   	 
			    	out.print("You are successfully registered..."); 
			    	out.print("<br><a href=\"Login Serv.html\">log in</a> </br> " );
			    	
			      }
			      
			      else {
			       RequestDispatcher rd = req.getRequestDispatcher("Register Serv.html");
			        rd.include(req, res);       
			        out.println("<p style='color:red'>Registration failed. Please try again.</p>");
			      }
			      
			    } catch (Exception e) {
			      e.printStackTrace();
			    }
			  }
			}
