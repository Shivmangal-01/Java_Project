package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import beanclass.ShowResult;
import dao.ShowResultDAO;

@WebServlet("/show")
public class ShowResultController extends HttpServlet {

	public void service(ServletRequest req,ServletResponse res)throws

	ServletException,IOException{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		List<ShowResult> list = new ShowResultDAO().show();
		Map<String, List<ShowResult>> map = new HashMap<>();
		map.put("Result OF this Election", list);

		// Obtain the entry set
		Set<Map.Entry<String, List<ShowResult>>> entrySet = map.entrySet();

		// Use an Iterator to iterate over the entries
		Iterator<Map.Entry<String, List<ShowResult>>> iterator = entrySet.iterator();
 
		while (iterator.hasNext()) {
		    Map.Entry<String, List<ShowResult>> entry = iterator.next();
		    String key = entry.getKey();
		    List<ShowResult> resultList = entry.getValue();

		    // Now you can access the key and value (list) from the entry
		    System.out.println("Key: " + key);
		   pw.print("<h1 style='color: green; background-color: yellow;'>" + key + "</h1>");
		    for (ShowResult result : resultList) {
		        System.out.println("PName: " + result.getPName());
		        pw.print("<h1><p style='color: blue;'>" + result.getPName() + " = " + result.getCount() + "</p></h1>");
		    }//end of loop
		    
		    
		}//while
		
		
	}//service
}
