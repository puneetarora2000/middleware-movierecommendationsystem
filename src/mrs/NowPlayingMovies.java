package mrs;

import java.net.*;
import java.sql.DriverManager;
import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class NowPlayingMovies extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		try {
			System.out.println("Entered into the class UpcomingMovies");
			
			getMovieListFromAPI(request);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/nowPlayingMovies.jsp");
			dispatcher.forward(request, response);
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

    public void getMovieListFromAPI(HttpServletRequest request) throws Exception  {
    	
		System.out.println("Entered into the method upComing Movies() ");
    	
		String dbUrl = "jdbc:mysql://moviedb.cdmw8xr04c9z.us-east-1.rds.amazonaws.com:3306/movieDB";
		String dbClass = "com.mysql.jdbc.Driver";
		String query = "Select * FROM now_playing_movies";
		
		Class.forName(dbClass);
		Connection con = DriverManager.getConnection (dbUrl,"vishnu","root1234");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		JSONObject arrayObj = new JSONObject();
		JSONArray array = new JSONArray();
		
		while (rs.next()) {
			arrayObj = new JSONObject();
			String mid = rs.getString("mid");
			String title = "<a href= "+request.getContextPath()+"/Search?movie="+ rs.getString("title").replace(" ","%20") +">" + rs.getString("title") + "</a>" ;
			String year = rs.getString("year");
			String year_end = rs.getString("year_end");
			String vtype = rs.getString("vtype");
			String notes = rs.getString("notes");
			String rating = rs.getString("rating");
			String num_votes = rs.getString("num_votes");
			String distribution = rs.getString("distribution");
			arrayObj.put("mid",mid);
			arrayObj.put("title",title);
			arrayObj.put("year",year);
			arrayObj.put("year_end",year_end);
			arrayObj.put("vtype",vtype);
			arrayObj.put("notes",notes);
			arrayObj.put("rating",rating);
			arrayObj.put("num_votes",num_votes);
			arrayObj.put("distribution",distribution);
			array.put(arrayObj);
		} //end while
		
		request.setAttribute("now_playing_movies", array);

		con.close();
		
    }
}
