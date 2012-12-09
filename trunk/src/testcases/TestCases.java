package testcases;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mrs.*;
import mrs.database.*;

import org.junit.Test;

import drools.movieapi.MoviesApi;

public class TestCases {
	
	@Test
	public void LoginTest() throws Exception {
		HttpServletRequest mockRequest = mock(HttpServletRequest.class);
		HttpSession mockSession = mock(HttpSession.class);
		when(mockRequest.getSession(true)).thenReturn(mockSession);
		
		mrs.Login login = new Login();
		assertEquals("User logged in",login.CheckUser(mockRequest,"divya","divya"));
	}
	
	@Test
	public void LoginFailure() throws Exception {
		HttpServletRequest mockRequest = mock(HttpServletRequest.class);
		HttpSession mockSession = mock(HttpSession.class);
		when(mockRequest.getSession(true)).thenReturn(mockSession);
		
		mrs.Login login = new Login();
		assertEquals("Wrong password",login.CheckUser(mockRequest,"divya","div"));
	}
	
	@Test
	public void LoginNotPresent() throws Exception {
		HttpServletRequest mockRequest = mock(HttpServletRequest.class);
		HttpSession mockSession = mock(HttpSession.class);
		when(mockRequest.getSession(true)).thenReturn(mockSession);
		
		mrs.Login login = new Login();
		assertEquals("User not found",login.CheckUser(mockRequest,"div","div"));
	}
	
	@Test
	public void RegisterUser() throws Exception {
		HttpServletRequest mockRequest = mock(HttpServletRequest.class);
		when(mockRequest.getParameter("userId")).thenReturn("testcase");
		when(mockRequest.getParameter("email")).thenReturn("testcase");
		when(mockRequest.getParameter("passwd")).thenReturn("testcase");
		when(mockRequest.getParameter("firstName")).thenReturn("testcase");
		when(mockRequest.getParameter("lastName")).thenReturn("testcase");
		when(mockRequest.getParameter("gender")).thenReturn("testcase");
		when(mockRequest.getParameter("age")).thenReturn("testcase");
		when(mockRequest.getParameter("lang")).thenReturn("testcase");
		when(mockRequest.getParameter("loc")).thenReturn("testcase");
		when(mockRequest.getParameter("genre")).thenReturn("testcase");
		
		mrs.Register register = new Register();
		assertEquals(true,register.AddUser(mockRequest));
	}
	
	@Test
	public void testInsertSingleRecommendationSuccess() throws Exception {
		assertEquals(true,new MoviesApi().insertRecommendation("pirates of carribean", "testuser"));
	}
	
	
	@Test
	public void testInsertSingleRecommendationFailure() throws Exception {
		assertEquals(false,new MoviesApi().insertRecommendation("pirates of carribean", "invaliduser"));
	}
	
