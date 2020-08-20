package web_2.logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import web_2.logic.model.Reservation;

public class ReservationDao {
	private static String name = "progettoFindit";
    private static String pass = "passwfindit2020";
    private static String url = "jdbc:mysql://localhost:3306/findit?useTimezone=true&serverTimezone=UTC";
    private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    
    /*
    public static void main(String[] args) {
    	Reservation reservation = new Reservation();
    	try {
    		
			setReservation("TorVergataAgenda",4,20200522,"Pierpaolo");
			
			reservation = getReservation("TorVergataAgenda",4,20200522);

			System.out.println("ID: " + reservation.getReservationId());
			System.out.println("DATE: " + reservation.getDate());
			System.out.println("USER: " + reservation.getUserBooked());
			
			
		} catch (Exception e) {
	        System.out.println("# DB error! #");
	        System.out.println(e);
		}
    }
    */
    
    public static Reservation getReservation(String reservationTable, int id, int date) throws Exception{

    	String idQuery = "select id from " + reservationTable + " where id = '" + id + "' and date = '" + date + "'";
    	String userQuery = "select user from " + reservationTable + " where id = '" + id + "' and date = '" + date + "'";
    	
    	Reservation reservation = new Reservation();
    	
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
		
			ResultSet rs = st.executeQuery(idQuery);
		
			rs.next();
			
			// CHECK SE NON C'E' L'HOTEL
			if (!rs.first()) {
				return reservation;
			}
			
			int reservationID = rs.getInt("id");
			reservation.setReservationId(reservationID);
			rs.close();
			
			reservation.setDate(date);
			
			ResultSet rs2 = st.executeQuery(userQuery);
			rs2.next();
			String user = rs2.getNString("user");
			reservation.setUserBooked(user);
			rs2.close();
			
    
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
    	
		return reservation;
    }
	
    public static void setReservation(String reservationTable, int id, int date, String user) throws Exception{		

    	String searchQuery = "select id from " + reservationTable + " where id = '" + id + "' and date = '" + date + "'";
        
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
			
			if (!rs.first()) {

				rs.close();

				String insertQuery = "insert into " + reservationTable + " value ('" + id + "','" + date + "','" + user + "')";

				st.executeUpdate(insertQuery);
			}
			
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
    }
    
    public static Reservation searchReservation(String reservationTable, int id, int date) throws Exception{

    	String searchQuery = "select * from " + reservationTable + " where id = '" + id + "' and date = '" + date + "'";
    	
    	Reservation reservation = new Reservation();
    	
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
			
			// CHECK SE NON C'E'
			if (!rs.first()) {
				return reservation;
			}
			reservation.setReservationId(id);
			rs.close();
			
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
    	
		return reservation;
    }
}
