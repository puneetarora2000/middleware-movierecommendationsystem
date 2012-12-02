package drools.main;

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


import drools.message.RatingMessage;
import drools.message.ReviewMessage;

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
	
	public void fireRules() {
		ksession.fireAllRules();
	}
	
	private static KnowledgeBase readKnowledgeBase() throws Exception {
		//System.out.println(KnowledgeBuilderFactory.getClass().getPackage().getImplementationVersion()); 
	//	System.out.println(CompositeClassLoader.getClass().getPackage().getImplementationVersion()); 
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
}
