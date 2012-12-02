package drools.constants;

public enum Tables {
	UPCOMING_MOVIES ("upcoming_movies"),
	NOW_PLAYING_MOVIES ("now_playing_movies");
	private final String name;
	Tables(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
