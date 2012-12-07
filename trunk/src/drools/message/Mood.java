package drools.message;

public class Mood {
	public int userId;
	public String mood;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getMood() {
		return mood;
	}
	public void setMood(String mood) {
		this.mood = mood;
	}
	
	public Mood(int userId, String mood) {
		super();
		this.userId = userId;
		this.mood = mood;
	}
}
