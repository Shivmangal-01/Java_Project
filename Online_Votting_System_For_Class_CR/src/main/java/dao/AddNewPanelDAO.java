package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletRequest;

public class AddNewPanelDAO {
	
	   public int k=0;
	 // private static final int panelId=1;
        
	   public int addPanel(ServletRequest req) {
	try {
	Connection con = DBConnection.getCon();

	//Accessing DB Connection
//	PreparedStatement ps = con.prepareStatement
//			    ("INSERT INTO onlinevotting.new_panel values(?)");
	  // Integer id=Integer.parseInt(req.getParameter("gender"));
	PreparedStatement ps = con.prepareStatement
		    ("INSERT INTO onlinevotting.panel values(?,?,?,?,?)");
	
	System.out.println("yes");
	    String id=req.getParameter("gender");
	    		
	    ps.setString(1,req.getParameter("panelName"));
	    ps.setString(2, req.getParameter("panelSymbol"));
	    ps.setString(3, req.getParameter("canditeName"));
	    ps.setString(4, req.getParameter("education"));
	      if(id.equals("male")) {
	    	 ps.setString(5,"Male");
	      }
	      else {
	    	  ps.setString(5,"Female");
	      }
	      System.out.println("add");
	   
	    k=ps.executeUpdate();   
	    System.out.println("added");

	     
	       
	     
	  }catch(Exception e) {e.printStackTrace();}
	return k;
	}
}
