package mrs.database;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="movies")
public class Movies implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private Set<Actors> actors = new HashSet<Actors>(0);
	private Set<Language> languages = new HashSet<Language>(0);
	private Set<Genres> genres = new HashSet<Genres>(0);
	
	@Id
	@Column(name="mid") 
	public int getMid() {
		return mid;
	}
	
	@Id
	@Column(name="mid")
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	@Column(name="title")
	public String getTitle() {
		return title;
	}
	
	@Column(name="title")
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="year")
	public int getYear() {
		return year;
	}
	
	@Column(name="year")
	public void setYear(int year) {
		this.year = year;
	}
	
	@Column(name="year_end")
	public Integer getYear_end() {
		if (this.year_end != null) 
			  return (Integer) year_end.intValue();
		else
				  return (Integer) 1;
		
	}
	
	@Column(name="year_end" , nullable = true)
	public void setYear_end(Integer year_end) {
		this.year_end = year_end;
	}
	
	@Column(name="vtype" , nullable = true)
	public String getVtype() {
		return vtype;
	}
	
	@Column(name="vtype" , nullable = true)
	public void setVtype(String vtype) {
		this.vtype = vtype;
	}
	
	@Column(name="notes" , nullable = true)
	public String getNotes() {
		return notes;
	}
	
	@Column(name="notes" , nullable = true)
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	@Column(name="rating" , nullable = true)
	public Float getRating() {
		if (this.rating != null)
			return rating.floatValue();
		else
			return (float) 0;
	}
	
	@Column(name="rating" )
	public void setRating(Float rating) {
		this.rating = rating;
	}
	
	@Column(name="num_votes")	
	public Integer getNum_votes() {
		if(num_votes != null)
			return num_votes.intValue();
		else
			return 0;
	}
	
	@Column(name="num_votes" , nullable= true)
	public void setNum_votes(Integer num_votes) {
		this.num_votes = num_votes;
	}
	
	@Column(name="distribution" , nullable = true)
	public String getDistribution() {
		return distribution;
	}
	
	@Column(name="distribution" , nullable = true)
	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}
	
	@Column(name="year_suffix")
	public String getYear_suffix() {
		return year_suffix;
	}
	
	@Column(name="year_suffix" , nullable = true)
	public void setYear_suffix(String year_suffix) {
		this.year_suffix = year_suffix;
	}
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy="movies")	
	public Set<Actors> getActors() {
		return  this.actors;
	}
 
	public void setActors(Set<Actors> actors) {
		this.actors = actors;
	}
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy="movies")
		public Set<Language> getLanguages() {
		return  this.languages;
	}
 
	public void setLanguages(Set<Language> languages) {
		this.languages = languages;
	}
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy="movies")
	public Set<Genres> getGenres() {
	return  this.genres;
	}

	public void setGenres(Set<Genres> genres) {
	this.genres = genres;
	}

	
	
}
