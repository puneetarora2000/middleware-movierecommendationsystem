package drools.message;

public class RatingMessage {
	private int mid;
	private double rating;
	
	
	
	public RatingMessage(int mid, double rating) {
		super();
		this.mid = mid;
		this.rating = rating;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
}
