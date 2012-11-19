package drools.message;

public class ReviewMessage {
	int mid;
	String review;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public ReviewMessage(int mid, String review) {
		super();
		this.mid = mid;
		this.review = review;
	}
	
	
	
	
	
	

}
