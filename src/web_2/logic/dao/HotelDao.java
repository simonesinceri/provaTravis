package web_2.logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import web_2.logic.model.Hotel;

public class HotelDao {
	private static String name = "progettoFindit";
    private static String pass = "passwfindit2020";
    private static String url = "jdbc:mysql://localhost:3306/findit?useTimezone=true&serverTimezone=UTC";
    private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    
    /*
    public static void main(String[] args) {
    	Hotel hotel = new Hotel();
    	try {
    		
			setHotel(
					"Tor Vergata2",
					"Rettore",
					"hotel",
					"Roma",
					"Via Cambridge 1",
					3,true,true,false,false);
			
    		hotel = getHotel("Tor Vergata");
    		
			System.out.println("--- Username: " + hotel.getName());
			System.out.println("--- Owner: " + hotel.getOwner());
			System.out.println("--- Type: " + hotel.getType());
			System.out.println("--- City: " + hotel.getCity());
			System.out.println("--- Address: " + hotel.getAddress());
			System.out.println("--- Rating: " + hotel.getRating());
			System.out.println("--- Parking: " + hotel.isParking());
			System.out.println("--- Restaurant: " + hotel.isRestaurant());
			System.out.println("--- Room Service: " + hotel.isRoomService());
			System.out.println("--- Gym: " + hotel.isGym());
			System.out.println("--- Rooms Table: " + hotel.getRooms());
			System.out.println("--- Agenda Table: " + hotel.getAgenda());
			
    		hotel = searchHotel("Roma",null,false,false,false,false,1);
    		System.out.println("--- " + hotel.getName());
    		hotel = searchHotel("Roma",null,false,false,false,false,2);
    		System.out.println("--- " + hotel.getName());
    		hotel = searchHotel("Roma",null,false,false,false,false,3);
    		System.out.println("--- " + hotel.getName());
    		hotel = searchHotel("Roma",null,false,false,false,false,4);
    		System.out.println("--- " + hotel.getName());
    		hotel = searchHotel("Roma",null,false,false,false,false,5);
    		System.out.println("--- " + hotel.getName());
    		
		} catch (Exception e) {
	        System.out.println("# DB error! #");
	        System.out.println(e);
		}
    }
    */
    
	public static Hotel getHotel(String hotelName) throws Exception{

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
    	//String imageQuery = "select photo from hotels where name = '" + hotelName + "'";
    	String descriptionQuery = "select description from hotels where name = '" + hotelName + "'";
    	
    	Hotel hotel = new Hotel();
    	
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
		
			ResultSet rs = st.executeQuery(nameQuery);
		
			rs.next();
			
			// CHECK SE NON C'E' L'HOTEL
			if (!rs.first()) {
				return hotel;
			}
		
			String nome = rs.getNString("name");
			hotel.setName(nome);			
			rs.close();
			
			ResultSet rs1 = st.executeQuery(ownerQuery);			
			rs1.next();		
			String owner = rs1.getNString("owner");
			hotel.setOwner(owner);		
			rs1.close();
			
			ResultSet rs2 = st.executeQuery(typeQuery);			
			rs2.next();		
			String type = rs2.getNString("type");			
			hotel.setType(type);		
			rs2.close();
			
			ResultSet rs3 = st.executeQuery(cityQuery);			
			rs3.next();		
			String city = rs3.getNString("city");			
			hotel.setCity(city);		
			rs3.close();
			
			ResultSet rs4 = st.executeQuery(addressQuery);			
			rs4.next();		
			String address = rs4.getNString("address");
			hotel.setAddress(address);
			rs4.close();
			
			ResultSet rs5 = st.executeQuery(ratingQuery);
			rs5.next();
			int rating = rs5.getInt("rating");
			hotel.setRating(rating);
			rs5.close();
			
			ResultSet rs6 = st.executeQuery(parkingQuery);
			rs6.next();
			boolean parking = rs6.getBoolean("parking");
			hotel.setParking(parking);
			rs6.close();
			
			ResultSet rs7 = st.executeQuery(restaurantQuery);
			rs7.next();
			boolean restaurant = rs7.getBoolean("restaurant");
			hotel.setRestaurant(restaurant);
			rs7.close();
			
			ResultSet rs8 = st.executeQuery(roomServiceQuery);
			rs8.next();
			boolean roomService = rs8.getBoolean("roomService");
			hotel.setRoomService(roomService);
			rs8.close();
			
			ResultSet rs9 = st.executeQuery(gymQuery);
			rs9.next();
			boolean gym = rs9.getBoolean("gym");
			hotel.setGym(gym);
			rs9.close();
			
			ResultSet rs10 = st.executeQuery(roomsQuery);
			rs10.next();
			String rooms = rs10.getNString("rooms");
			hotel.setRooms(rooms);
			rs10.close();
			
			ResultSet rs11 = st.executeQuery(agendaQuery);
			rs11.next();
			String agenda = rs11.getNString("agenda");
			hotel.setAgenda(agenda);
			rs11.close();
			
			ResultSet rs12 = st.executeQuery(reviewsQuery);
			rs12.next();
			String reviews = rs12.getNString("reviews");
			hotel.setReviews(reviews);
			rs12.close();
			/*
			ResultSet rs13 = st.executeQuery(imageQuery);
			rs13.next();
			Blob blob = rs13.getBlob("photo");
			if (blob.length() > 4) {
				System.out.println("provaaaaaa");
				byte[] imageByte = blob.getBytes(1, (int) blob.length());
				InputStream binaryStream = new ByteArrayInputStream(imageByte);
				BufferedImage bf = ImageIO.read(binaryStream);
				Image  img = SwingFXUtils.toFXImage(bf, null);
				hotel.setImage(img);
			} else {
				hotel.setImage(null);
			}
			rs13.close();
			*/
			ResultSet rs14 = st.executeQuery(descriptionQuery);
			rs14.next();
			String description = rs14.getString("description");
			hotel.setDescription(description);
			rs14.close();
			
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
    	
		return hotel;
    }
	
