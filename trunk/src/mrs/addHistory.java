package mrs;

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
		httpSession.setAttribute("mid", mid);				
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/movieInfo.jsp");
		dispatcher.forward(request, response);
		}
		catch (Exception e) {
			System.out.print("Error in updating history" +e);
		}
		 
		
		
		
	}
}

