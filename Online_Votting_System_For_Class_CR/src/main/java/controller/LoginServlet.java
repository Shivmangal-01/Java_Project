package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import beanclass.Login;
import dao.LoginDAO;
@WebServlet("/login")
public class LoginServlet extends GenericServlet{

	public void service(ServletRequest req,ServletResponse res)throws

	ServletException,IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
	
		Login lg=new LoginDAO().loginChecking(req);
	    if(lg!=null) {
	    	if(lg.getUserName().equals("shiv") && lg.getPassWord().equals("shiv@123")) {
	    	 pw.print("<h1>Welcome to Online Votting</h1>");
	    	 RequestDispatcher rd=req.getRequestDispatcher("admin.html");
				rd.forward(req, res);
	    	}
	    	else {
	    		 pw.print("<h1>Welcome to Online Votting</h1>");
		    	 RequestDispatcher rd=req.getRequestDispatcher("user.html");
					rd.forward(req, res);
	    	}
	    }
	    else {
	    	pw.print("<h1>Wrong password Please try again</h1>");
	    	RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.forward(req, res);
	    	
	    }
	
		
		
		
	}//service
}
