package mrs.database;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;

@Embeddable
@Table(name="movie_language")
public class Movie_language {

	private int mid;
	private int lid;
	
	@Column(name="mid")
	public int getMid() {
		return mid;
	}
	
	@Column(name="mid")
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	@Column(name="lid")
	public int getLid() {
		return lid;
	}
	
	@Column(name="lid")
	public void setLid(int lid) {
		this.lid = lid;
	}

	
	
}
