package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import logic.model.Reservation;

public class ReservationDao {
	private static String name = "progettoFindit";
    private static String pass = "passwfindit2020";
    private static String url = "jdbc:mysql://localhost:3306/findit?useTimezone=true&serverTimezone=UTC";
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    static String whereId = " where id = '";
    static String andDate = "' and date = '";
    
    
    private ReservationDao() {
    	
    }
    
    public static Reservation getReservation(String reservationTable, int id, int date){

    	String idQuery = "select id from " + reservationTable + whereId + id + andDate + date + "'";
    	String userQuery = "select user from " + reservationTable + whereId + id + andDate + date + "'";
    	
    	Reservation reservation = new Reservation();
    	
    	Connection reservationConn = null;
		Statement reservationSt = null;
		
    	try {
        	try {
            	Class.forName(driverClassName);
    			reservationConn = DriverManager.getConnection(url,name,pass);
    			
    			reservationSt = reservationConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);
    		
    			ResultSet rs = reservationSt.executeQuery(idQuery);
    		
    			rs.next();
    			
    			if (!rs.first()) {
    				return reservation;
    			}
    			
    			int reservationID = rs.getInt("id");
    			reservation.setReservationId(reservationID);
    			rs.close();
    			
    			reservation.setDate(date);
    			
    			ResultSet rs2 = reservationSt.executeQuery(userQuery);
    			rs2.next();
    			String user = rs2.getNString("user");
    			reservation.setUserBooked(user);
    			rs2.close();
    			
        
        	} finally {
        		
        		if (reservationSt != null) {
        			reservationSt.close();
        		}
        		
        		if (reservationConn != null) {
        			reservationConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
    	
		return reservation;
    }
	
    public static void setReservation(String reservationTable, int id, int date, String user){
        
    	Connection reservationConn = null;
		Statement reservationSt = null;
		
    	try {
        	try {
            	Class.forName(driverClassName);
    			reservationConn = DriverManager.getConnection(url,name,pass);
    			
    			reservationSt = reservationConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);

    	    	String searchQuery = "select id from " + reservationTable + whereId + id + andDate + date + "'";
    		
    			ResultSet rs = reservationSt.executeQuery(searchQuery);
    			
    			if (!rs.first()) {

    				rs.close();

    				String insertQuery = "insert into " + reservationTable + " value ('" + id + "','" + date + "','" + user + "')";

    				reservationSt.executeUpdate(insertQuery);
    			}
    			
        	} finally {
        		
        		if (reservationSt != null) {
        			reservationSt.close();
        		}
        		
        		if (reservationConn != null) {
        			reservationConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
    }
    
    public static Reservation searchReservation(String reservationTable, int id, int date){
    	
    	Reservation reservation = new Reservation();
    	
    	Connection reservationConn = null;
		Statement reservationSt = null;
		
    	try {
        	try {
            	Class.forName(driverClassName);
    			reservationConn = DriverManager.getConnection(url,name,pass);
    			
    			reservationSt = reservationConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);

    	    	String searchQuery = "select * from " + reservationTable + whereId + id + andDate + date + "'";
    			
    			ResultSet rs = reservationSt.executeQuery(searchQuery);
    		
    			rs.next();
    			
    			if (!rs.first()) {
    				return reservation;
    			}
    			reservation.setReservationId(id);
    			rs.close();
    			
        	} finally {
        		
        		if (reservationSt != null) {
        			reservationSt.close();
        		}
        		
        		if (reservationConn != null) {
        			reservationConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
    	
		return reservation;
    }
}
