package drools.message;

public class Duration {
	public String userId;
	public String duration;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Duration(String userId, String duration) {
		super();
		this.userId = userId;
		this.duration = duration;
	}
	
}
