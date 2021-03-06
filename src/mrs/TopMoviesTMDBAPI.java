package mrs;

import java.net.*;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TopMoviesTMDBAPI extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			//System.out.println("Entered into the class TopMoviesTMDBAPI");
			String jsonObject = getMovieListFromAPI();
			request.setAttribute("topMoviesList", jsonObject);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/topMoviesList.jsp");
			dispatcher.forward(request, response);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

    public String  getMovieListFromAPI() throws Exception  {
    	
		//System.out.println("Entered into the method getMovieListFromAPI() ");
    	
    	URL tmdb = new URL("http://api.themoviedb.org/3/movie/top_rated?api_key=e88aa0025e49b8c50140cc3db7710376&page=1");
        URLConnection conn = tmdb.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer sb = new StringBuffer();
        while ((inputLine = in.readLine()) != null) 
        	sb.append(inputLine);
        in.close();
        
        return sb.toString();
    }
}
