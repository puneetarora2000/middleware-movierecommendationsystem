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

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			
			System.out.println("I am in Search");
			
			String movie = request.getParameter("movie");
			String actor = request.getParameter("actor");
			String lang = request.getParameter("language");
			String genre = request.getParameter("genre");
			
			System.out.println("actor " + actor);			
			System.out.println("movie "+ movie);			
			
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("actorsList",null);
			httpSession.setAttribute("moviesList",null);
			httpSession.setAttribute("languagesList",null);
			httpSession.setAttribute("genresList",null);
			
			
			
			if(movie!= null && movie.length()>0)
			{
				
				List<Movies> result= getMoviesList(movie);
				httpSession.setAttribute("moviesList", result);				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/details.jsp");
				dispatcher.forward(request, response);
				
			}
			else if(actor!=null && actor.length()>0)
			{
				List<Actors> result= getActorsList(actor);
				httpSession.setAttribute("actorsList", result);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/details.jsp");
				dispatcher.forward(request, response);
			}
			else if(lang!=null && lang.length()>0)
			{
				List<Language> result = getLanguageList(lang);
				httpSession.setAttribute("languagesList", result);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/details.jsp");
				dispatcher.forward(request, response);
			}
			else if(genre!=null && genre.length()>0)
			{
				List<Genres> result = getGenresList(genre);
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

			
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}


	public List<Movies> getMoviesList(String movie)
	{
		movie.replaceAll("\\+", " ");
		System.out.print("in movies");
		Session session = HibernateUtil.currentSession();
		session.beginTransaction();
		Query query;
		query = session.createQuery("from "+ Movies.class.getName()+" where title like '"+movie+"%' ");	query.setMaxResults(100);
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<Movies> result = (List<Movies>) query.list();	
		int i=0;
		for (Movies m:result){
			i++;
			m.getLanguages().size();
			m.getActors().size();
			m.getGenres().size();
			if(i==30)
				break;				
			
		}
		session.clear();
		return result;
		
	}
	
	public List<Actors> getActorsList(String actor)
	{
		actor.replaceAll("\\+", " ");
		System.out.println("in actor");
		Session session = HibernateUtil.currentSession();
		session.beginTransaction();
		Query query;		
		query = session.createQuery("from "+ Actors.class.getName()+" where fullname like '"+actor+"%' ");
		query.setMaxResults(100);
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<Actors> result = (List<Actors>) query.list();								
		
		int i=0;
			for (Actors a:result){
			
//			System.out.println(a.getMovies().size());
				a.getMovies().size();
				i++;
				if(i==30)
					break;
			
		}
			session.clear();
			return result;
			
	
	}
	
	public List<Language> getLanguageList(String lang)
	{
		Session session = HibernateUtil.currentSession();
		session.beginTransaction();
		Query query;
		lang.replaceAll("\\+", " ");				
		System.out.println("in language");
		query = session.createQuery("from "+ Language.class.getName()+" where language like '"+lang+"%' ");
		query.setMaxResults(100);
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<Language> result = (List<Language>) query.list();	
		int i=0;
		for (Language l:result){
			l.getMovies().size();
			i++;
			if(i==30)
				break;
		
		}
		session.clear();
		return result;
	}
	
	public List<Genres> getGenresList(String genre)
	{
		Session session = HibernateUtil.currentSession();
		session.beginTransaction();
		Query query;
		System.out.println("in genre");
		query = session.createQuery("from "+ Genres.class.getName()+" where genre like '"+genre+"%' ");
		query.setMaxResults(100);
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<Genres> result = (List<Genres>) query.list();	
		int i=0;
		for (Genres g:result){
			g.getMovies().size();
			if(i==2)
				break;
			
		}
		session.clear();
		return result;
	
	}
	
}
