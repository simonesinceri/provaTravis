package logic.model;

public class Review {
	
	private String reviewUser;
	private String reviewText;
	private int reviewVote;

	public String getReviewUser() {
		return reviewUser;
	}
	
	public void setReviewUser(String user) {
		this.reviewUser = user;
	}
	
	public String getReviewText() {
		return reviewText;
	}
	
	public void setReviewText(String review) {
		this.reviewText = review;
	}
	
	public int getReviewVote() {
		return reviewVote;
	}
	
	public void setReviewVote(int vote) {
		this.reviewVote = vote;
	}
}
