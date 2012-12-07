package drools.message;

public class MovieAsPerson {
	int mid;
	String username;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public MovieAsPerson(int mid, String username) {
		super();
		this.mid = mid;
		this.username = username;
	}
	
	
}
