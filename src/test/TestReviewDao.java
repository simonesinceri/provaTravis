/*
 * Autore: Simone Sinceri
 * */

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.dao.HotelDao;
import logic.dao.ReviewDao;
import logic.exceptions.ExceptionSearchReview;
import logic.model.Hotel;
import logic.model.Review;

class TestReviewDao {


	
	@Test
	void testGetReviewByHotelVirgilio() {
		
		Hotel hotel = HotelDao.getHotel("Hotel Virgilio");
		String table = hotel.getHotelReviews();
		
		Review review;
		try {
			review = ReviewDao.getReview(table, 1);
			assertNotEquals("",review.getReviewText());
		} catch (ExceptionSearchReview e) {
			e.printStackTrace();
		}
	}
	

	
	@Test
	void testSetReviewNewReview() {
		
		String review = "Esperieza piacevole, staff gentile e professionale";
		int stars = 4;
		String user = "simone";
		
		String table = (HotelDao.getHotel("Hotel Adventure")).getHotelReviews();
		
		int avg = ReviewDao.setReview(review, stars, user, table);
		
		assertEquals(stars, avg);
		
	}
		

}
