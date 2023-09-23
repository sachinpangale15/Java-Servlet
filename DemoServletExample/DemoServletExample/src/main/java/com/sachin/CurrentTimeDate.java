package com.sachin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CurrentTimeDate extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException, ServletException{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		
		java.util.Date date = new java.util.Date();
		pw.println("<h1>"+"Current Time & Date : "+date.toString()+"</h1>");
		pw.close();
		
	}
}