package drools.constants;

public enum Collections {
	TEST_COLLECTION ("testCollection"),
	MOVIE_COLLECTION ("movies"),
	AGE ("age"),
	GENDER ("gender"),
	LOCATION ("location"),
	MOOD ("mood"), 
	DURATION ("duration"),
	LANGUAGE ("language"),
	GENRE ("genre"),
	TIMEPERIOD ("timeperiod");
	
	private final String name;

	
	private Collections(String name) {
		this.name = name;
	}



	public String getName() {
		return name;
	}

	
	

}
