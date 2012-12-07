package drools.message;

public class Gender {
	
	public String userId;
	public String gender;

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Gender(String userId, String gender) {
		super();
		this.userId = userId;
		this.gender = gender;
	}
	
}
