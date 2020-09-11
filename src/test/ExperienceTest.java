package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import logic.dao.ExperienceDao;
import logic.model.Experience;

/*
 * Author: Pierpaolo Spaziani
 */

public class ExperienceTest {

	@Test
	void testGetExperienceCasaMia() {
		
		String reviewsTable = "PierpaoloReview";
		int index = 1;
		String structure = "Hotel Virgilio";
		
		Experience experience = ExperienceDao.getExperience(reviewsTable, index);
		
		assertEquals(structure, experience.getName());
	}

	@Test
	void testSetExperienceCasaMia() {
		
		String reviewsTable = "PierpaoloReview";
		int dayIn = 20201223;
		int dayOut = 20201225;
		String structure = "Hotel Virgilio";
		int index = 10;
		
		ExperienceDao.setExperienceRow(reviewsTable, structure, dayIn, dayOut);
		
		Experience experience = ExperienceDao.getExperience(reviewsTable, index);

		assertEquals(null, experience.getReview());
	}
}
