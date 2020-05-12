package logic.model;

public class Reservation {
	
	private int reservationId;
	private int date;             // l'idea era di avere una signola istanza di prenotazione per ogni giorno
	private User userBooked;      // inserite singolarmente su DB , anche se la prenotazione era per più giorni
	
	public Reservation(int reservationId, int date, User userBooked) {  //costruzione NUOVA istanza di prenotazione
		this.reservationId = reservationId;
		this.date = date;
		this.userBooked = userBooked;
	}
	
	public Reservation(int reservationId) {
		// chiamata al DAO per recuperare info e ricostruire istanza registrata su DB
	}
	
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public User getUserBooked() {
		return userBooked;
	}
	public void setUserBooked(User userBooked) {
		this.userBooked = userBooked;
	}
								  
	
	

}
