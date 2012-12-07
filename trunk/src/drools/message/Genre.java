package drools.message;

public class Genre {
	public String userId;
	public String genre;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Genre(String userId, String genre) {
		super();
		this.userId = userId;
		this.genre = genre;
	}
	
}
