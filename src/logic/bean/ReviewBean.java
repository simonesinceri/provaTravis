package logic.bean;

import java.util.ArrayList;
import java.util.List;

import logic.model.Review;

public class ReviewBean {
	
	private List<Review> reviewList;
	private int index;
	
	public ReviewBean() {
		this.reviewList = new ArrayList<>();
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
