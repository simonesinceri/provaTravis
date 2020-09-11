package test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import logic.dao.HotelDao;
import logic.dao.ReservationDao;
import logic.model.Hotel;
import logic.model.Reservation;

/*
 * Author: Pierpaolo Spaziani
 */

public class ReservationTest {

	@Test
	void testGetReservationCasaMia() {
		
		Hotel hotel = HotelDao.getHotel("Hotel Virgilio");
		String agenda = hotel.getHotelAgenda();
		int date = 20201021;
		int id = 1;
		String user = "Pierpaolo";
		
		Reservation reservation = ReservationDao.getReservation(agenda, id, date);
		
		assertEquals(user, reservation.getUserBooked());
	}

	@Test
	void testSetReservationInCasaMia() {
		
		Hotel hotel = HotelDao.getHotel("Hotel Virgilio");
		String agenda = hotel.getHotelAgenda();
		int id = 1;
		int date = 20201021;
		String user = "Francesco";
		
		ReservationDao.setReservation(agenda, id, date, user);
		
		Reservation reservation = ReservationDao.getReservation(agenda, id, date);
		
		assertNotEquals(user, reservation.getUserBooked());
	}
}
