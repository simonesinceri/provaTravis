package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import logic.bean.HotelBean;
import logic.exceptions.ExceptionSearchHotels;
import logic.model.Hotel;

public class HotelDao {
	private static String name = "progettoFindit";
    private static String pass = "passwfindit2020";
    private static String url = "jdbc:mysql://localhost:3306/findit?useTimezone=true&serverTimezone=UTC";
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    
    private HotelDao() {
    	
    }
    
	public static Hotel getHotel(String hotelName){

    	String nameQuery = "select name from hotels where name = '" + hotelName + "'";
    	String ownerQuery = "select owner from hotels where name = '" + hotelName + "'";
    	String typeQuery = "select type from hotels where name = '" + hotelName + "'";
    	String cityQuery = "select city from hotels where name = '" + hotelName + "'";
    	String addressQuery = "select address from hotels where name = '" + hotelName + "'";
    	String ratingQuery = "select rating from hotels where name = '" + hotelName + "'";
    	String parkingQuery = "select parking from hotels where name = '" + hotelName + "'";
    	String restaurantQuery = "select restaurant from hotels where name = '" + hotelName + "'";
    	String roomServiceQuery = "select roomService from hotels where name = '" + hotelName + "'";
    	String gymQuery = "select gym from hotels where name = '" + hotelName + "'";
    	String roomsQuery = "select rooms from hotels where name = '" + hotelName + "'";
    	String agendaQuery = "select agenda from hotels where name = '" + hotelName + "'";
    	String reviewsQuery = "select reviews from hotels where name = '" + hotelName + "'";
    	String descriptionQuery = "select description from hotels where name = '" + hotelName + "'";
    	
    	Hotel hotel = new Hotel();
    	
    	Connection hotelConn = null;
		Statement hotelSt = null;
		
    	try {
        	try {
            	Class.forName(driverClassName);
    			hotelConn = DriverManager.getConnection(url,name,pass);
    			
    			hotelSt = hotelConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);
    		
    			ResultSet rs = hotelSt.executeQuery(nameQuery);
    		
    			rs.next();
    			
    			if (!rs.first()) {
    				return hotel;
    			}
    		
    			String nome = rs.getNString("name");
    			hotel.setHotelName(nome);			
    			rs.close();
    			
    			ResultSet rs1 = hotelSt.executeQuery(ownerQuery);			
    			rs1.next();		
    			String owner = rs1.getNString("owner");
    			hotel.setHotelOwner(owner);		
    			rs1.close();
    			
    			ResultSet rs2 = hotelSt.executeQuery(typeQuery);			
    			rs2.next();		
    			String type = rs2.getNString("type");			
    			hotel.setHotelType(type);		
    			rs2.close();
    			
    			ResultSet rs3 = hotelSt.executeQuery(cityQuery);			
    			rs3.next();		
    			String city = rs3.getNString("city");			
    			hotel.setHotelCity(city);		
    			rs3.close();
    			
    			ResultSet rs4 = hotelSt.executeQuery(addressQuery);			
    			rs4.next();		
    			String address = rs4.getNString("address");
    			hotel.setHotelAddress(address);
    			rs4.close();
    			
    			ResultSet rs5 = hotelSt.executeQuery(ratingQuery);
    			rs5.next();
    			int rating = rs5.getInt("rating");
    			hotel.setHotelRating(rating);
    			rs5.close();
    			
    			ResultSet rs6 = hotelSt.executeQuery(parkingQuery);
    			rs6.next();
    			boolean parking = rs6.getBoolean("parking");
    			hotel.setHotelParking(parking);
    			rs6.close();
    			
    			ResultSet rs7 = hotelSt.executeQuery(restaurantQuery);
    			rs7.next();
    			boolean restaurant = rs7.getBoolean("restaurant");
    			hotel.setHotelRestaurant(restaurant);
    			rs7.close();
    			
    			ResultSet rs8 = hotelSt.executeQuery(roomServiceQuery);
    			rs8.next();
    			boolean roomService = rs8.getBoolean("roomService");
    			hotel.setHotelRoomService(roomService);
    			rs8.close();
    			
    			ResultSet rs9 = hotelSt.executeQuery(gymQuery);
    			rs9.next();
    			boolean gym = rs9.getBoolean("gym");
    			hotel.setHotelGym(gym);
    			rs9.close();
    			
    			ResultSet rs10 = hotelSt.executeQuery(roomsQuery);
    			rs10.next();
    			String rooms = rs10.getNString("rooms");
    			hotel.setHotelRooms(rooms);
    			rs10.close();
    			
    			ResultSet rs11 = hotelSt.executeQuery(agendaQuery);
    			rs11.next();
    			String agenda = rs11.getNString("agenda");
    			hotel.setHotelAgenda(agenda);
    			rs11.close();
    			
    			ResultSet rs12 = hotelSt.executeQuery(reviewsQuery);
    			rs12.next();
    			String reviews = rs12.getNString("reviews");
    			hotel.setHotelReviews(reviews);
    			rs12.close();
    			
    			ResultSet rs14 = hotelSt.executeQuery(descriptionQuery);
    			rs14.next();
    			String description = rs14.getString("description");
    			hotel.setHotelDescription(description);
    			rs14.close();
    			
        	} finally {
        		
        		if (hotelSt != null) {
        			hotelSt.close();
        		}
        		
        		if (hotelConn != null) {
        			hotelConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
    	
		return hotel;
    }
	
	public static boolean setHotel(HotelBean bean, String owner, int rating){

		String nome = bean.getName();
		String type = bean.getType();
		String city = bean.getCity();
		String address = bean.getAddress();
		boolean parking = bean.getParking();
		boolean restaurant = bean.getRestaurant();
		boolean roomService = bean.getRoomService();
		boolean gym = bean.getGym();
		
		String rooms = (nome + "Rooms").replaceAll("\\s+","");
		String agenda = (nome + "Agenda").replaceAll("\\s+","");
		String reviewsTable = (nome + "Reviews").replaceAll("\\s+","");
		String createTable = "create table ";

    	String searchQuery = "select name from hotels where name = '" + nome + "'";
    	
    	Connection hotelConn = null;
		Statement hotelSt = null;
		
		boolean result = false;

    	try {
        	try {
            	Class.forName(driverClassName);
    			hotelConn = DriverManager.getConnection(url,name,pass);
    			
    			hotelSt = hotelConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);
    		
    			ResultSet rs = hotelSt.executeQuery(searchQuery);
    			
    			if (!rs.first()) {

    				rs.close();
    				
    				java.sql.DatabaseMetaData meta = hotelConn.getMetaData();
    				
    				String variableRooms = rooms;
    				String variableAgenda = agenda;
    				String variableReviewsTable = reviewsTable;
    				
    				boolean exist = true;
    				
    				int i=0;
    				
    				while (exist) {
    					ResultSet res = meta.getTables(null, null, variableRooms, null);
    					if (res.next()) {
    						variableRooms = rooms + i;
    						variableAgenda = agenda + i;
    						variableReviewsTable = reviewsTable + i;
    						i++;
    					} else {
    						exist = false;
    						rooms = variableRooms;
    						agenda = variableAgenda;
    						reviewsTable = variableReviewsTable;
    						
    				    	String createRoomsTable = createTable + rooms + " (id int, price int, beds int)";
    				    	String createAgendaTable = createTable + agenda + " (id int, date varchar(10), user varchar(20))";	
    				    	String createReviewsQuery = createTable + reviewsTable + " (user varchar(20),review text, stars int)";
    				    	String insertQuery = "insert into hotels value ("
    				    			+ "'" + nome + "',"
    				    			+ "'" + owner + "',"
    				    	    	+ "'" + type + "',"
    				    	    	+ "'" + city + "',"
    				    	    	+ "'" + address + "',"
    				    	    	+ "" + rating + ","
    				    	    	+ "" + parking + ","
    				    	    	+ "" + restaurant + ","
    				    	    	+ "" + roomService + ","
    				    	    	+ "" + gym + ","
    				    	    	+ "'" + rooms + "',"
    				    			+ "'" + agenda + "',"
    		    					+ "'" + reviewsTable + "',"
    		    					+ "'')";
    				    	
    						hotelSt.executeUpdate(insertQuery);
    						hotelSt.executeUpdate(createRoomsTable);
    						hotelSt.executeUpdate(createAgendaTable);
    						hotelSt.executeUpdate(createReviewsQuery);
    					}
    				}
    				
    				result = true;
    				
    			}
    			
        	} finally {
        		
        		if (hotelSt != null) {
        			hotelSt.close();
        		}
        		
        		if (hotelConn != null) {
        			hotelConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
    	return result;
    }
	
	public static Hotel searchHotel(HotelBean bean, int stars, int index) throws ExceptionSearchHotels{
    	
    	Hotel hotel = new Hotel();
    	
    	Connection hotelConn = null;
		Statement hotelSt = null;

		String city = bean.getCity();
		String type = bean.getType();
		Boolean parking = bean.getParking();
		Boolean restaurant = bean.getRestaurant();
		Boolean roomService = bean.getRoomService();
		Boolean gym = bean.getGym();
		
    	try {
        	try {
            	Class.forName(driverClassName);
    			hotelConn = DriverManager.getConnection(url,name,pass);
    			
    			hotelSt = hotelConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);

    			String serachQuery = "select * from hotels where city = '" + city + "'";
    			
    	    	String nameQuery = "select name from hotels where city = '" + city + "'";

    			if (type != null) {
    				serachQuery = serachQuery + " and type = '" + type + "'";
    				nameQuery = nameQuery + " and type = '" + type + "'";
    			}

    			if (Boolean.TRUE.equals(parking)) {
    				serachQuery = serachQuery + " and parking = '" + parking + "'";
    				nameQuery = nameQuery + " and parking = '" + parking + "'";
    			}
    			
    			if (Boolean.TRUE.equals(restaurant)) {
    				serachQuery = serachQuery + " and restaurant = '" + restaurant + "'";
    				nameQuery = nameQuery + " and restaurant = '" + restaurant + "'";
    			}
    			
    			if (Boolean.TRUE.equals(roomService)) {
    				serachQuery = serachQuery + " and roomService = '" + roomService + "'";
    				nameQuery = nameQuery + " and roomService = '" + roomService + "'";
    			}
    			
    			if (Boolean.TRUE.equals(gym)) {
    				serachQuery = serachQuery + " and gym = '" + gym + "'";
    				nameQuery = nameQuery + " and gym = '" + gym + "'";
    			}
    			
    			if (stars != 0) {
    				serachQuery = serachQuery + " and rating >= '" + stars + "'";
    				nameQuery = nameQuery + " and rating >= '" + stars + "'";
    			}
    			
    			ResultSet rs = hotelSt.executeQuery(serachQuery);
    		
    			rs.next();
    			
    			if (!rs.first()) {
    				return hotel;
    			}
    			
    			ResultSet rs1 = hotelSt.executeQuery(nameQuery);
    			rs1.next();
    			
    			for (int i=1; i<index; i++) {
    				if (!rs1.next()) {
    					return hotel;
    				}
    			}
    			
    			String hotelName = rs1.getNString("name");
    			hotel = getHotel(hotelName);
    			rs1.close();
        
        	} finally {
        		
        		if (hotelSt != null) {
        			hotelSt.close();
        		}
        		
        		if (hotelConn != null) {
        			hotelConn.close();
        		}
        		
        	}
		} catch(Exception e){
			
	        throw new ExceptionSearchHotels();
	    }
    	
		return hotel;
    }
	
	public static void setDescription(String description, String structure){
		
		Connection hotelConn = null;
		Statement hotelSt = null;
		
    	try {
        	try {
            	Class.forName(driverClassName);
    			hotelConn = DriverManager.getConnection(url,name,pass);
    			
    			hotelSt = hotelConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);
    			
    			String insertQuery = "update hotels set description = '" + description + "' where name = '" + structure + "'";
    				    	
    			hotelSt.executeUpdate(insertQuery);
    			
        	} finally {
        		
        		if (hotelSt != null) {
        			hotelSt.close();
        		}
        		
        		if (hotelConn != null) {
        			hotelConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
	}
	
	public static void setRating(int avg, String structure){
		
		Connection hotelConn = null;
		Statement hotelSt = null;
		
    	try {
        	try {
            	Class.forName(driverClassName);
    			hotelConn = DriverManager.getConnection(url,name,pass);
    			
    			hotelSt = hotelConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);
    			
    			String insertQuery = "update hotels set rating = '" + avg + "' where name = '" + structure + "'";
    				    	
    			hotelSt.executeUpdate(insertQuery);
    			
        	} finally {
        		
        		if (hotelSt != null) {
        			hotelSt.close();
        		}
        		
        		if (hotelConn != null) {
        			hotelConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
	}
}
