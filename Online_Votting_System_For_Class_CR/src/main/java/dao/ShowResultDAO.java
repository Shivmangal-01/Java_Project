package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beanclass.ShowResult;

public class ShowResultDAO {
   
	public List<ShowResult> show() {
        List<ShowResult> list = new ArrayList<>();

        try {
            Connection con = DBConnection.getCon();

            // Accessing DB Connection
            PreparedStatement ps = con.prepareStatement("select * from onlinevotting.uservotting");
            ResultSet rs = ps.executeQuery();
             
            PreparedStatement ps1=con.prepareStatement
            		("SELECT selectvote, COUNT(*) AS duplicateCount FROM onlinevotting.uservotting GROUP BY selectvote HAVING COUNT(*)");
            ResultSet rs1 = ps1.executeQuery();
            System.out.println("test");
            while(rs1.next()) {
            	System.out.println(""+rs1.getString(1));
            	System.out.println("sldf "+rs1.getInt(2));
            	ShowResult sr = new ShowResult();
              sr.setPName(rs1.getString(1));
              sr.setCount(rs1.getInt(2));
              // Replace "columnName" with the actual column name
              // Set other properties if needed

              list.add(sr);
           }//end of while

//        
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}