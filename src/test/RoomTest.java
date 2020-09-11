package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import logic.dao.HotelDao;
import logic.dao.RoomDao;
import logic.model.Hotel;
import logic.model.Room;

/*
 * Author: Pierpaolo Spaziani
 */

public class RoomTest {
	
	String hotelName = "Hotel Virgilio";

	@Test
	void testGetRoomCasaMia() {
		
		Hotel hotel = HotelDao.getHotel(hotelName);
		String roomsTable = hotel.getHotelRooms();
		int id = 1;
		int beds = 10;
		int price = 45;
		
		Room room = RoomDao.getRoom(roomsTable, id);
		
		assertEquals(price, room.getPrice());
		assertNotEquals(beds, room.getBeds());
	}

	@Test
	void testSetRoomCasaMia() {
		
		Hotel hotel = HotelDao.getHotel(hotelName);
		String roomsTable = hotel.getHotelRooms();
		int id = 1;
		int beds = 3;
		int price = 50;
		
		RoomDao.setRoom(roomsTable, id, beds, price);
		
		Room room = RoomDao.getRoom(roomsTable, id);

		assertNotEquals(price, room.getPrice());
	}
	
	@Test
	void testGetRoomsNumberCasaMia() {
		
		Hotel hotel = HotelDao.getHotel(hotelName);
		String roomsTable = hotel.getHotelRooms();
		int roomsNumber = 10;
		
		int number = RoomDao.getRoomsNumber(roomsTable);
		
		assertNotEquals(roomsNumber, number);
	}
}
