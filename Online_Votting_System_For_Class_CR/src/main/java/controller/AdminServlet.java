package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/admin")
public class AdminServlet extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res)
			throws ServletException,IOException{
				 
			PrintWriter pw=res.getWriter();
			res.setContentType("text.html");
			String c1=req.getParameter("v1");
			if(c1.equals("Add New Panel"))
			{ 
				
				RequestDispatcher rd=req.getRequestDispatcher("panel.html");
				rd.forward(req, res);
			}
			else if(c1.equals("View Result")) {
			   
			    RequestDispatcher rd1=req.getRequestDispatcher("/show");
			   rd1.forward(req, res);
			}
			else if(c1.equals("Total VoterId"))
			{
			 RequestDispatcher rd2=req.getRequestDispatcher("/total");
			 rd2.forward(req, res);
			}
			else if(c1.equals("Logout"))
			{
				 RequestDispatcher rd2=req.getRequestDispatcher("login.html");
				 rd2.forward(req, res);	
			}
//			
			else {
				pw.print("<h1>Something went wrong! please Try again</h1>");
			}
				
			
			}//end of service
}
