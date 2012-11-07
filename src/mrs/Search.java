package mrs;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrs.database.Actors;
import mrs.database.Genres;
import mrs.database.Language;
import mrs.database.Movies;

import org.hibernate.Query;
import org.hibernate.Session;

public class Search extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			
			System.out.print("I am in Search");
			
			String movie = request.getParameter("movie");
			String actor = request.getParameter("actor");
			String lang = request.getParameter("language");
			String genre = request.getParameter("genre");
			System.out.println("actor " + actor);			
			System.out.println("movie "+ movie);			
			Session session = HibernateUtil.currentSession();
			session.beginTransaction();
			Query query;
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("actorsList",null);
			httpSession.setAttribute("moviesList",null);
			httpSession.setAttribute("languagesList",null);
			httpSession.setAttribute("genresList",null);
			
			if(movie!= null && movie.length()>0)
			{
				System.out.print("in movies");
				query = session.createQuery("from "+ Movies.class.getName()+" where title like '"+movie+"%' ");
				query.setMaxResults(100);
				session.getTransaction().commit();
				List<Movies> result = (List<Movies>) query.list();	
				
				for (Movies m:result){
					m.getLanguages().size();
					m.getActors().size();
					m.getGenres().size();
//					System.out.println(m.getLanguages().size());
//					System.out.println(m.getActors().size());
//					System.out.println(m.getGenres().size());
				}
				
				
				
				httpSession.setAttribute("moviesList", result);
				//for(int i=0;i<=result.size();i++)
					//{System.out.println(result.get(i).getActors().size());}
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/details.jsp");
				dispatcher.forward(request, response);
				
			}
			else if(actor!=null && actor.length()>0)
			{
				System.out.println("in actor");
				query = session.createQuery("from "+ Actors.class.getName()+" where fullname like '"+actor+"%' ");
				query.setMaxResults(100);
				session.getTransaction().commit();
				List<Actors> result = (List<Actors>) query.list();								
				httpSession.setAttribute("actorsList", result);
				
					for (Actors a:result){
					
//					System.out.println(a.getMovies().size());
						a.getMovies().size();
					
				}
					
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/details.jsp");
				dispatcher.forward(request, response);
			}
			else if(lang!=null && lang.length()>0)
			{
				System.out.println("in language");
				query = session.createQuery("from "+ Language.class.getName()+" where language like '"+lang+"%' ");
				query.setMaxResults(100);
				session.getTransaction().commit();
				List<Language> result = (List<Language>) query.list();	
				
				for (Language l:result){
					l.getMovies().size();
//					System.out.println(l.getMovies().size());
					
				}
				
				httpSession.setAttribute("languagesList", result);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/details.jsp");
				dispatcher.forward(request, response);
			}
			else if(genre!=null && genre.length()>0)
			{
				System.out.println("in genre");
				query = session.createQuery("from "+ Genres.class.getName()+" where genre like '"+genre+"%' ");
				query.setMaxResults(100);
				session.getTransaction().commit();
				List<Genres> result = (List<Genres>) query.list();	
				
				for (Genres g:result){
					
//					System.out.println(g.getMovies().size());
					g.getMovies().size();
					
				}
				
				httpSession.setAttribute("genresList", result);
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
