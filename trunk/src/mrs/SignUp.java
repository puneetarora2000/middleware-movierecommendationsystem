package mrs;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUp extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/signup.jsp");
			dispatcher.forward(request, response);
		}	
		
		 catch(Exception ex) {
		System.out.println(ex.getMessage());
	   }
	}
}
