package drools.message;

public class Location {
	public String userId;
	public String location;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Location(String userId, String location) {
		super();
		this.userId = userId;
		this.location = location;
	}
	
}
