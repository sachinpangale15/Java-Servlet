package com.sachin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeDetails extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		int Id = Integer.parseInt(req.getParameter("Id"));
		String Name = req.getParameter("Name");
		String Address = req.getParameter("Address");
		String State = req.getParameter("State");
		String MobileNo = req.getParameter("MobileNo");
		
		try {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			  
			   Connection con = DriverManager.getConnection("jdbc:sqlserver://SOLUSOFT28PC\\SQLEXPRESS:1433;databaseName=SachinDB;user=sa;password=123@admin;"
								+ "encrypt=true;trustServerCertificate=true;");
		       PreparedStatement ps = con.prepareStatement("insert into EmployeeDetails values(?,?,?,?,?)");
		       
		       ps.setInt(1, Id);
		       ps.setString(2, Name);
		       ps.setString(3, Address);
		       ps.setString(4, MobileNo);
		       ps.setString(5, State);
		       
		       int i = ps.executeUpdate();
		       if(i>0)
		    	   pw.print("Successfully inserted data....");
		       else
		    	   pw.print("No data inserted");
		       
		       con.close();
	       
		
		} catch(Exception e){
			
		}
				
	}

}
