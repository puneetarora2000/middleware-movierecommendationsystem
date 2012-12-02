package mrs;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

public class addHistory extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		String mid = (String) request.getParameter("mid");
		HttpSession httpSession = request.getSession(true);
		try {
	
			String user = (String) httpSession.getAttribute("user");
			mid = (String) request.getParameter("mid");
	if(user!= null && mid!=null )
	{
		Mongo mongoInstance = MongoSingleton.getInstance();
		DB db = mongoInstance.getDB("UserProfile");
		DBCollection coll = db.getCollection("testCollection");
		
		 BasicDBObject mongoquery = new BasicDBObject();
		 mongoquery.put("userId", user);
		 DBCursor cursor = null;
		 try
		 {
			 cursor =  coll.find(mongoquery);
			 while(cursor.hasNext()) {
				 DBObject obj =  cursor.next();	
				 //BasicDBObject history = (BasicDBObject) obj.get("history");
				 BasicDBObject temp = new BasicDBObject();
				 temp.put("id",mid);
				 
				 BasicDBList ob = (BasicDBList) obj.get("history");								 							 
				 ob.add(temp);
				 
				 obj.put("history", ob);
				 coll.save(obj);
				 
			 }
		 }
		 catch (Exception e) {
			System.out.print("Error in mongo connection" +e);
		}
		 finally{
			 cursor.close();
		 }
		 
	}
		httpSession.setAttribute("rating", getRating(mid, httpSession) );
		httpSession.setAttribute("mid", mid);
		httpSession.setAttribute("user", user);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/movieInfo.jsp");
		dispatcher.forward(request, response);
		}
		catch (Exception e) {
			System.out.print("Error in updating history" +e);
		}
	}

	private double getRating(String mid, HttpSession httpSession) throws Exception {
		
		System.out.println("Get Rating ---- method in the addhistory servlet");
		// Connection to Mongo DB
		Mongo m = new Mongo("ec2-54-243-59-26.compute-1.amazonaws.com",27017);
		m.setWriteConcern(WriteConcern.SAFE);
		DB db = m.getDB("movieDB");
		DBCollection coll = db.getCollection("movies");
		double rating = 0;
		ArrayList<String> reviews = new ArrayList<>();
		BasicDBObject mongoQuery = new BasicDBObject();
		mongoQuery.put("mid",Integer.parseInt(mid));
		DBCursor cursor = coll.find(mongoQuery);
		BasicDBList ob = null;

		while(cursor.hasNext()) {
			DBObject obj = cursor.next();
			ob = (BasicDBList) obj.get("review");
			rating = (double) obj.get("rating");
		}
		
		httpSession.setAttribute("ob",ob);
		
		return rating;
		
	}
}

