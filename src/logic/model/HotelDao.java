package logic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HotelDao {
	private static String name = "root";
    private static String pass = "Pier1997";
    private static String url = "jdbc:mysql://localhost:3306/findit?useTimezone=true&serverTimezone=UTC";
    private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    
    /*
    public static void main(String[] args) {
    	Hotel hotel = new Hotel();
    	try {
    		
			setHotel(
					"Tor Vergata",
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
			
		} catch (Exception e) {
	        System.out.println("# DB error! #");
	        System.out.println(e);
		}
    }
    */
    
	public static Hotel getHotel(String username) throws Exception{

    	String nameQuery = "select name from hotels where name = '" + username + "'";
    	String ownerQuery = "select owner from hotels where name = '" + username + "'";
    	String typeQuery = "select type from hotels where name = '" + username + "'";
    	String cityQuery = "select city from hotels where name = '" + username + "'";
    	String addressQuery = "select address from hotels where name = '" + username + "'";
    	String ratingQuery = "select rating from hotels where name = '" + username + "'";
    	String parkingQuery = "select parking from hotels where name = '" + username + "'";
    	String restaurantQuery = "select restaurant from hotels where name = '" + username + "'";
    	String roomServiceQuery = "select roomService from hotels where name = '" + username + "'";
    	String gymQuery = "select gym from hotels where name = '" + username + "'";
    	String roomsQuery = "select rooms from hotels where name = '" + username + "'";
    	String agendaQuery = "select agenda from hotels where name = '" + username + "'";
    	
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
			String agenda= rs11.getNString("agenda");
			hotel.setAgenda(agenda);
			rs11.close();
    
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
				boolean exist = true;
				int i=0;
				
				while (exist == true) {
					ResultSet res = meta.getTables(null, null, variableRooms, null);
					if (res.next()) {
						variableRooms = rooms + i;
						variableAgenda = agenda + i;
						i++;
					} else {
						exist = false;
						rooms = variableRooms;
						agenda = variableAgenda;
						
				    	String createRoomsTable = "create table " + rooms + " (id int, price int, beds int)";
				    	String createAgendaTable = "create table " + agenda + " (id int, date varchar(10), user varchar(20))";						
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
				    			+ "'" + agenda + "')";
				    	
						st.executeUpdate(insertQuery);
						st.executeUpdate(createRoomsTable);
						st.executeUpdate(createAgendaTable);
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
}
