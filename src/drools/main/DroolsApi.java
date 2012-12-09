package drools.main;

import java.net.UnknownHostException;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import drools.constants.Collections;
import drools.message.MovieAsPerson;
import drools.message.RatingMessage;
import drools.message.ReviewMessage;
import drools.message.User;
import drools.moviedb.MongoDB;


public class DroolsApi {
	private KnowledgeBase kbase;
	private StatefulKnowledgeSession ksession;
	private KnowledgeRuntimeLogger logger;
	private KnowledgeBuilder kbuilder;
	private KnowledgeBuilderErrors errors;
	
	public void createKnowledgeBase() throws Exception {
		 try {
	            kbase = readKnowledgeBase();
	            ksession = kbase.newStatefulKnowledgeSession();
	            logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
	            //logger.close();
	        } catch (Throwable t) {
	            t.printStackTrace();
	        }
	}
	
	public void insertRating(int mid, double d) {
		RatingMessage msg = new RatingMessage(mid,d);
		ksession.insert(msg);
	}
	
	public void insertReview(int mid, String review) {
		ReviewMessage msg = new ReviewMessage(mid,review);
		ksession.insert(msg);
	}
	
	public void insertMovieAsPerson(int mid, String username) {
		MovieAsPerson msg= new MovieAsPerson(mid,username);
		ksession.insert(msg);
	}
	
	
	public void fireRules() {
		System.out.println("Just a test: "+ ksession.fireAllRules());
	}
	
	private static KnowledgeBase readKnowledgeBase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource("rules/FrontEnd.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0) {
            for (KnowledgeBuilderError error: errors) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge.");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }
	
	public void insertRecommendation(String userName) throws UnknownHostException {
		MongoDB mongoDB = new MongoDB();
		User user = new User();
		mongoDB.connectUserDB();
		mongoDB.getUserList();
		BasicDBObject query = new BasicDBObject();
		query.put("userId", userName);
		DBObject userQuery = mongoDB.collection.findOne(query);
		if(userQuery.get("userId") != null)
			user.setUserId(userQuery.get("userId").toString());
		if(userQuery.get("email") != null)
			user.setEmail(userQuery.get("email").toString());
		if(userQuery.get("passwd") != null)
			user.setPasswd(userQuery.get("passwd").toString());
		if(userQuery.get("firstName") != null)
			user.setFirstName(userQuery.get("firstName").toString());
		if(userQuery.get("lastName") != null)
			user.setLastName(userQuery.get("lastName").toString());
		if(userQuery.get("age") != null)
			user.setAge(Integer.parseInt(userQuery.get("age").toString()));
		else
			user.setAge(0);	
		if(userQuery.get("gender") != null)
			user.setGender(userQuery.get("gender").toString());
		else
			user.setGender("male");
		if(userQuery.get("lang") != null)
			user.setLang(userQuery.get("lang").toString());
		else
			user.setLang("English");
		if(userQuery.get("duration") != null)
			user.setDuration(userQuery.get("duration").toString());
		else
			user.setDuration("1");
		if(userQuery.get("timeperiod") != null)
			user.setTimePeriod(userQuery.get("timeperiod").toString());
		else
			user.setTimePeriod("90s");
		if(userQuery.get("genre") != null)
			user.setGenre(userQuery.get("genre").toString());
		else
			user.setGenre("Documentary");
		if(userQuery.get("loc") != null)
			user.setLoc(userQuery.get("loc").toString());
		else
			user.setLoc("Asia");
		if(userQuery.get("mood") != null)
			user.setMood(userQuery.get("mood").toString());
		else
			user.setMood("Exciting");
		ksession.insert(user);
		
		
		
		
		
	}
}
