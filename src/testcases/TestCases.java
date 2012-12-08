package testcases;
import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import org.junit.Test;

import drools.movieapi.MoviesApi;

public class TestCases {
	
	@Test
	public void testInsertSingleRecommendationSuccess() throws Exception {
		assertEquals(true,new MoviesApi().insertRecommendation("pirates of carribean", "divya"));
	}
	
	@Test
	public void testInsertSingleRecommendationFailure() throws Exception {
		assertEquals(true,new MoviesApi().insertRecommendation("pirates of carribean", "xxx"));
	}
	
	@Test
	public void DurationTest1() throws Exception {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Duration","1","divya"));
	}
	
}
