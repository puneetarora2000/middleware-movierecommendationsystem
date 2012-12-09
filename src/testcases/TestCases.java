package testcases;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mrs.*;

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
}
