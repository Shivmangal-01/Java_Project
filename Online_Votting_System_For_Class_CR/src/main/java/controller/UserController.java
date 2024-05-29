package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import dao.UserDAO;
@WebServlet("/user")
public class UserController extends HttpServlet{
	public String msg=null;
	public void service(ServletRequest req,ServletResponse res)throws
	
	ServletException,IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		
		msg=new UserDAO().userVotting(req);
		
		
		 if (msg != null) {
	            req.setAttribute("message", msg);
	            RequestDispatcher rd = req.getRequestDispatcher("responsePage.jsp");
	            rd.forward(req, res);
	        } else {
	            req.setAttribute("message", msg);
	            RequestDispatcher rd = req.getRequestDispatcher("responsePage.jsp");
	            rd.forward(req, res);
	        }
		
		
		
		
		
		
//	   	if(msg!=null) {
//	   		    // System.out.println("Unique ID: " + uniqueID);
//	    	 
////	    	 pw.print(" <h1 style=\"color: red; font-size: large;\">"+msg+"</h1>\r"+ "");
////	    	   try {
////	               // Sleep for 5 seconds (5000 milliseconds)
////	               Thread.sleep(5000);
////	           } catch (InterruptedException e) {
////	               e.printStackTrace();
////	           }
//		    	RequestDispatcher rd=req.getRequestDispatcher("login.html");
//				rd.forward(req, res);
//	   	}
//	   	else {
//	   	   
//	    	 pw.print("<h1>"+msg+"</h1>");
////	    	 try {
////		            // Sleep for 5 seconds (5000 milliseconds)
////		            Thread.sleep(5000);
////		        } catch (InterruptedException e) {
////		            e.printStackTrace();
////		        }
//	    	 RequestDispatcher rd=req.getRequestDispatcher("login.html");
//				rd.forward(req, res);
//	   	}
		
		
	}//service
}
