package drools.main;

public class TestMain {
	public static void main(String[] args) throws Exception {
		DroolsApi test = new DroolsApi();
		test.createKnowledgeBase();
		test.insertRating(555, 3.0);
		test.insertReview(555, "worth watching3");
		test.fireRules();
		System.out.println("Rules fired!");
	}
}
