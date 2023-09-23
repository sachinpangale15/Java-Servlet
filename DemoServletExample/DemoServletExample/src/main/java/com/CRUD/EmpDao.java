package com.CRUD;

import java.util.*;  
import java.sql.*; 

public class EmpDao {  
  
    public static Connection getConnection(){  
       Connection con=null;
       try {
    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    	   con=DriverManager.getConnection("jdbc:sqlserver://SOLUSOFT28PC\\\\SQLEXPRESS:1433;databaseName=SachinDB;user=sa;password=123@admin;"
    			   +"encrypt=true;trustServerCertificate=true;");
       }catch(Exception e) {
    	   
       }
    
	    return con;
       
    }  
    
    public static int save(Emp e){  
        int status=0;  
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into EmpDetails(name,address1,address2,city,id) values (?,?,?,?,?)");
            ps.setString(1,e.getName());  
            ps.setString(2,e.getAddress1());  
            ps.setString(3,e.getAddress2());  
            ps.setString(4,e.getCity());
            ps.setInt(5,e.getId());  

              
            status=ps.executeUpdate();                
            con.close();  
        }
        catch(Exception ex){
        	ex.printStackTrace();
        	}  
          
        return status;  
    }  
    public static int update(Emp e){  
        int status=0;  
        
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("update EmpDetails set name=?,address1=?,address2=?,city=? where id=?");  
            ps.setString(1,e.getName());  
            ps.setString(2,e.getAddress1());  
            ps.setString(3,e.getAddress2());  
            ps.setString(4,e.getCity());  
            ps.setInt(5,e.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();
            
        }
        catch(Exception ex){
        	ex.printStackTrace();
        	}  
          
        return status;  
    }  
    public static int delete(int id){  
        int status=0;
        
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from EmpDetails where id=?");  
            ps.setInt(1,id);  
            status=ps.executeUpdate();  
              
            con.close();  
        }
        catch(Exception e){
        	e.printStackTrace();
        	}  
          
        return status;  
    }  
    
    public static Emp getEmployeeById(int id){  
        Emp e=new Emp();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from EmpDetails where id=?");  
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setAddress1(rs.getString(3));  
                e.setAddress2(rs.getString(4));  
                e.setCity(rs.getString(5));  
            }  
            con.close();  
        }
        catch(Exception ex){
        	ex.printStackTrace();
        }  
          
        return e;  
    }  
    public static List<Emp> getAllEmployees(){  
        List<Emp> list=new ArrayList<Emp>();  
          
        try{  
            Connection con=EmpDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from EmpDetails");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Emp e=new Emp();  
                e.setId(rs.getInt(1));  
                e.setName(rs.getString(2));  
                e.setAddress1(rs.getString(3));  
                e.setAddress2(rs.getString(4));  
                e.setCity(rs.getString(5));  
                list.add(e);  
            }  
            con.close();  
        }
        catch(Exception e){
        	e.printStackTrace();
        }  
          
        return list;  
    }  
}  