package logic.model;

public class Event {

	private String name;
	private String owner;  // questo deve essere un riferimento a istanza di classe utente proprietario
	private String type;
	private String city;
	private int hour;
	private String address;
	private int maxPeople;
	private double price;
	private int seatAvaiables;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getHour() {
		return hour;
	}
	
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getMaxPeople() {
		return maxPeople;
	}
	
	public void setMaxPeople(int maxPeople) {
		this.maxPeople = maxPeople;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getSeatAvaiables() {
		return seatAvaiables;
	}
	
	public void setSeatAvaiables(int seatAvaiables) {
		this.seatAvaiables = seatAvaiables;
	}
}
	
