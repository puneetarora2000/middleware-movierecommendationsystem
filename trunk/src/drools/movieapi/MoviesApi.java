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


//import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.IOUtils;
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

import drools.constants.Tables;
import drools.moviedb.MongoDB;


public class MoviesApi {
	
	private MongoDB mongoDB;
	
	public MoviesApi() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, MalformedURLException, UnknownHostException {
		System.out.println("Connecting to DB");
		mongoDB = new MongoDB();
		System.out.println("Connected to DB");		
	}
	
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
}
