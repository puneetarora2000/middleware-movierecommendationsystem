package mrs;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBList;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;


public class Register extends  HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			String userId = request.getParameter("userId");
			String email = request.getParameter("email");
			String passwd = request.getParameter("passwd");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String gender = request.getParameter("gender");
			String age = request.getParameter("age");
			String lang = request.getParameter("lang");
			String loc = request.getParameter("loc");
			
			Mongo m = new Mongo("ec2-54-243-59-26.compute-1.amazonaws.com",27017);
			m.setWriteConcern(WriteConcern.SAFE);
			DB db = m.getDB("UserProfile");
			DBCollection coll = db.getCollection("testCollection");
			
			BasicDBObject doc = new BasicDBObject();
	        doc.put("userId", userId);
	        doc.put("email", email);
	        doc.put("passwd", passwd);
	        doc.put("firstName", firstName);
	        doc.put("lastName", lastName);
	        doc.put("gender", gender);
	        doc.put("age", age);
	        doc.put("lang", lang);
	        doc.put("loc", loc);

	        //favMovies is used to store the users top list of movies
	        BasicDBList favMovies = new BasicDBList();
	        doc.put("favMovies", favMovies);
	        
	        BasicDBList history = new BasicDBList();
	        doc.put("history", history);

	        coll.insert(doc);
			
	        //mesg is just used for debugging purpose . will be  removed later
			request.setAttribute("mesg", "added the values in mongo db");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		}	
		
		 catch(Exception ex) {
		System.out.println(ex.getMessage());
	   }
	}
}
