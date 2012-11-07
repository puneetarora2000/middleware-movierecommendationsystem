package mrs;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

public class Login extends  HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try  {
		
			String userId = request.getParameter("userId");
			String passwd = request.getParameter("passwd");
			
			Mongo m = new Mongo("ec2-54-243-59-26.compute-1.amazonaws.com",27017);
			 m.setWriteConcern(WriteConcern.SAFE);
			DB db = m.getDB("UserProfile");
			DBCollection coll = db.getCollection("testCollection");
			
			BasicDBObject query = new BasicDBObject();
			query.put("userId", userId);
			DBCursor cursor = coll.find(query);
			
			String msg = "User not found";
			while(cursor.hasNext()) {
				DBObject obj = cursor.next();
				if(obj.get("passwd").equals(passwd)) {
					msg = "User logged in";
				} else
					msg = "Wrong password";
			}
			
			request.setAttribute("mesg", msg);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		}
	
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		   }
	}
}
