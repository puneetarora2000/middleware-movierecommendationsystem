package drools.main;

import drools.movieapi.MoviesApi;

public class TestMain {
	public static void main(String[] args) throws Exception {
		DroolsApi test = new DroolsApi();
		test.createKnowledgeBase();
		//test.insertRating(15550, 4.0);
		//test.insertReview(15550, "worth watching");
		//test.insertMovieAsPerson(1, "vgajen2");
		//test.insertRecommendation("divya");
		//test.fireRules();
		//System.out.println("Rules fired!");
		//MoviesApi test = new MoviesApi();
		//test.generateRecommendation();
		//test.insertRecommendation("the trail12", "divya");
		
		test.insertRecommendation("divya");
		test.fireRules();
		
		/*MoviesApi testApi = new MoviesApi();
		testApi.insertSingleRecommendation("Age", "10", "divya");*/
		System.out.println("Rules fired!");
	}
}
