package logic.model;

import javafx.scene.image.Image;

public class Hotel {
	
	private String hotelName;
	private String hotelOwner;
	private String hotelType;
	private String hotelCity;
	private String hotelAddress;
	private int hotelRating;
	private boolean hotelParking;
	private boolean hotelRestaurant;
	private boolean hotelRoomService;
	private boolean hotelGym;
	
	private String hotelRooms;
	private String hotelAgenda;
	private String hotelReviews;
	
	private Image image;
	
	private String description;

	
	public String getHotelName() {
		return hotelName;
	}
	
	public void setHotelName(String name) {
		this.hotelName = name;
	}
	
	public String getHotelOwner() {
		return hotelOwner;
	}
	
	public void setHotelOwner(String owner) {
		this.hotelOwner = owner;
	}
	
	public String getHotelType() {
		return hotelType;
	}
	
	public void setHotelType(String type) {
		this.hotelType = type;
	}
	
	public String getHotelCity() {
		return hotelCity;
	}
	
	public void setHotelCity(String city) {
		this.hotelCity = city;
	}
	
	public String getHotelAddress() {
		return hotelAddress;
	}
	
	public void setHotelAddress(String address) {
		this.hotelAddress = address;
	}
	
	public boolean isHotelParking() {
		return hotelParking;
	}

	public void setHotelParking(boolean parking) {
		this.hotelParking = parking;
	}

	public boolean isHotelRestaurant() {
		return hotelRestaurant;
	}

	public void setHotelRestaurant(boolean restaurant) {
		this.hotelRestaurant = restaurant;
	}

	public boolean isHotelRoomService() {
		return hotelRoomService;
	}

	public void setHotelRoomService(boolean roomService) {
		this.hotelRoomService = roomService;
	}

	public boolean isHotelGym() {
		return hotelGym;
	}

	public void setHotelGym(boolean gym) {
		this.hotelGym = gym;
	}
	
	public int getHotelRating() {
		return hotelRating;
	}
	public void setHotelRating(int rating) {
		this.hotelRating = rating;
	}

	public String getHotelRooms() {
		return hotelRooms;
	}

	public void setHotelRooms(String rooms) {
		this.hotelRooms = rooms;
	}

	public String getHotelAgenda() {
		return hotelAgenda;
	}

	public void setHotelAgenda(String agenda) {
		this.hotelAgenda = agenda;
	}

	public String getHotelReviews() {
		return hotelReviews;
	}

	public void setHotelReviews(String reviews) {
		this.hotelReviews = reviews;
	}

	public Image getHotelImage() {
		return image;
	}

	public void setHotelImage(Image image) {
		this.image = image;
	}

	public String getHotelDescription() {
		return description;
	}

	public void setHotelDescription(String description) {
		this.description = description;
	}	
}
