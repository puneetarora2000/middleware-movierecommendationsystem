package mrs;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

public class SetInterest extends  HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try  {
			
			String mood = request.getParameter("mood");
			String period = request.getParameter("period");
			String duration = request.getParameter("duration");
			
			HttpSession session = request.getSession(true);
			String userId = (String) session.getAttribute("user");
			
			Mongo m = new Mongo("ec2-54-243-59-26.compute-1.amazonaws.com",27017);
			 m.setWriteConcern(WriteConcern.SAFE);
			DB db = m.getDB("UserProfile");
			DBCollection coll = db.getCollection("testCollection");
			
			BasicDBObject query = new BasicDBObject();
			query.put("userId", userId);
			
			DBObject user = coll.findOne(query);
		//	DBObject moodObj = (DBObject)user.get("mood");
		/*	if(moodObj == null) {
				System.out.println("inside!");
				user.put("mood", mood);
				coll.update(user,user);
				
			} else {*/
				BasicDBObject movieUpdate = new BasicDBObject().append("$set", 
						new BasicDBObject().append("mood", mood));
				coll.update(user, movieUpdate);
			//}
				
	    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		    dispatcher.forward(request, response);
		}
     	catch(Exception ex) {
		System.out.println(ex.getMessage());
	   }
	}
}
