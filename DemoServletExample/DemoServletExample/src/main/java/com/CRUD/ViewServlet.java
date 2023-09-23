package com.CRUD;

import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

@WebServlet("/ViewServlet")  

public class ViewServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
    	
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        out.println("<a href='Employee.html'>Add New Employee</a>");  
        out.println("<h1>Employees List</h1>");  
          
        List<Emp> list=EmpDao.getAllEmployees();  
          
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Id</th><th>Name</th><th>Address1</th><th>Address2</th><th>City</th><th>Edit</th><th>Delete</th></tr>");  
        for(Emp e:list){ 
//        	if("sachin"==e.getName() && "123"==e.getCity() ) {}
        out.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getAddress1()+   
        		 "</td><td>"+e.getAddress2()+"</td><td>"+e.getCity()+"</td><td><a href='EditServlet?id="+e.getId()+
        		 "'>edit</a></td>  <td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
          
        out.close();  
        
    }  
}  

