package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import dao.AddNewPanelDAO;
@WebServlet("/panel")
public class AddNewPanelController extends  HttpServlet {
	public void service(ServletRequest req,ServletResponse res)throws

	ServletException,IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		int k=new AddNewPanelDAO().addPanel(req);
		 if(k>0) {
	    	 pw.print("<h1>added New Panel successfully nbsb Thanks</h1>");

	   	}
	   	else {
	    	 pw.print("<h1>Sorry! Your panel already Exists</h1>");

	   	}
		
		
	}//service
}
