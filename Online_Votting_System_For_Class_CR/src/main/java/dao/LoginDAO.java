package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import beanclass.Login;

public class LoginDAO {
	private Login vt=null;
   //public int k=0;
   public Login loginChecking(ServletRequest req) {
try {
Connection con = DBConnection.getCon();

//Accessing DB Connection
PreparedStatement ps = con.prepareStatement("select * from onlinevotting.login where user_name=? and password=?");
//  PreparedStatement ps = con.prepareStatement
//    ("UPDATE onlinevotting.login SET user_name =?, password =? WHERE where user_name=? and password=?");
    ps.setString(1,req.getParameter("userName"));
    ps.setString(2,req.getParameter("password"));
    ResultSet st=ps.executeQuery();   
  //int k=ps.executeUpdate();
      if(st.next()) {
       vt=new Login();
       vt.setUserName(st.getString(1));
       vt.setPassWord(st.getString(2));
       
    } 
  }catch(Exception e) {e.printStackTrace();}
return vt;
 }
}
