package com.sachin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException{
		int result = 0;
		try {
		String number1 = request.getParameter("num1");
		String number2 = request.getParameter("num2");
		String operator = request.getParameter("op");
		int x = Integer.parseInt(number1);
		int y = Integer.parseInt(number2);
		if(operator == "+") {
		result = x + y;
		}
		else if(operator == "-") {
		result = x - y;
		}
		else if(operator == "*") {
		result = x * y;
		}
		else if(operator == "/") {
		result = x/y;
		}
		PrintWriter p = response.getWriter();
		p.print(result);
		
        p.println("<br><br><a href= 'Calculator.html'>Home</a>"+result);
		}
		catch(Exception e) {}
		}
		}

