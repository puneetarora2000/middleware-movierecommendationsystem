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

import drools.main.DroolsApi;

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
		
			
			if(!(mood == null) && (!mood.isEmpty()))
					
					{
				BasicDBObject movieUpdate = new BasicDBObject().append("$set", 
						new BasicDBObject().append("mood", mood));
				coll.update(user, movieUpdate);
			}
			else if(!(period == null) &&(!period.isEmpty())){
				BasicDBObject movieUpdate = new BasicDBObject().append("$set", 
						new BasicDBObject().append("period", period));
				coll.update(user, movieUpdate);
			}
			else if(!(duration == null) &&(!duration.isEmpty())){
				BasicDBObject movieUpdate = new BasicDBObject().append("$set", 
						new BasicDBObject().append("duration", duration));
				coll.update(user, movieUpdate);
			}
			
			DroolsApi test = new DroolsApi(); // create this object, you should maintain this object for the entire session
			
			test.createKnowledgeBase();
			test.insertRecommendation(userId);//pass movieID(300 here)	 and the user rating(2.45)	as parameter to this function
			test.fireRules(); //call this function as it is.
		
		
	    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ShowRecomendation");
		    dispatcher.forward(request, response);
		}
     	catch(Exception ex) {
		System.out.println(ex.getMessage());
	   }
	}
}
