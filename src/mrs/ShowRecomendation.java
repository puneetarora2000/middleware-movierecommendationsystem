package mrs;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShowRecomendation extends HttpServlet  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try  {
			
			HttpSession session = request.getSession();
			session.removeAttribute("user");
			session.invalidate();			
	    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
		    dispatcher.forward(request, response);
		}
     	catch(Exception ex) {
		System.out.println(ex.getMessage());
     	}
	}

}
