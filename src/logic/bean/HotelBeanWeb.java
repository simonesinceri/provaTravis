package logic.bean;

import logic.model.Hotel;
import logic.model.Room;

public class HotelBeanWeb extends HotelBean{

	
	//parametri di ritorno per parte web
	private Hotel hotel1;
	private Hotel hotel2;
	private Hotel hotel3;
	
	private Room room1;
	private Room room2;
	private Room room3;
	
	private int page;
	
	private Hotel bookHotel;
	private Room bookRoom;
	
	
	public Hotel getHotel1() {
		return hotel1;
	}

	public void setHotel1(Hotel hotel1) {
		this.hotel1 = hotel1;
	}

	public Room getRoom1() {
		return room1;
	}

	public void setRoom1(Room room1) {
		this.room1 = room1;
	}

	public Hotel getHotel2() {
		return hotel2;
	}

	public void setHotel2(Hotel hotel2) {
		this.hotel2 = hotel2;
	}

	public Room getRoom2() {
		return room2;
	}

	public void setRoom2(Room room2) {
		this.room2 = room2;
	}

	public Hotel getHotel3() {
		return hotel3;
	}

	public void setHotel3(Hotel hotel3) {
		this.hotel3 = hotel3;
	}

	public Room getRoom3() {
		return room3;
	}

	public void setRoom3(Room room3) {
		this.room3 = room3;
	}

	public Hotel getBookHotel() {
		return bookHotel;
	}

	public void setBookHotel(Hotel bookHotel) {
		this.bookHotel = bookHotel;
	}

	public Room getBookRoom() {
		return bookRoom;
	}

	public void setBookRoom(Room bookRoom) {
		this.bookRoom = bookRoom;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
