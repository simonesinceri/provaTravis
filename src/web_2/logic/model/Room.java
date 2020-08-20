package web_2.logic.model;

public class Room {
	
	private int roomId;
	private int price;
	private int beds;
	
	public Room() {
		/* iserisco un cotruttore di default 
		 * nell'evantualità si vuole costruire 
		 * un'istanza senza passaggio di parametri iniziale
		 */
	}
	
	public Room(int roomId) {
		/*chiamata al DAO con ID, mi cerca la room se la trovo costruisco
		 * l'istanza altrimenti no 
		 */
	}
	
	public Room(int roomId, int beds, int price) {
		this.roomId = roomId;
		this.beds = beds;
		this.price = price;
	}
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBeds() {
		return beds;
	}
	public void setBeds(int beds) {
		this.beds = beds;
	}
}
