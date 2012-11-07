package mrs.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cast_movie")

public class Cast_movie {

	private int aid;
	private int mid;
	private String role;
	private String notes;
	private int credit_no;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getCredit_no() {
		return credit_no;
	}
	public void setCredit_no(int credit_no) {
		this.credit_no = credit_no;
	}
	
	
}
