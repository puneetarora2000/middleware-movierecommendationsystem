package mrs.database;


public class NowPlayingMovies {
	private int mid;
	private String title;
	private int year;
	private Integer year_end;
	private String vtype;
	private String notes;
	private Float rating;
	private Integer num_votes;
	private String distribution;
	private String year_suffix;
	
 
	public int getMid() {
		return mid;
	}
	

	public void setMid(int mid) {
		this.mid = mid;
	}
	

	public String getTitle() {
		return title;
	}
	

	public void setTitle(String title) {
		this.title = title;
	}
	

	public int getYear() {
		return year;
	}
	

	public void setYear(int year) {
		this.year = year;
	}
	

	public Integer getYear_end() {
		if (this.year_end != null) 
			  return (Integer) year_end.intValue();
		else
				  return (Integer) 1;
		
	}
	
	
	public void setYear_end(Integer year_end) {
		this.year_end = year_end;
	}
	
	
	public String getVtype() {
		return vtype;
	}
	
	
	public void setVtype(String vtype) {
		this.vtype = vtype;
	}
	
	
	public String getNotes() {
		return notes;
	}
	
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	public Float getRating() {
		if (this.rating != null)
			return rating.floatValue();
		else
			return (float) 0;
	}
	
	
	public void setRating(Float rating) {
		this.rating = rating;
	}
	
		
	public Integer getNum_votes() {
		if(num_votes != null)
			return num_votes.intValue();
		else
			return 0;
	}
	
	
	public void setNum_votes(Integer num_votes) {
		this.num_votes = num_votes;
	}
	
	
	public String getDistribution() {
		return distribution;
	}
	
	
	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}
	
	
	public String getYear_suffix() {
		return year_suffix;
	}
	
	
	public void setYear_suffix(String year_suffix) {
		this.year_suffix = year_suffix;
	}
	
	
}
