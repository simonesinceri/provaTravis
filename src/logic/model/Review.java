package logic.model;

import java.sql.Date;

public class Review {
	
	private int numStars;
	private Date dateReview; // l'abbiamo già usata questo date??
	private String textReview;
	private String nomeUser;
	//private User user;

	public Review(int numStars, Date dateReview, String textReview, String nomeUser) {
		this.numStars = numStars;
		this.dateReview = dateReview;
		this.textReview = textReview;
		this.nomeUser = nomeUser;
	}
	
	public int getNumStars() {
		return numStars;
	}
	public void setNumStars(int numStars) {
		this.numStars = numStars;
	}
	public Date getDateReview() {
		return dateReview;
	}
	public void setDateReview(Date dateReview) {
		this.dateReview = dateReview;
	}
	public String getTextReview() {
		return textReview;
	}
	public void setTextReview(String textReview) {
		this.textReview = textReview;
	}
	public String getNomeUser() {
		return nomeUser;
	}
	public void setNomeUser(String nomeUser) {
		this.nomeUser = nomeUser;
	}
	
	//public saveReview()  forse questo va nel DAO
	
	
}