	public static boolean setHotel(
			String nome, 
			String owner, 
			String type,
			String city,
			String address,
			int rating,
			boolean parking,
			boolean restaurant,
			boolean roomService,
			boolean gym) throws Exception{

		String rooms = (nome + "Rooms").replaceAll("\\s+","");
		String agenda = (nome + "Agenda").replaceAll("\\s+","");
		String reviewsTable = (nome + "Reviews").replaceAll("\\s+","");

    	String searchQuery = "select name from hotels where name = '" + nome + "'";
    	
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
				
				//CERCA NEL DB TABELLE PER ROOMS E AGENDA CON LO STESSO NOME
				java.sql.DatabaseMetaData meta = con.getMetaData();
				
				String variableRooms = rooms;
				String variableAgenda = agenda;
				String variableReviewsTable = reviewsTable;
				
				boolean exist = true;
				
				int i=0;
				
				while (exist == true) {
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
						
				    	String createRoomsTable = "create table " + rooms + " (id int, price int, beds int)";
				    	String createAgendaTable = "create table " + agenda + " (id int, date varchar(10), user varchar(20))";	
				    	String createReviewsQuery = "create table " + reviewsTable + " (user varchar(20),review text, stars int)";
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
		    					+ "'" + null + "')";
				    	
						st.executeUpdate(insertQuery);
						st.executeUpdate(createRoomsTable);
						st.executeUpdate(createAgendaTable);
						st.executeUpdate(createReviewsQuery);
					}
				}
				
				return true;
				
			} else {
				
				return false;
				
			}
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
    }
	
	public static Hotel searchHotel(String city, String type, Boolean parking, Boolean restaurant, Boolean roomService, Boolean gym, int stars, int index) throws Exception{

		String serachQuery = "select * from hotels where city = '" + city + "'";
		
    	String nameQuery = "select name from hotels where city = '" + city + "'";
    	
    	Hotel hotel = new Hotel();
    	
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

			if (type != null) {
				serachQuery = serachQuery + " and type = '" + type + "'";
				nameQuery = nameQuery + " and type = '" + type + "'";
			}

			if (parking == true) {
				serachQuery = serachQuery + " and parking = '" + true + "'";
				nameQuery = nameQuery + " and parking = '" + true + "'";
			}
			
			if (restaurant == true) {
				serachQuery = serachQuery + " and restaurant = '" + true + "'";
				nameQuery = nameQuery + " and restaurant = '" + true + "'";
			}
			
			if (roomService == true) {
				serachQuery = serachQuery + " and roomService = '" + true + "'";
				nameQuery = nameQuery + " and roomService = '" + true + "'";
			}
			
			if (gym == true) {
				serachQuery = serachQuery + " and gym = '" + true + "'";
				nameQuery = nameQuery + " and gym = '" + true + "'";
			}
			
			if (stars != 0) {
				serachQuery = serachQuery + " and rating >= '" + stars + "'";
				nameQuery = nameQuery + " and rating >= '" + stars + "'";
			}
			
			ResultSet rs = st.executeQuery(serachQuery);
		
			rs.next();
			
			// CHECK SE NON C'E'
			if (!rs.first()) {
				return hotel;
			}
			
			ResultSet rs1 = st.executeQuery(nameQuery);
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
    		
    		st.close();
    		con.close();
    		
    	}
    	
		return hotel;
    }
	
	public static void setDescription(String description, String structure) throws Exception {
		
		String insertQuery = "update hotels set description = '" + description + "' where name = '" + structure + "'";
		
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
				    	
			st.executeUpdate(insertQuery);
			
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
	}
	
	public static void setRating(int avg, String structure) throws Exception {
		
		String insertQuery = "update hotels set rating = '" + avg + "' where name = '" + structure + "'";
		
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
				    	
			st.executeUpdate(insertQuery);
			
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
	}
}
