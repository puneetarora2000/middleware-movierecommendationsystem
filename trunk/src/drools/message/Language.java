package drools.message;

public class Language {
	
	public String userId;
	public String language;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public Language(String userId, String language) {
		super();
		this.userId = userId;
		this.language = language;
	}
}
