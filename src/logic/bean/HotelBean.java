package logic.bean;

import java.time.LocalDate;

public class HotelBean {
	
	protected String name;
	protected String address;
	protected String city;

	protected int days;
	protected LocalDate localDateIn;
	protected LocalDate localDateOut;

	protected int numPeople;
	
	protected boolean budget1 = false;
	protected boolean budget2 = false;
	protected boolean budget3 = false;
	protected boolean budget4 = false;

	protected boolean apartment = false;
	protected boolean hotel = false;
	protected boolean beb = false;
	protected boolean hostel = false;
	
	protected String type;

	protected boolean parking = false;
	protected boolean restaurant = false;
	protected boolean roomService = false;
	protected boolean gym = false;
	
	protected boolean star1 = false;
	protected boolean star2 = false;
	protected boolean star3 = false;
	protected boolean star4 = false;
	protected boolean star5 = false;
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	public int getNumPeople() {
		return numPeople;
	}
	
	public void setNumPeople(int numPeople) {
		this.numPeople = numPeople;
	}
	
	public boolean isBudget1() {
		return budget1;
	}

	public void setBudget1(boolean budget1) {
		this.budget1 = budget1;
	}

	public boolean isBudget2() {
		return budget2;
	}

	public void setBudget2(boolean budget2) {
		this.budget2 = budget2;
	}

	public boolean isBudget3() {
		return budget3;
	}

	public void setBudget3(boolean budget3) {
		this.budget3 = budget3;
	}

	public boolean isBudget4() {
		return budget4;
	}

	public void setBudget4(boolean budget4) {
		this.budget4 = budget4;
	}

	public boolean isApartment() {
		return apartment;
	}

	public void setApartment(boolean apartment) {
		this.apartment = apartment;
	}

	public boolean isHotel() {
		return hotel;
	}

	public void setHotel(boolean hotel) {
		this.hotel = hotel;
	}

	public boolean isBeb() {
		return beb;
	}

	public void setBeb(boolean beb) {
		this.beb = beb;
	}

	public boolean isHostel() {
		return hostel;
	}

	public void setHostel(boolean hostel) {
		this.hostel = hostel;
	}
	
	public boolean getParking() {
		return parking;
	}
	
	public void setParking(boolean parking) {
		this.parking = parking;
	}
	
	public boolean getRestaurant() {
		return restaurant;
	}
	
	public void setRestaurant(boolean restaurant) {
		this.restaurant = restaurant;
	}
	
	public boolean getRoomService() {
		return roomService;
	}
	
	public void setRoomService(boolean roomService) {
		this.roomService = roomService;
	}
	
	public boolean getGym() {
		return gym;
	}
	
	public void setGym(boolean gym) {
		this.gym = gym;
	}

	public boolean getStar1() {
		return star1;
	}

	public void setStar1(boolean star1) {
		this.star1 = star1;
	}

	public boolean getStar2() {
		return star2;
	}

	public void setStar2(boolean star2) {
		this.star2 = star2;
	}

	public boolean getStar3() {
		return star3;
	}

	public void setStar3(boolean star3) {
		this.star3 = star3;
	}

	public boolean getStar4() {
		return star4;
	}

	public void setStar4(boolean star4) {
		this.star4 = star4;
	}

	public boolean getStar5() {
		return star5;
	}

	public void setStar5(boolean star5) {
		this.star5 = star5;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}	
	
	public LocalDate getLocalDateIn() {
		return localDateIn;
	}

	public void setLocalDateIn(LocalDate localDateIn) {
		this.localDateIn = localDateIn;
	}

	public LocalDate getLocalDateOut() {
		return localDateOut;
	}

	public void setLocalDateOut(LocalDate localDateOut) {
		this.localDateOut = localDateOut;
	}
	
	public String getType() {
		setType();
		return type;
	}

	public void setType() {
		if (isApartment()) {
			type = "apartment";
		} else if (isBeb()) {
			type = "beb";
		} else if (isHostel()) {
			type = "hostel";
		} else if (isHotel()) {
			type = "hotel";
		} else {
			type = null;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
