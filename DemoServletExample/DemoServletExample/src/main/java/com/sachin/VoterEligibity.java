package com.sachin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterEligibity extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		
         res.setContentType("text/html");
         PrintWriter out = res.getWriter();
         
         String name = req.getParameter("name");
         int age = Integer.parseInt(req.getParameter("age"));
         
         if (age>=18) {
             out.println("<font color='green' size='4'>"+name+" you are eligible to vote</font>");
         }else {
             out.println("<font color='red' size='4'>"+name+" you are not eligible to vote</font>");
         }
         out.println("<br><br><a href= 'VoterEligible.html'>Home</a>");
         
         out.close();

         
		
	}

}
