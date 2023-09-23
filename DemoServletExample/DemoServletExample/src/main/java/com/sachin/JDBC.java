package com.sachin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class JDBC {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		
	
		  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				
		  Connection c1 = DriverManager.getConnection("jdbc:sqlserver://SOLUSOFT28PC\\SQLEXPRESS:1433;databaseName=master;user=sa;password=123@admin;"
						+ "encrypt=true;trustServerCertificate=true;");
		
                      // URL Formate :- jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
		  
		  
		
				}  
 
	}
	
     

