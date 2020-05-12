package logic.bean;

public class EventBean {
	
	private String name;
	
	private String city;
	
	private int people;
	
	private int Day;
	private int Month;
	private int Year;
	
	private int hour;
	
	private boolean concert = false;
	private boolean theatre = false;
	private boolean cinema = false;
	private boolean museum = false;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getPeople() {
		return people;
	}
	
	public void setPeople(int people) {
		this.people = people;
	}
	
	public int getDay() {
		return Day;
	}
	
	public void setDay(int day) {
		Day = day;
	}
	
	public int getMonth() {
		return Month;
	}
	
	public void setMonth(int month) {
		Month = month;
	}
	
	public int getYear() {
		return Year;
	}
	
	public void setYear(int year) {
		Year = year;
	}
	
	public int getHour() {
		return hour;
	}
	
	public void setHour(int hour) {
		this.hour = hour;
	}
	
	public boolean isConcert() {
		return concert;
	}
	
	public void setConcert(boolean concert) {
		this.concert = concert;
	}
	
	public boolean isTheatre() {
		return theatre;
	}
	
	public void setTheatre(boolean theatre) {
		this.theatre = theatre;
	}
	
	public boolean isCinema() {
		return cinema;
	}
	
	public void setCinema(boolean cinema) {
		this.cinema = cinema;
	}
	
	public boolean isMuseum() {
		return museum;
	}
	
	public void setMuseum(boolean museum) {
		this.museum = museum;
	}	
}