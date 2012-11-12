package mrs;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrs.database.Movies;

import org.hibernate.Query;
import org.hibernate.Session;
 
public class Movies_info extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			
			System.out.print("I am in Movies_Info");
			
			
			String mid = request.getParameter("mid");					
			Session session = HibernateUtil.currentSession();
			session.beginTransaction();
			Query query;
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("actorsList",null);
			
			if(mid!= null && mid.length()>0)
			{
				System.out.print("in movies");
				query = session.createQuery("select * from movie,Cast_movie where title like '"+mid+"%' ");
				query.setMaxResults(100);
				session.getTransaction().commit();
				List<Movies> result = (List<Movies>) query.list();									
				httpSession.setAttribute("moviesList", result);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/details.jsp");
				dispatcher.forward(request, response);
				
			}
			else
			{
				System.out.print("I am in Search Empty");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
				dispatcher.forward(request, response);
			}

			session.clear();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
