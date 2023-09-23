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

public class InsertMobileData extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		String Model = req.getParameter("model");
		int Price = Integer.parseInt(req.getParameter("price"));
		String Colour = req.getParameter("colour");
		String Brand = req.getParameter("brand");
		
		try {
			  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			  
			  Connection con = DriverManager.getConnection("jdbc:sqlserver://SOLUSOFT28PC\\SQLEXPRESS:1433;databaseName=SachinDB;user=sa;password=123@admin;"
							+ "encrypt=true;trustServerCertificate=true;");			  
	          PreparedStatement ps = con.prepareStatement("insert into dbo.MobileData values(?,?,?,?)");
	          
	          ps.setString(1,Model);
	          ps.setInt(2, Price);
	          ps.setString(3, Colour);
	          ps.setString(4, Brand);
	          	          
	          int i = ps.executeUpdate();  
	          if(i>0)  
	          pw.print("<font colour='green' size='4'>Record successfully registered...</font>");  
	          else
	          pw.print("<font colour='green' size='4'>Failed to registered...</font>");
	          
	    	  
	     } catch (ClassNotFoundException | SQLException e) {
			
				e.printStackTrace(); 
				}
	}
		
	}



