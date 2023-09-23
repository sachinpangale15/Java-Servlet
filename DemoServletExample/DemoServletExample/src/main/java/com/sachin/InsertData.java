package com.sachin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertData extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
				
		int Id = Integer.parseInt(req.getParameter("userId"));
		String Name = req.getParameter("userName");
		String Address = req.getParameter("userAddress");
		String City = req.getParameter("userCity");
		String Mobile = req.getParameter("userMobile");		
					
		try {
			
			  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");			  
			  Connection con = DriverManager.getConnection("jdbc:sqlserver://SOLUSOFT28PC\\SQLEXPRESS:1433;databaseName=SachinDB;user=sa;password=123@admin;"
							+ "encrypt=true;trustServerCertificate=true;");
			  PreparedStatement ps = con.prepareStatement("insert into dbo.DataInsert values(?,?,?,?,?)");
			
			  ps.setInt(1,Id);  
	          ps.setString(2,Name);  
	          ps.setString(3,Address);  
	          ps.setString(4, City);
	          ps.setString(5,Mobile);
	          
	          int i = ps.executeUpdate();
	          if(i>0)
	          pw.println("Updated successfully...");           // PW PrintWriter object 
			
	     } catch (ClassNotFoundException | SQLException e) {		
	   }
	  }
	}
