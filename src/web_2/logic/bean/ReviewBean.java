package web_2.logic.bean;

import java.util.ArrayList;

import web_2.logic.model.Review;

public class ReviewBean {
	
	private ArrayList<Review> reviewList;
	private int index;
	
	public ReviewBean() {
		this.reviewList = new ArrayList<Review>();
	}

	public ArrayList<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(ArrayList<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
