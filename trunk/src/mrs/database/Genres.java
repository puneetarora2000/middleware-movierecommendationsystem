package mrs.database;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="genre")
public class Genres implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int gid;
	private String genre;	
	private Set<Movies> movies = new HashSet<Movies>(0);
	
	
	@Id
	@Column(name="gid")
	public int getGid() {
		return gid;
	}
	
	@Id
	@Column(name="gid")
	public void setGid(int gid) {
		this.gid = gid;
	}
	
	@Column(name="genre")
	public String getGenre() {
		return genre;
	}
	
	@Column(name="genre")
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@ManyToMany()
	public Set<Movies> getMovies() {
		return this.movies;
	}
 
	public void setMovies(Set<Movies> movies) {
		this.movies = movies;
	}
	

	
}
