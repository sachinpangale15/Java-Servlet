package RegisterAndLogin;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class LoginServlet extends HttpServlet {
  public void doPost(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
	  
	  res.setContentType("text/html");
	  PrintWriter out = res.getWriter();
	  
      String Email = req.getParameter("Email");
      String Password = req.getParameter("Password");
    
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		  
	  Connection con = DriverManager.getConnection("jdbc:sqlserver://SOLUSOFT28PC\\SQLEXPRESS:1433;databaseName=SachinDB;user=sa;password=123@admin;"
						+ "encrypt=true;trustServerCertificate=true;");

      PreparedStatement ps = con.prepareStatement("SELECT * FROM RegisterData WHERE Email =? AND Password=?");
      ps.setString(1, Email);
      ps.setString(2, Password);
      
   
     
      
      ResultSet rs = ps.executeQuery();
     

      // If the login is successful, redirect the user to a welcome page
        if (rs.next()) {
        HttpSession session = req.getSession();
        session.setAttribute("Email", Email);
        
        out.println("You are successfully login..."); 
       
//        RequestDispatcher rd = req.getRequestDispatcher("SuccessfullyLogin Serv.html");
//        rd.include(req, res);
//        res.sendRedirect("SuccessfullyLogin Serv.html");
     
       
      }
         else {
        RequestDispatcher rd = req.getRequestDispatcher("Welcome Serv.html");
        rd.include(req, res);
        out.println("<p style='color:red'>Invalid Credential.</p>");
      }
    } catch (ClassNotFoundException | SQLException e ) {
      e.printStackTrace();
    }
  }
}

   
  
