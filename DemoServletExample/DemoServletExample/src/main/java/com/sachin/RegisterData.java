package com.sachin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import javax.servlet.*;

@WebServlet("/register")
public class RegisterData extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{

            response.setContentType("text/html");  
            PrintWriter pw = response.getWriter(); 
            
            String Fname = request.getParameter("fname");  
            String Lname = request.getParameter("lname");  
            String Emailid = request.getParameter("emailid");  
            String Address = request.getParameter("address");
                      
        try{  
        	
         	
           Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			  
		   Connection con = DriverManager.getConnection("jdbc:sqlserver://SOLUSOFT28PC\\SQLEXPRESS:1433;databaseName=SachinDB;user=sa;password=123@admin;"
							+ "encrypt=true;trustServerCertificate=true;");
	       PreparedStatement ps = con.prepareStatement("insert into RegisterData values(?,?,?,?)");  
    

	       ps.setString(1,Fname);  
	       ps.setString(2,Lname);
	       ps.setString(3,Emailid);
	       ps.setString(4,Address);


          int i = ps.executeUpdate();         
          if(i>0){          
            pw.println("Record has been inserted");  
          }  
          else{        
            pw.println("failed to insert the data");
           }  
            ps.close();
        }  
        catch (Exception e){  
        }  

}

}