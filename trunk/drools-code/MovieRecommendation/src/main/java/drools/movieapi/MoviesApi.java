package drools.movieapi;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.mongodb.BasicDBList;
import com.mongodb.DBObject;

import mrs.database.CastMovie;
import mrs.database.MovieGenre;
import mrs.database.MovieLanguage;
import mrs.database.Movies;
import mrs.database.NowPlayingMovies;
import mrs.database.UpcomingMovies;

import drools.constants.Tables;
import drools.email.SendMail;
import drools.moviedb.MongoDB;
import drools.moviedb.MySQLDB;

public class MoviesApi {
	private MySQLDB MovieDB;
	private MongoDB mongoDB;
	
	public MoviesApi() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, MalformedURLException, UnknownHostException {
		System.out.println("Connecting to DB");
		mongoDB = new MongoDB();
		System.out.println("Connected to DB");
		MovieDB = new MySQLDB();		
	}
	
	public void nowPlayingMovies() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException, org.json.simple.parser.ParseException, ParseException {
		StringTokenizer dateToken;
		MovieDB.connectDB();
		MovieDB.truncateTable(Tables.NOW_PLAYING_MOVIES.getName());
		System.out.println("Fetching now Playing list");
		URL new_movie_url=new URL("http://api.themoviedb.org/3/movie/now_playing?api_key=e88aa0025e49b8c50140cc3db7710376");
		File new_movie_json=new File("NowPlayingMovies.json");
		FileUtils.copyURLToFile(new_movie_url,new_movie_json);	
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("NowPlayingMovies.json"));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray movies = (JSONArray) jsonObject.get("results");
		System.out.println("Fetched now playing movies list");
		for(int j=0; j < movies.size(); j++) { // Iterate each element in the elements array
			JSONObject element =  (JSONObject) movies.get(j);
			NowPlayingMovies nowPlayingMovie = new NowPlayingMovies();
			nowPlayingMovie.setTitle(element.get("title").toString());
			nowPlayingMovie.setMid(Integer.parseInt(element.get("id").toString())*10);
			dateToken = new StringTokenizer(element.get("release_date").toString(),"-");
			nowPlayingMovie.setYear(Integer.parseInt(dateToken.nextToken()));
			System.out.print("Title: " + element.get("title").toString());
			System.out.println("Year: " + Integer.parseInt(dateToken.nextToken()));
			System.out.println("Mid: " + Integer.parseInt(element.get("id").toString())*10);
			MovieDB.insertNowPlayingMovie(nowPlayingMovie);
        }
		MovieDB.commitDB();
		MovieDB.closeDB();
	}
	
	public void upcomingMovies() throws IOException, org.json.simple.parser.ParseException, SQLException, ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException  {
		StringTokenizer dateToken;
		Movies movie;
		MovieDB.connectDB();
		MovieDB.truncateTable(Tables.UPCOMING_MOVIES.getName());
		System.out.println("Fetching upcoming movies list");
		URL new_movie_url=new URL("http://api.themoviedb.org/3/movie/upcoming?api_key=e88aa0025e49b8c50140cc3db7710376");
		File new_movie_json=new File("UpcomingMovies.json");
		FileUtils.copyURLToFile(new_movie_url,new_movie_json);	
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("UpcomingMovies.json"));
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray movies = (JSONArray) jsonObject.get("results");
		System.out.println("Fetched upcoming movies list");
		for(int j=0; j < movies.size(); j++) { // Iterate each element in the elements array
			JSONObject element =  (JSONObject) movies.get(j);
			UpcomingMovies upcomingMovie = new UpcomingMovies();
			upcomingMovie.setTitle(element.get("title").toString());
			upcomingMovie.setMid(Integer.parseInt(element.get("id").toString())*10);
			dateToken = new StringTokenizer(element.get("release_date").toString(),"-");
			upcomingMovie.setYear(Integer.parseInt(dateToken.nextToken()));
			System.out.print("Title: " + element.get("title").toString());
			System.out.println("Year: " + Integer.parseInt(dateToken.nextToken()));
			System.out.println("Mid: " + Integer.parseInt(element.get("id").toString())*10);
			MovieDB.insertUpcomingMovie(upcomingMovie);
			movie = new Movies();
			movie.setMid(upcomingMovie.getMid());
			movie.setTitle(upcomingMovie.getTitle());
			movie.setYear(upcomingMovie.getYear());
			System.out.println("Updating Master Movies list");
			updateMoviesList(movie);
        }
		MovieDB.commitDB();
		MovieDB.closeDB();	
	}
	
	public void updateMoviesList(Movies movie) {
		if(MovieDB.checkMovie(movie.getMid())==0) {
			System.out.println("Adding "+movie.getMid()+" to Master Movies list");
			MovieDB.insertMovie(movie);
			updateCastMovie(movie);
			updateMovieGenre(movie);
			updateMovieLanguage(movie);
		}
	}
	
	private void updateMovieLanguage(Movies movie) {
		MovieLanguage movieLanguage = new MovieLanguage();
		movieLanguage.setMid(movie.getMid());
		movieLanguage.setLid(1);
		MovieDB.insertMovie(movieLanguage);
	}

	private void updateMovieGenre(Movies movie) {
		MovieGenre movieGenre = new MovieGenre();
		movieGenre.setMid(movie.getMid());
		movieGenre.setGid(11);
		MovieDB.insertMovie(movieGenre);
	}

	private void updateCastMovie(Movies movie) {
		CastMovie castMovie = new CastMovie();
		castMovie.setAid(100);
		castMovie.setMid(movie.getMid());
		castMovie.setRole("Hero");
		MovieDB.insertMovie(castMovie);
	}
	
	private String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	  }
	
	public void searchMovies() {
		// to do
	}
	
	public void commitChanges() {
		MovieDB.commitDB();
		MovieDB.closeDB();
	}
	
	public void generateRecommendation() throws IOException, org.json.simple.parser.ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		int mid, similarMid;
		System.out.println("Generating Recommendation for users");
		mongoDB.connectUserDB();
		mongoDB.getUserList();
		MovieDB.connectDB();
		System.out.println("List of all users");
		while(mongoDB.cursor.hasNext()) {
			JSONObject updateUser = new JSONObject();
			DBObject user = mongoDB.cursor.next();
			System.out.println("Username: " + user.get("userId").toString());
			updateUser.put("userId", user.get("userId").toString());
			updateUser.put("email", user.get("email").toString());
			updateUser.put("passwd", user.get("passwd").toString());
			updateUser.put("history", user.get("history"));
			BasicDBList history = (BasicDBList)user.get("history");
			JSONArray favMovies = new JSONArray();
			//System.out.println("List: "+history);
			for(Iterator it = history.iterator(); it.hasNext();) {
				DBObject historyElement;
				try {
					historyElement = (DBObject) it.next();
				}
				catch(Exception e) {
					System.out.println("Not valid entries in history");
					continue;
				}
				JSONObject fav = new JSONObject();
				mid = Math.round(Float.parseFloat(historyElement.get("id").toString()));
				URL similarMovieUrl=new URL("http://api.themoviedb.org/3/movie/"+(mid/10)+"/similar_movies?api_key=e88aa0025e49b8c50140cc3db7710376");
				File similarMovieJson=new File("similarMovie.json");
				try {
				FileUtils.copyURLToFile(similarMovieUrl,similarMovieJson);
				}
				catch (Exception e) {
					System.out.println("Skipping bad Movie ID");
					continue;
				}
				JSONParser parser = new JSONParser();
				Object obj = parser.parse(new FileReader("similarMovie.json"));
				JSONObject jsonObject = (JSONObject) obj;
				JSONArray movies = (JSONArray) jsonObject.get("results");
				if(movies.size()>0) {
					JSONObject element =  (JSONObject) movies.get(1);
					similarMid = Integer.parseInt(element.get("id").toString())*10;
					fav.put("id", similarMid);
					favMovies.add(fav);
					Movies movie = getMovieInfo(similarMid/10);
					updateMoviesList(movie);
				}
		    }
			updateUser.put("favMovies", favMovies);
			System.out.println(updateUser);
			/*for(int j=0; j < history.size(); j++) { // Iterate each element in the elements array
				JSONObject element =  (JSONObject) history.get(j);
				System.out.println("ID: "+ Integer.parseInt(element.get("id").toString()));
	        }*/
			mongoDB.removeUser(user);
			mongoDB.addUser(updateUser);
		}
		mongoDB.closeDB();
		MovieDB.commitDB();
		MovieDB.closeDB();
	}
	
	public void emailRecommendation() throws IOException, org.json.simple.parser.ParseException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		System.out.println("Emailing Recommendation for users");
		mongoDB.connectUserDB();
		mongoDB.getUserList();
		MovieDB.connectDB();
		System.out.println("List of all users");	
		while(mongoDB.cursor.hasNext()) {
			int mid;
			List<String> favEmailList = new ArrayList<String>();
			DBObject user = mongoDB.cursor.next();
			BasicDBList favMoviesList = (BasicDBList)user.get("favMovies");
			for(Iterator it = favMoviesList.iterator(); it.hasNext();) {
				DBObject favElement = (DBObject) it.next();
				mid = Math.round(Float.parseFloat(favElement.get("id").toString()));
				Movies movie = getMovieInfo(mid/10);
				favEmailList.add(movie.getTitle());
		    }
			System.out.println("Username: "+ favEmailList.toString());
			SendMail sendMail = new SendMail("ggvishnu29@gmail.com", user.get("email").toString(), "Recommended Movies", favEmailList.toString());
			sendMail.send();
			System.out.println("Email sent");
		}
		mongoDB.closeDB();
		MovieDB.commitDB();
		MovieDB.closeDB();
	}
	
	public Movies getMovieInfo(int mid) throws IOException, org.json.simple.parser.ParseException {
		Movies movie = new Movies();
		URL movieInfoUrl=new URL("http://api.themoviedb.org/3/movie/"+mid+"?api_key=e88aa0025e49b8c50140cc3db7710376");
		File movieInfoJson=new File("MovieInfo.json");
		FileUtils.copyURLToFile(movieInfoUrl,movieInfoJson);	
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("MovieInfo.json"));
		JSONObject element = (JSONObject) obj;
		movie.setMid(mid*10);
		movie.setTitle(element.get("title").toString());
		StringTokenizer dateToken = new StringTokenizer(element.get("release_date").toString(),"-");
		movie.setYear(Integer.parseInt(dateToken.nextToken()));
		return movie;
	}
	
	public void updateMovieRating(int mid, double rating) throws UnknownHostException {
		System.out.println("Updating rating for movies");		
		mongoDB.connectMovieDB();
		mongoDB.updateMovieRating(mid, rating);
		mongoDB.closeDB();
	}
}
