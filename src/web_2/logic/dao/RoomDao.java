package web_2.logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import web_2.logic.model.Room;

public class RoomDao {
	private static String name = "progettoFindit";
    private static String pass = "passwfindit2020";
    private static String url = "jdbc:mysql://localhost:3306/findit?useTimezone=true&serverTimezone=UTC";
    private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    
    /*
    public static void main(String[] args) {
    	Room room = new Room();
    	try {
    		
			setRoom("TorVergataRooms",4,4,40);
			
    		room = getRoom("TorVergataRooms",4,50);
    		
			System.out.println("ID: " + room.getRoomId());
			
			
		} catch (Exception e) {
	        System.out.println("# DB error! #");
	        System.out.println(e);
		}
    }
	*/
    
    public static Room getRoom(String roomsTable, int id) throws Exception{

    	String bedsQuery = "select beds from " + roomsTable + " where id = '" + id + "'";
    	String priceQuery = "select price from " + roomsTable + " where id = '" + id + "'";

    	Room room = new Room();
    	
    	Connection con = null;
		Statement st = null;
		
    	try {
    		Class.forName(DRIVER_CLASS_NAME);
    		try{
				con = DriverManager.getConnection(url,name,pass);
			} catch(SQLException e){
		        System.out.println("Couldn't connect: exit.");
		        System.exit(1);
		        }
			
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                ResultSet.CONCUR_READ_ONLY);
		
			room.setRoomId(id);
			
			ResultSet rs = st.executeQuery(bedsQuery);
			int roomBeds = rs.getInt("beds");
			room.setBeds(roomBeds);		
			rs.close();
			
			ResultSet rs1 = st.executeQuery(priceQuery);
			int rightPrice = rs.getInt("price");
			room.setRoomId(rightPrice);
			rs1.close();
    
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
    	
		return room;
    }
	
    public static boolean setRoom(String roomsTable, int id, int beds, int price) throws Exception{		

    	String searchQuery = "select id from " + roomsTable + " where id = '" + id + "'";
        
    	Connection con = null;
		Statement st = null;
		
    	try {
    		Class.forName(DRIVER_CLASS_NAME);
    		try{
				con = DriverManager.getConnection(url,name,pass);
			} catch(SQLException e){
		        System.out.println("Couldn't connect: exit.");
		        System.exit(1);
		        }
			
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                ResultSet.CONCUR_READ_ONLY);
		
			ResultSet rs = st.executeQuery(searchQuery);
		
			//rs.next();
			
			if (!rs.first()) {

				rs.close();

				String insertQuery = "insert into " + roomsTable + " value ('" + id + "','" + price + "','" + beds + "')";
				    	
				st.executeUpdate(insertQuery);
				
				return true;
				
			} else {
				
				return false;
				
			}
			
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
    }
    
    public static Room searchRoom(String roomsTable, int beds, int price, int index) throws Exception{

    	String searchQuery = "select * from " + roomsTable + " where beds >= '" + beds + "' and price <= '" + price + "' order by price";
    	String idQuery = "select id from " + roomsTable + " where beds >= '" + beds + "' and price <= '" + price + "' order by price";
    	
    	Room room = new Room();
    	
    	Connection con = null;
		Statement st = null;
		
    	try {
    		Class.forName(DRIVER_CLASS_NAME);
    		try{
				con = DriverManager.getConnection(url,name,pass);
			} catch(SQLException e){
		        System.out.println("Couldn't connect: exit.");
		        System.exit(1);
		        }
			
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                ResultSet.CONCUR_READ_ONLY);
		
			ResultSet rs = st.executeQuery(searchQuery);
		
			rs.next();
			
			if (!rs.first()) {
				return room;
			}
			
			rs.close();
			
			ResultSet rs1 = st.executeQuery(idQuery);
			rs1.next();
			
			for (int i=1; i<index; i++) {
		        if (!rs1.next()) {
			        System.out.println("prova");
			        return room;
				}
			}

			int roomId = rs1.getInt("id");
			room.setRoomId(roomId);
			rs1.close();
			
	    	String bedQuery = "select beds from " + roomsTable + " where id = '" + roomId + "'";
	    	
	    	ResultSet rs3 = st.executeQuery(bedQuery);
			rs3.next();
			int bed = rs3.getInt("beds");
			room.setBeds(bed);
			rs3.close();
			
	    	String priceQuery = "select price from " + roomsTable + " where id = '" + roomId + "'";
	    	
	    	ResultSet rs2 = st.executeQuery(priceQuery);
			rs2.next();
			int roomPrice = rs2.getInt("price");
			room.setPrice(roomPrice);
			rs2.close();
    
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
    	
		return room;
    }
    
    public static int getRoomsNumber(String roomsTable) throws Exception {
    	
    	String numQuery = "select count(*) from " + roomsTable;
		
		Connection con = null;
		Statement st = null;
		
    	try {
    		Class.forName(DRIVER_CLASS_NAME);
    		try{
				con = DriverManager.getConnection(url,name,pass);
			} catch(SQLException e){
		        System.out.println("Couldn't connect: exit.");
		        System.exit(1);
		        }
			
			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	                ResultSet.CONCUR_READ_ONLY);
				    	
			ResultSet rs = st.executeQuery(numQuery);
			rs.next();
			int i = rs.getInt("count(*)");
			rs.close();
			
			return i;
			
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
    }
}
