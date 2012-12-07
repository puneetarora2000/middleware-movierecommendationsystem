package drools.message;

public class TimePeriod {
	public String userId;
	public String timePeriod;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTimePeriod() {
		return timePeriod;
	}
	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}
	public TimePeriod(String userId, String timePeriod) {
		super();
		this.userId = userId;
		this.timePeriod = timePeriod;
	}
	
	
}
