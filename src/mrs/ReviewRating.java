package mrs;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import drools.main.DroolsApi;

public class ReviewRating extends HttpServlet {
		
		
		private static final long serialVersionUID = 1L;

		
		public void doPost(HttpServletRequest request, HttpServletResponse response)
		{
			HttpSession httpSession = request.getSession(true);
			String mid = (String) httpSession.getAttribute("mid");			
			String review = (String) request.getParameter("review");
			double rating = new Double(request.getParameter("rating"));
			
			
			
			DroolsApi test = new DroolsApi(); // create this object, you should maintain this object for the entire session
			try {
				test.createKnowledgeBase();
				test.insertRating(new Integer(mid), rating );
				test.insertReview(new Integer(mid), review );//pass movieID(300 here)	 and the user rating(2.45)	as parameter to this function
				test.fireRules(); //call this function as it is.
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //call this function as it is
			
			
			
//			HttpSession httpSession = request.getSession(true);

//			
//			if(request.getSession().getAttribute("user") != null && review!= null && mid!= null)
//			{
//				Mongo mongoInstance = MongoSingleton.getInstance();
//				DB db = mongoInstance.getDB("movieDB");
//				BasicDBObject query = new BasicDBObject();
//				DBCollection collection = db.getCollection("movies");
//				query.put("mid", mid);
//				DBObject movie = collection.findOne(query);
//				if(movie == null) {
//					movie = new BasicDBObject();
//					movie.put("mid", mid);									
//					movie.put("rating", rating);
//					ArrayList<String> reviewList = new ArrayList<String>();
//					reviewList.add(review);
//					movie.put("review", reviewList);
//					collection.insert(movie);
//					
//				}
//				else{
//				System.out.println("Test: " + movie.get("rating"));
//				double rating1 = (Double) movie.get("rating");
//				double updatedRating = (rating1 + rating)/2;
//				BasicDBObject movieUpdate = new BasicDBObject().append("$set", 
//						new BasicDBObject().append("rating", updatedRating));
//				BasicDBObject movieReviewUpdate = new BasicDBObject().append("$push", 
//						new BasicDBObject().append("review", review));
//				collection.update(movie, movieUpdate);
//				collection.update(movie, movieReviewUpdate);
//				System.out.println("updated: ");
//				}
//				
//				
//				
//			}
//		}
			
			httpSession.setAttribute("mid", mid);				
			//RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/movieInfo.jsp");
			try {
				//ServletContext.this.getContextPath();
				
				System.out.println("-->"+getServletContext().getContextPath());
				response.sendRedirect(getServletContext().getContextPath()+"/addHistory?mid="+mid);

				//dispatcher.forward(request, response);
			}  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


}
}
