package com.CRUD;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
@WebServlet("/SaveServlet")  

public class SaveServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException { 
    	
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        int id = Integer.parseInt(request.getParameter("id"));  
        String name=request.getParameter("name");  
        String address1=request.getParameter("address1");  
        String address2=request.getParameter("address2");  
        String city=request.getParameter("city");  
          
        Emp e=new Emp();
        
        e.setId(id);
        e.setName(name);  
        e.setAddress1(address1);  
        e.setAddress2(address2);  
        e.setCity(city);  
          
        int status=EmpDao.save(e);  
        if(status>0){  
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("Employee.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
        out.close();  
    }  
  
}  