package mrs;

import org.hibernate.*;
import org.hibernate.cfg.*;

@SuppressWarnings("deprecation")
public class HibernateUtil {
	
	private static final SessionFactory sessionFactory =  new Configuration().configure("hibernate1.cfg.xml").buildSessionFactory();
		
	public static final ThreadLocal session = new ThreadLocal();
	
	public static Session currentSession() 
	{
		Session s = (Session) session.get();
		if (s == null) {
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}
	
	public static void closeSession()
	{
		Session s = (Session) session.get();
		if(s != null)
			s.close();
		
		session.set(null);
	}

}
