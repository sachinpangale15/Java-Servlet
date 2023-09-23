package com.CRUD;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

@WebServlet("/EditServlet")  
public class EditServlet extends HttpServlet {  
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
    	
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
        
        out.println("<h1>Update Employee</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
          
        Emp e=EmpDao.getEmployeeById(id);  
          
        out.print("<form action='EditServlet2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
        out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
        out.print("<tr><td>Address1:</td><td><input type='text' name='address1' value='"+e.getAddress1()+"'/></td></tr>");
        out.print("<tr><td>Address2:</td><td><input type='text' name='address2' value='"+e.getAddress2()+"'/></td></tr>");
        out.print("<tr><td>City:</td><td><input type='text' name='city' value='"+e.getCity()+"'/></td></tr>");  
         
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
        out.print("<a href=\"EditServlet2\"> edit employees</a> ");
        
        out.close();  
    }  
}  
