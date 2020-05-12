package logic.model;

import java.util.Vector;

public class Hotel {
	
	private String name;
	private String owner; // questo deve essere un riferimento a istanza di classe utente proprietario
	private String type;
	private String city;
	private String address;
	private int rating;
	private Vector<Room> vRoom;  // la classe hotel aggrega istanze della classe room
	private Agenda agenda;  // riferimento all'istanza della classe agenda che contien le prenotazioni
	// attributi check box
	private boolean parking;
	private boolean restaurant;
	private boolean roomService;
	private boolean gym;
	
	public Hotel(String name) {
		//costruttore che uso per popolare istanza con dati su DB(gli passo il nome e trmaite quelo ricerca su DB)
		
		/* chiamata al DAO per verificare se esiste
		 se esiste vado a popolare gli attributi con i dati su DB e creao la mia istanza
		 altrimenti non creo l'istanza */
		
		//this.name = name;
		//this.agenda = new Agenda(this.name);
	}
										// manca parametro owner prima bisogna creare la classe adatta
	public Hotel(String name, String type ,String city ,String address, int rating, Agenda agenda, boolean parking, boolean restaurant, boolean roomService, boolean gym) {
		// costruttore che uso quando creo una NUOVA istanza(per la prima volta)
		this.name = name;
		this.type = type;
		this.city = city;
		//this.owner ...
		this.address = address;
		this.rating = rating;
		this.agenda = new Agenda(this.name);
		this.parking = parking;
		this.restaurant = restaurant;
		this.roomService = roomService;
		this.gym = gym;
		//this.vRoom ...
		
		//poi dovrò salvarla su Db
	}
		
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
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Agenda getAgenda() {
		return agenda;
	}
	
	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public boolean isRestaurant() {
		return restaurant;
	}

	public void setRestaurant(boolean restaurant) {
		this.restaurant = restaurant;
	}

	public boolean isRoomService() {
		return roomService;
	}

	public void setRoomService(boolean roomService) {
		this.roomService = roomService;
	}

	public boolean isGym() {
		return gym;
	}

	public void setGym(boolean gym) {
		this.gym = gym;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Vector<Room> getvRoom() {
		return vRoom;
	}
	public void setvRoom(Vector<Room> vRoom) {
		this.vRoom = vRoom;
	}
}
