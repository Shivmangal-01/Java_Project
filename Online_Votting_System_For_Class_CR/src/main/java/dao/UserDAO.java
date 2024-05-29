package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletRequest;

import beanclass.Login;
import beanclass.User;

public class UserDAO {
    public String vt = null;
	public String userVotting(ServletRequest req) {
        

        try {
            Connection con = DBConnection.getCon();
        
            PreparedStatement ps = con.prepareStatement
            		("SELECT * FROM onlinevotting.new_Register WHERE voterId=?");
            PreparedStatement ps1 = con.prepareStatement
            		("SELECT * FROM onlinevotting.panel WHERE panelName=?");
              
            PreparedStatement ps3 = con.prepareStatement
            		("Insert Into onlinevotting.uservotting values(?,?,?)");
              
            System.out.println("step 2");
            String pName=req.getParameter("vote");
            System.out.println(pName);
            String vId = req.getParameter("vId");
            System.out.println(vId);

            // Set the voterId parameter in the PreparedStatement
            ps.setString(1, vId);
              ps1.setString(1, pName);
              ResultSet rs = ps.executeQuery();
            ResultSet rs1 = ps1.executeQuery();
          
            System.out.println("Step2");
          if(rs.next()&&rs1.next()) {
        	  System.out.println("step3");
        	 ps3.setString(1, pName);
        	 ps3.setString(2, vId);
        	 ps3.setInt(3, 1);
        	 int k=ps3.executeUpdate();
        	 if(k>0) {
        		 
        		return vt="<h1>Congratulation Your Vote Successfully for "+pName+"</h1>";
        	 }
        	 return vt="<h1>Sorry We Connot Find your Id Please Check Once Again</h1>";
          }
            

        } catch (Exception e) {
           vt="<h1>Sorry! you Have Already voted</h1>";
        	e.printStackTrace();
            
        }

        return vt="<h1>Sorry We Connot Find your Id Please Check Once Again</h1>";
    }
}
