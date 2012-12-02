package drools.constants;

public enum Collections {
	TEST_COLLECTION ("testCollection"),
	MOVIE_COLLECTION ("movies");
	private final String name;

	
	private Collections(String name) {
		this.name = name;
	}



	public String getName() {
		return name;
	}

	
	

}
