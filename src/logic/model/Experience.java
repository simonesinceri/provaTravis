package logic.model;

import javafx.scene.image.Image;

public class Experience {

	private String name;
	private int dayIn;
	private int dayOut;
	private Image image;
	private String review;
	private int rating;

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getDayIn() {
		return dayIn;
	}
	
	public void setDayIn(int dayIn) {
		this.dayIn = dayIn;
	}
	
	public int getDayOut() {
		return dayOut;
	}
	
	public void setDayOut(int dayOut) {
		this.dayOut = dayOut;
	}
	
	public Image getImage() {
		return image;
	}
	
	public void setImage(Image image) {
		this.image = image;
	}
	
	public String getReview() {
		return review;
	}
	
	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
}
