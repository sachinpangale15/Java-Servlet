package com.sachin;



import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class Register extends HttpServlet
{  
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
     {  
          response.setContentType("text/html");
          PrintWriter out = response.getWriter();  
          
          int Id = Integer.parseInt(request.getParameter("userId"));
          String Name = request.getParameter("userName");  
          String Password = request.getParameter("userPass");  
          String Email = request.getParameter("userEmail");
          String Mobile = request.getParameter("userMobile");

         
		  try {
			  
		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		  
		  Connection c1 = DriverManager.getConnection("jdbc:sqlserver://SOLUSOFT28PC\\SQLEXPRESS:1433;databaseName=SachinDB;user=sa;password=123@admin;"
						+ "encrypt=true;trustServerCertificate=true;");
		  
          PreparedStatement ps = c1.prepareStatement("insert into dbo.Register values(?,?,?,?,?)"); 
          
          ps.setInt(1,Id);  
          ps.setString(2,Name);  
          ps.setString(3,Password);  
          ps.setString(4, Email);
          ps.setString(5,Mobile);  

          int i = ps.executeUpdate();  
          if(i>0)  
          out.print("You are successfully registered..."); 
          
       
          
          
//          c1.prepareStatement("Select a_email,a_pwd from author where a_email=? and a_pwd= ? ");
//          ps.setString(3, Name);
//          ps.setString(4, Password);
//          ResultSet rs = ps.executeQuery();


		  
     } catch (ClassNotFoundException | SQLException e) {	
			e.printStackTrace(); 
			}
}
	
}