	@Test
	public void DurationTest1() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Duration","1","testuser"));
	}
	
	@Test
	public void DurationTest130() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Duration","130","testuser"));
	}
	
	@Test
	public void DurationTest2() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Duration","2","testuser"));
	}
	
	@Test
	public void DurationTest230() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Duration","230","testuser"));
	}
	
	@Test
	public void DurationTest330() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Duration","330","testuser"));
	}
	
	@Test
	public void AgeTest10() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Age","10","testuser"));
	}
	
	@Test
	public void AgeTest20() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Age","20","testuser"));
	}
	
	@Test
	public void AgeTest30() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Age","30","testuser"));
	}
	
	@Test
	public void AgeTest40() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Age","40","testuser"));
	}
	
	@Test
	public void AgeTest50() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Age","50","testuser"));
	}
	
	@Test
	public void AgeTest60() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Age","60","testuser"));
	}
	
	@Test
	public void GendertMale() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Gender","Male","testuser"));
	}
	
	@Test
	public void GendertFemale() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Gender","Female","testuser"));
	}
	
	@Test
	public void GenreAction() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Genre","Action","testuser"));
	}
	
	@Test
	public void GenreMystery() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Genre","Mystery","testuser"));
	}
	
	@Test
	public void GenreRomance() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Genre","Romance","testuser"));
	}
	
	@Test
	public void GenreDrama() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Genre","Drama","testuser"));
	}
	
	@Test
	public void GenreDocumentary() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Genre","Documentary","testuser"));
	}
	
	@Test
	public void GenreAnimation() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Genre","Animation","testuser"));
	}
	
	@Test
	public void LanguageEnglish() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Language","English","testuser"));
	}
	
	@Test
	public void LanguageHindi() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Language","Hindi","testuser"));
	}
	
	@Test
	public void LanguageMandarin() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Language","Mandarin","testuser"));
	}
	
	@Test
	public void LanguageGerman() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Language","German","testuser"));
	}
	
	@Test
	public void LanguageFrench() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Language","French","testuser"));
	}
	
	@Test
	public void LocationUS() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Location","US","testuser"));
	}
	
	
	@Test
	public void LocationEurope() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Location","Europe","testuser"));
	}
	
	@Test
	public void LocationFrance() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Location","France","testuser"));
	}
	
	@Test
	public void LocationAsia() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Location","Asia","testuser"));
	}
	
	@Test
	public void LocationAfrica() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Location","Africa","testuser"));
	}
	
	@Test
	public void MoodFeelGood() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Mood","FeelGood","testuser"));
	}
	
	@Test
	public void MoodWitty() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Mood","Witty","testuser"));
	}
	
	@Test
	public void MoodRough() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Mood","Rough","testuser"));
	}
	
	@Test
	public void MoodThoughtProvoking() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Mood","ThoughtProvoking","testuser"));
	}
	
	@Test
	public void MoodExciting() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Mood","Exciting","testuser"));
	}
	
	@Test
	public void MoodMindBending() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Mood","MindBending","testuser"));
	}
	
	@Test
	public void Period90s() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Period","90s","testuser"));
	}
	
	@Test
	public void Period20s() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Period","20s","testuser"));
	}
	
	@Test
	public void Period30s() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Period","30s","testuser"));
	}
	
	@Test
	public void PeriodAncient() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Period","Ancient","testuser"));
	}
	
	@Test
	public void PeriodMiddle() throws UnknownHostException, MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		assertEquals(true,new MoviesApi().insertSingleRecommendation("Period","Middle","testuser"));
	}
	

@Test
		public void SearchActorsTest() throws Exception {
		HttpServletRequest mockRequest = (HttpServletRequest) mock(HttpServletRequest.class);
		HttpSession mockSession = mock(HttpSession.class);
		when (mockRequest.getSession(true)).thenReturn(mockSession);
		mrs.Search search = new Search();
		ArrayList<Actors> result =(ArrayList<Actors>) search.getActorsList("b");
		assertEquals(true, result.size()>0);
		
		}
	@Test
	public void SearchMoviesTest() throws Exception {
	HttpServletRequest mockRequest = (HttpServletRequest) mock(HttpServletRequest.class);
	HttpSession mockSession = mock(HttpSession.class);
	when (mockRequest.getSession(true)).thenReturn(mockSession);
	mrs.Search search = new Search();
	ArrayList<Movies> result =(ArrayList<Movies>) search.getMoviesList("b");
	
	assertEquals(true, result.size()>0);
	
	}
	
	
	
	
	
	@Test
	public void SearchLanguagesTest() throws Exception {
	HttpServletRequest mockRequest = (HttpServletRequest) mock(HttpServletRequest.class);
	HttpSession mockSession = mock(HttpSession.class);
	when (mockRequest.getSession(true)).thenReturn(mockSession);
	mrs.Search search = new Search();
	ArrayList<Language> result =(ArrayList<Language>) search.getLanguageList("English");
	assertEquals(true, result.size()>0);
	
	}
	
	@Test
	public void SearchGenresTest() throws Exception {
	HttpServletRequest mockRequest = (HttpServletRequest) mock(HttpServletRequest.class);
	HttpSession mockSession = mock(HttpSession.class);
	when (mockRequest.getSession(true)).thenReturn(mockSession);
	mrs.Search search = new Search();
	ArrayList<Genres> result =(ArrayList<Genres>) search.getGenresList("Docu");
	assertEquals(true, result.size()>0);
	
	}
	

	
	
}
