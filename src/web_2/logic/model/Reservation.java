package web_2.logic.model;

public class Reservation {
	
	private int id;
	private int date;
	private String userBooked;
	
	public Reservation() {
		/* iserisco un cotruttore di default 
		 * nell'evantualità si vuole costruire 
		 * un'istanza senza passaggio di parametri iniziale
		 */
	}
	
	public Reservation(int reservationId, int date, String userBooked) {  //costruzione NUOVA istanza di prenotazione
		this.id = reservationId;
		this.date = date;
		this.userBooked = userBooked;
	}
	
	public Reservation(int reservationId) {
		// chiamata al DAO per recuperare info e ricostruire istanza registrata su DB
	}
	
	public int getReservationId() {
		return id;
	}
	public void setReservationId(int reservationId) {
		this.id = reservationId;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public String getUserBooked() {
		return userBooked;
	}
	public void setUserBooked(String userBooked) {
		this.userBooked = userBooked;
	}
}
