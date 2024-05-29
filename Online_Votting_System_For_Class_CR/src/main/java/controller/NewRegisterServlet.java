package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import dao.NewRegisterDAO;

@WebServlet("/newRegister")
public class NewRegisterServlet extends HttpServlet{
	
	public void service(ServletRequest req,ServletResponse res)throws

	ServletException,IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		int age=Integer.parseInt(req.getParameter("age"));

		if (age < 18 || age >= 100 ) {
			
            pw.print("<h1>Invalid age. Age must be between 18 and 99.</h1>");
           return ;
          }
		String uId=new NewRegisterDAO().newRegister(req);
	   	if(uId!=null) {
	   		    // System.out.println("Unique ID: " + uniqueID);
	    	 pw.print("<h1>New Register Successfully</h1>");
	    	 pw.print(" <h1 style=\"color: red; font-size: large;\">Remember your ID: = "+uId+" </h1>\r\n"+ "");

	   	}
	   	else {
	    	 pw.print("<h1>You are Already Registered</h1>");

	   	}
		
		
	}//service
}
