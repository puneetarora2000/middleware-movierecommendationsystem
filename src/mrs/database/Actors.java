package mrs.database;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="actor")
public class Actors implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lname;
	private String fname;
	private int aid;
	private String fullname;
	private String gender;
	private Set<Movies> movies = new HashSet<Movies>(0);
	
	@Id  
    @Column(name="aid") 
	public int getAid() {
		return aid;
	}
	
	@Id  
    @Column(name="aid")
	public void setAid( int aid) {
		this.aid = aid;
	}
	
	@Column(name="lname")
	public String getLname() {
		return lname;
	}
	
	@Column(name="lname")
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	@Column(name="fname")
	public String getFname() {
		return fname;
	}
	
	@Column(name="fname")
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	@Column(name="fullname")
	public String getFullname() {
		return fullname;
	}
	
	@Column(name="fullname")
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
	@Column(name="gender")
	public String getGender() {
		return gender;
	}
	
	@Column(name="gender")
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@ManyToMany(fetch = FetchType.EAGER)
	public Set<Movies> getMovies() {
		return this.movies;
	}
 
	public void setMovies(Set<Movies> movies) {
		this.movies = movies;
	}
 
	
}


