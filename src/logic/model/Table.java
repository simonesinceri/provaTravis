package logic.model;

public class Table {
	
	private int tableId;
	private int seats;
	
	public Table(int tableId, int seats) {
		this.tableId = tableId;
		this.seats = seats;
	}
	
	public Table(int tableId) {
		// chiamta al DAO che mi restituisce l'istanza se c'è
	}
	
	public Table() {
		// non so se mi servirà costruttore di default
	}
	
	public int getTableId() {
		return tableId;
	}
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public int getSeats() {
		return seats;
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	
	

}
