package mrs.database;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="language")
public class Language {
	private int lid;
	private String language;
	private String language_notes;
	private Set<Movies> movies = new HashSet<Movies>(0);
	
	
	@Id
	@Column(name="lid")
	public int getLid() {
		return lid;
	}
	
	@Id
	@Column(name="lid")
	public void setLid(int lid) {
		this.lid = lid;
	}
	
	@Column(name="language")
	public String getLanguage() {
		return language;
	}
	
	@Column(name="language")
	public void setLanguage(String language) {
		this.language = language;
	}
	
	@Column(name="language_notes")
	public String getLanguage_notes() {
		return language_notes;
	}
	
	@Column(name="language_notes" ,nullable = true)
	public void setLanguage_notes(String language_notes) {
		this.language_notes = language_notes;
	}
	

	@ManyToMany()
	public Set<Movies> getMovies() {
		return this.movies;
	}
 
	public void setMovies(Set<Movies> movies) {
		this.movies = movies;
	}
	
}
