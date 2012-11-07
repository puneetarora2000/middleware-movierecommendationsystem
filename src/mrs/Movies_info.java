package mrs;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mrs.database.Language;
import mrs.database.Movie_language;

import org.hibernate.Query;
import org.hibernate.Session;
 
public class Movies_info extends HttpServlet {


	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			
			System.out.println("I am in Movies_Info");
			
			
			String mid = request.getParameter("mid");					
			Session session1 = HibernateUtil.currentSession();
			session1.beginTransaction();
			Query query1;
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("actorsList",null);
			
			if(mid!= null && mid.length()>0)
			{
				System.out.println("in movies");

				System.out.println("in movies");
				List<Language> result = null;

				query1 = session1.createQuery("from "+ Movie_language.class.getName()+" where mid like '"+ mid +"%'");
				System.out.println(query1.toString());
				session1.getTransaction().commit();
				List<Movie_language> result1 = (List<Movie_language>) query1.list();
				if(result1.size() > 0){
					int lid = result1.get(0).getLid();
					query1 = session1.createQuery("from "+ Language.class.getName()+" where lid = "+lid );
					System.out.println(query1.toString());
					session1.getTransaction().commit();
					 result = (List<Language>) query1.list();			
					System.out.println(result.size());
				
				}			
				
				httpSession.setAttribute("language_list", result);			
		
				httpSession.setAttribute("mid", mid);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/movieInfo.jsp");
				dispatcher.forward(request, response);
				
			}
			else
			{
				System.out.print("I am in Search Empty");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
				dispatcher.forward(request, response);
			}

			session1.clear();
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
