package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import beanclass.NewRegister;
import dao.TotalVoterIdDAO;
@WebServlet("/total")
public class TotalVoterIdServlet extends HttpServlet{
   
	public void service(ServletRequest req,ServletResponse res)throws

	ServletException,IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		List<NewRegister> list = new TotalVoterIdDAO().showDetails();
		
		Map<String, List<NewRegister>> map = new TreeMap<>();
		map.put("Total Election Detals ", list);
		// Obtain the entry set
		Set<Map.Entry<String, List<NewRegister>>> entrySet = map.entrySet();

		// Use an Iterator to iterate over the entries
		Iterator<Map.Entry<String, List<NewRegister>>> iterator = entrySet.iterator();
 
		while (iterator.hasNext()) {
		    Map.Entry<String, List<NewRegister>> entry = iterator.next();
		    String key = entry.getKey();
		    List<NewRegister> resultList = entry.getValue();

		    // Now you can access the key and value (list) from the entry
		    System.out.println("Key: " + key);
		   pw.print("<h1 style='color: green; background-color: yellow;'>" + key + "</h1>");
	        pw.print("<h1 style='color: green; background-color: yellow;'>firstName     lastName      gmail      password     agecId    voterId</h1>");

		   for (NewRegister result : resultList) {
		    //    System.out.println(result.getFirstName());
		        pw.print("<h1><p style='color: blue;'>" + result.getFirstName()+" "+result.getLastName()+" "+result.getGmail()+" "+result.getPassword()  
		        +"  " + result.getAge()+" "+result.getVoterId()+"</p></h1>");
		    }//end of loop
		    
		    
		}//while
		
	}//service
}
