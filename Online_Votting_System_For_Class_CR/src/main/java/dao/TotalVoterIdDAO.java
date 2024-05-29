package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beanclass.NewRegister;

public class TotalVoterIdDAO {
	  public List<NewRegister> list=null;
	  public List<NewRegister> showDetails() {
		    List<NewRegister> list = new ArrayList<>();
           System.out.println("sdfjl;ksjdf");
		    try {
		        Connection con = DBConnection.getCon();
		        PreparedStatement ps = con.prepareStatement
		        		("select * from onlinevotting.new_register");
		        ResultSet rs = ps.executeQuery();
		        System.out.println("test");
		       // NewRegister 
		        while (rs.next()) {
		        	 System.out.println(rs.getString(1));
		        	 NewRegister nr = new NewRegister();
		            nr.setFirstName(rs.getString(1));
		            nr.setLastName(rs.getString(2));
		            nr.setGmail(rs.getString(3));
		            nr.setPassword(rs.getString(4));
		            nr.setAge(rs.getInt(5));
		            nr.setcId(rs.getInt(6));
		            nr.setVoterId(rs.getString(7));

		            list.add(nr);
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

		    return list;
		}
}
