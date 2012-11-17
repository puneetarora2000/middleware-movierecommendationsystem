package drools.moviedb;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.sql.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;
import org.w3c.dom.Element;

import mrs.database.CastMovie;
import mrs.database.MovieGenre;
import mrs.database.MovieLanguage;
import mrs.database.Movies;
import mrs.database.NowPlayingMovies;
import mrs.database.UpcomingMovies;

public class MySQLDB {
	
	private SessionFactory sessionFactory;
	private Session s;
	private Transaction tx;
	
	public void connectDB() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		System.out.println("Connecting to AmazonDB");
		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		//sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		System.out.println("Connected to AmazonDB");
		s = sessionFactory.openSession();
		System.out.println("opened new session");
		tx = s.beginTransaction();	
	}
	
	public void closeDB() {
		if (s != null)
			s.close();
	}
	
	public void commitDB() {
		tx.commit();
	}
	
	public void insertUpcomingMovie(UpcomingMovies movie) throws SQLException, ParseException {
		System.out.println("Inserting to DB");	
		s.saveOrUpdate(movie);
		s.flush();
		System.out.println("Added to Database");
	}
	
	public void insertNowPlayingMovie(NowPlayingMovies movie) throws SQLException, ParseException {
		System.out.println("Inserting to DB");	
		s.saveOrUpdate(movie);
		s.flush();
		System.out.println("Added to Database");
	}
	
	public void insertMovie(Movies movie) {
		System.out.println("Inserting to DB");	
		s.saveOrUpdate(movie);
		s.flush();
		System.out.println("Added to Database");
	}
	
	public void insertMovie(CastMovie movie) {
		System.out.println("Inserting to DB");	
		s.saveOrUpdate(movie);
		s.flush();
		System.out.println("Added to Database");
	}
	
	public void insertMovie(MovieGenre movie) {
		System.out.println("Inserting to DB");	
		s.saveOrUpdate(movie);
		s.flush();
		System.out.println("Added to Database");
	}
	
	public void insertMovie(MovieLanguage movie) {
		System.out.println("Inserting to DB");	
		s.saveOrUpdate(movie);
		s.flush();
		System.out.println("Added to Database");
	}
	
	public int checkMovie(int mid) {
		Integer count = Integer.parseInt(s.createSQLQuery("select count(*) from movies where mid="+mid).uniqueResult().toString());
		return count;
	}
	
	public void truncateTable(String tableName) {
		System.out.println("Truncating table"+tableName);
		s.createSQLQuery("truncate table "+tableName).executeUpdate();
		System.out.println("table: "+tableName + "truncated");
	}
		
}
