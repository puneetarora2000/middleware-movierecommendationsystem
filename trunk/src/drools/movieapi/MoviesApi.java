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
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;


import drools.constants.Collections;
import drools.constants.Tables;
5
import drools.moviedb.MongoDB;

public class MoviesApi {

	private MongoDB mongoDB;
	
	public MoviesApi() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, MalformedURLException, UnknownHostException {
		System.out.println("Connecting to DB");
		mongoDB = new MongoDB();
		System.out.println("Connected to DB");
		
	
	public void updateMovieRating(int mid, double rating) throws UnknownHostException {
		System.out.println("Updating rating for movies");		
		mongoDB.connectMovieDB();
		mongoDB.updateMovieRating(mid, rating);
		mongoDB.closeDB();
	}
	
	public void updateMovieReview(int mid, String review) throws UnknownHostException {
		System.out.println("Adding review for movies");		
		mongoDB.connectMovieDB();
		mongoDB.updateMovieReview(mid, review);
		mongoDB.closeDB();
	}
	
	
	//to be tested by JUnit
	public boolean insertSingleRecommendation(String collection, String key, String userName) throws UnknownHostException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String movieName = null;
		try {
			mongoDB.connectMovieDB();
			mongoDB.getFavList(collection);
		}
		catch(Exception e) {
			return false;
		}
		while(mongoDB.cursor.hasNext()) {
			System.out.println("One record");
			DBObject favRecord = mongoDB.cursor.next();
			System.out.println("Age Record: " + favRecord.toString());
			//System.out.println("Key: " + key);
			if(favRecord.get(key) != null)
				movieName = favRecord.get(key).toString();
			else
				movieName = null;
		}
		try {
			mongoDB.closeDB();
		}
		catch (Exception e) {
			return false;
		}
		System.out.println("movieName" + movieName);
		System.out.println("UserName" + userName);
		this.insertRecommendation(movieName, userName);
		return true;
	}
	
	
	// to be tested by JUnit
	public boolean insertRecommendation(String movieName, String userName) throws UnknownHostException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if(movieName == null)
			return true;  // no movie is added
		System.out.println("Generating Recommendation for users");
		int statusCheck = 0;
		try {
		mongoDB.connectUserDB();
		mongoDB.getUserList();
		}
		catch(Exception e) {
			return false; // DB failure
		}
		System.out.println("List of all users");
		while(mongoDB.cursor.hasNext()) {
			JSONObject updateUser = new JSONObject();
			DBObject user = mongoDB.cursor.next();
			if(user.get("userId").toString().equals(userName)) {
				try {
				DBObject query = new BasicDBObject("favMovies.title", movieName);
				DBCursor result = mongoDB.collection.find(query);
				if(result.size() > 0)
					return true;
				}
				catch(Exception e) {
					return false; // DB failure
				}
				//System.out.println("Result size: "+result.size());
				if(user.get("userId") != null)
					updateUser.put("userId", user.get("userId").toString());
				else
					updateUser.put("userId", null);	
				if(user.get("email") != null)
					updateUser.put("email", user.get("email").toString());
				else
					updateUser.put("email", null);	
				if(user.get("passwd") != null)
					updateUser.put("passwd", user.get("passwd").toString());
				else
					updateUser.put("passwd", null);
				if(user.get("history") != null)
					updateUser.put("history", user.get("history").toString());
				else
					updateUser.put("history", null);
				if(user.get("gender") != null)
					updateUser.put("gender", user.get("gender").toString());
				else
					updateUser.put("gender", null);
				if(user.get("firstName") != null)
					updateUser.put("firstName", user.get("firstName").toString());
				else
					updateUser.put("firstName", null);
				if(user.get("lastName") != null)
					updateUser.put("lastName", user.get("lastName").toString());
				else
					updateUser.put("lastName", null);
				if(user.get("age") != null)
					updateUser.put("age", user.get("age").toString());
				else
					updateUser.put("age", null);
				if(user.get("lang") != null)
					updateUser.put("lang", user.get("lang").toString());
				else
					updateUser.put("lang", null);
				if(user.get("loc") != null)
					updateUser.put("loc", user.get("loc").toString());
				else
					updateUser.put("loc", null);
				if(user.get("duration") != null)
					updateUser.put("duration", user.get("duration").toString());
				else
					updateUser.put("duration", null);
				if(user.get("timeperiod") != null)
					updateUser.put("timeperiod", user.get("timeperiod").toString());
				else
					updateUser.put("timeperiod", null);
				if(user.get("mood") != null)
					updateUser.put("mood", user.get("mood").toString());
				else
					updateUser.put("mood", null);
				BasicDBList favList = (BasicDBList)user.get("favMovies");
				JSONArray favMovies = new JSONArray();
				if(favList != null ) {
				for(Iterator it = favList.iterator(); it.hasNext();) {
					DBObject favElement;
					JSONObject fav = new JSONObject();
					try {
						favElement = (DBObject) it.next();
					}
					catch(Exception e) {
						System.out.println("Not valid entries in FavList");
						continue;
					}
					String similarMovieName;
					similarMovieName = favElement.get("title").toString();
					fav.put("title", similarMovieName);
					favMovies.add(fav);
				}
				}
				JSONObject favNew = new JSONObject();
				favNew.put("title",movieName);
				favMovies.add(favNew);
				updateUser.put("favMovies", favMovies);
				System.out.println(updateUser);
				mongoDB.removeUser(user);
				mongoDB.addUser(updateUser);
				statusCheck = 1;
				break;
			}	
		}
		if(statusCheck == 0)
			return false;
		try {
		mongoDB.closeDB();		
		}
		catch(Exception e) {
			return false; // DB failure
		}
		return true;
	}
}
