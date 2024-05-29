package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
private static Connection con=null;
private DBConnection() {}
 static {
	 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 con = DriverManager.getConnection
		 ("jdbc:mysql://localhost:3306/onlinevotting","root","root@");
	 }catch(Exception e) {
		 e.printStackTrace();
	 }//end of catch
    }//static
 public static Connection getCon() {
	 return con;
	 }
}
