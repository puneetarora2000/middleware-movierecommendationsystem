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

public class SearchMovies extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			System.out.print("I am in SearchMovies");
			
			String movie = request.getParameter("movie");			
			Session session = HibernateUtil.currentSession();
			session.beginTransaction();
			Query query = session.createQuery("from "+ Movies.class.getName()+" where title like '"+movie+"%' ");
			
			System.out.print(query.getQueryString());
			
			query.setMaxResults(100);
			@SuppressWarnings("unchecked")
			List<Movies> result = (List<Movies>) query.list();
			session.getTransaction().commit();			
			HttpSession httpSession = request.getSession(true);	
			httpSession.removeAttribute("actorsList");
			httpSession.removeAttribute("moviesList");
			httpSession.setAttribute("moviesList", result);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/details.jsp");
			dispatcher.forward(request, response);
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
