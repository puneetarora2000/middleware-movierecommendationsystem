package drools.movieapi;
import java.io.FileReader;
import java.lang.reflect.*;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.*;

public class MoviesApiTest {
	
	@Test
	public void testInsertSingleRecommendationSuccess() throws Exception {
		assertEquals(true,new MoviesApi().insertRecommendation("pirates of carribean", "divya"));
	}
	
	
	@Test
	public void testInsertSingleRecommendationFailure() throws Exception {
		assertEquals(true,new MoviesApi().insertRecommendation("pirates of carribean", "xxx"));
	}
	
	@Test
	public void DurationTest1() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Duration","1","divya"));
	}
	
	@Test
	public void testReview() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().updateMovieReview(23, "test review"));
	}
	
	@Test
	public void testRating() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().updateMovieRating(23, 3));
	}
}
