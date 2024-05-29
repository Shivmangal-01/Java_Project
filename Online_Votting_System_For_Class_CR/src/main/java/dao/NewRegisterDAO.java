package dao;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletRequest;

import beanclass.Login;

public class NewRegisterDAO {
     
	// public int k=0;
	  public String uId=null;
        
	   public String newRegister(ServletRequest req) {
	try {
	Connection con = DBConnection.getCon();


	PreparedStatement ps = con.prepareStatement
		    ("INSERT INTO onlinevotting.new_register values(?,?,?,?,?,?,?)");
	//adding to this information into user details only name and password
	PreparedStatement ps1 = con.prepareStatement
	("INSERT INTO onlinevotting.login VALUES(?,?)");
       		   		
	    ps.setString(1,req.getParameter("firstName"));
	    ps.setString(2, req.getParameter("lastName"));
	    ps.setString(3, req.getParameter("emailId"));
	    ps.setString(4, req.getParameter("password"));
	    ps.setInt(5, Integer.parseInt(req.getParameter("age")));
	    ps.setInt(6, Integer.parseInt(req.getParameter("cId")));
	    //genrated each user unique id
		SecureRandom secureRandom = new SecureRandom();
         uId = new BigInteger(6, secureRandom).toString(5);
        ps.setString(7, uId);
	    int k=ps.executeUpdate(); 
	    if(k>0) {
		    ps1.setString(1,req.getParameter("firstName"));
		    ps1.setString(2, req.getParameter("password"));
		    int p=ps1.executeUpdate();
		    if(p>0) {
	    return uId;
		    }
	   
	    }
	  
	    System.out.println("added");

	     
	       
	     
	  }catch(Exception e) {e.printStackTrace();}
	return null;
	}
}	   
	   
