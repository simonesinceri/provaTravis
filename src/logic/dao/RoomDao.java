package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import logic.model.Room;

public class RoomDao {
	private static String name = "progettoFindit";
    private static String pass = "passwfindit2020";
    private static String url = "jdbc:mysql://localhost:3306/findit?useTimezone=true&serverTimezone=UTC";
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    static String whereId = " where id = '";
    
    private RoomDao() {
    	
    }
    
    public static Room getRoom(String roomsTable, int id){

    	Room room = new Room();
    	
    	Connection roomConn = null;
		Statement roomSt = null;
		
    	try {
        	try{
            	Class.forName(driverClassName);
    			roomConn = DriverManager.getConnection(url,name,pass);
    			
    			roomSt = roomConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);

    	    	String bedsQuery = "select beds from " + roomsTable + whereId + id + "'";
    	    	String priceQuery = "select price from " + roomsTable + whereId + id + "'";

    			room.setRoomId(id);
    			
    			ResultSet rs = roomSt.executeQuery(bedsQuery);
    			rs.next();
    			int roomBeds = rs.getInt("beds");
    			room.setBeds(roomBeds);		
    			rs.close();
    			
    			ResultSet rs1 = roomSt.executeQuery(priceQuery);
    			rs1.next();
    			int rightPrice = rs1.getInt("price");
    			room.setPrice(rightPrice);
    			rs1.close();
        
        	} finally {
        		
        		if (roomSt != null) {
        			roomSt.close();
        		}
        		
        		if (roomConn != null) {
        			roomConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	        }

		return room;
    }
	
    public static boolean setRoom(String roomsTable, int id, int beds, int price){
        
    	Connection roomConn = null;
		Statement roomSt = null;
		boolean result = false;
		
    	try {
        	try{
            	Class.forName(driverClassName);
    			roomConn = DriverManager.getConnection(url,name,pass);
    			
    			roomSt = roomConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);

    	    	String searchQuery = "select id from " + roomsTable + whereId + id + "'";
    		
    			ResultSet rs = roomSt.executeQuery(searchQuery);
    			
    			if (!rs.first()) {

    				rs.close();

    				String insertQuery = "insert into " + roomsTable + " value ('" + id + "','" + price + "','" + beds + "')";
    				    	
    				roomSt.executeUpdate(insertQuery);
    				
    				result = true;
    			}
    			
        	} finally {
        		
        		if (roomSt != null) {
        			roomSt.close();
        		}
        		
        		if (roomConn != null) {
        			roomConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
    	return result;
    }
    
    public static Room searchRoom(String roomsTable, int beds, int price, int index){
    	
    	Room room = new Room();
    	
    	Connection roomConn = null;
		Statement roomSt = null;
		
    	try {
        	try{
            	Class.forName(driverClassName);
    			roomConn = DriverManager.getConnection(url,name,pass);
    			
    			roomSt = roomConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);

    	    	String searchQuery = "select * from " + roomsTable + " where beds >= '" + beds + "' and price <= '" + price + "' order by price";
    	    	String idQuery = "select id from " + roomsTable + " where beds >= '" + beds + "' and price <= '" + price + "' order by price";
    		
    			ResultSet rs = roomSt.executeQuery(searchQuery);
    		
    			rs.next();
    			
    			if (!rs.first()) {
    				return room;
    			}
    			
    			rs.close();
    			
    			ResultSet rs1 = roomSt.executeQuery(idQuery);
    			rs1.next();
    			
    			for (int i=1; i<index; i++) {
    		        if (!rs1.next()) {
    			        return room;
    				}
    			}

    			int roomId = rs1.getInt("id");
    			room.setRoomId(roomId);
    			rs1.close();
    			
    	    	String bedQuery = "select beds from " + roomsTable + whereId + roomId + "'";
    	    	
    	    	ResultSet rs3 = roomSt.executeQuery(bedQuery);
    			rs3.next();
    			int bed = rs3.getInt("beds");
    			room.setBeds(bed);
    			rs3.close();
    			
    	    	String priceQuery = "select price from " + roomsTable + whereId + roomId + "'";
    	    	
    	    	ResultSet rs2 = roomSt.executeQuery(priceQuery);
    			rs2.next();
    			int roomPrice = rs2.getInt("price");
    			room.setPrice(roomPrice);
    			rs2.close();
        
        	} finally {
        		
        		if (roomSt != null) {
        			roomSt.close();
        		}
        		
        		if (roomConn != null) {
        			roomConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	        }
    	
		return room;
    }
    
    public static int getRoomsNumber(String roomsTable){
		
		Connection roomConn = null;
		Statement roomSt = null;
		
    	int i = 0;
		try {
        	try{
            	Class.forName(driverClassName);
    			roomConn = DriverManager.getConnection(url,name,pass);
    			
    			roomSt = roomConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);
    	    	
    	    	String numQuery = "select count(*) from " + roomsTable;
    				    	
    			ResultSet rs = roomSt.executeQuery(numQuery);
    			rs.next();
    			i = rs.getInt("count(*)");
    			rs.close();
    			
        	} finally {
        		
        		if (roomSt != null) {
        			roomSt.close();
        		}
        		
        		if (roomConn != null) {
        			roomConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
		
		return i;
    }
}
