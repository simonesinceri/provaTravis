package logic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	private static String name = "root";
    private static String pass = "Pier1997";
    private static String url = "jdbc:mysql://localhost:3306/findit?useTimezone=true&serverTimezone=UTC";
    private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    
	public static User getUser(String username) throws Exception{
    	
    	String nameUserQuery = "select name from users where name = '" + username + "'";
    	String psswUserQuery = "select pssw from users where name = '" + username + "'";
    	
    	User user = new User();
    	
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
		
			ResultSet rs = st.executeQuery(nameUserQuery);
		
			rs.next();
			
			// CHECK SE NON C'E' L'UTENTE
			if (!rs.first()) {
				
				return user;
			}
		
			String nome = rs.getNString("name");
			
			user.setUsername(nome);
			
			rs.close();
			
			ResultSet rs1 = st.executeQuery(psswUserQuery);
		
			rs1.next();
		
			String pssw = rs1.getNString("pssw");
			
			user.setPassword(pssw);
		
			rs1.close();
    		
			user.setLogged(true);
    
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
    	
		return user;
    }
	
	public static boolean setUser(String username, String password) throws Exception{

    	String insertQuery = "insert into users value ('" + username + "','" + password + "')";
    	String searchUserQuery = "select name from users where name = '" + username + "'";
    	String searchOwnerQuery = "select name from owners where name = '" + username + "'";
    	
    	
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
		
			ResultSet rs = st.executeQuery(searchUserQuery);
			
			if (!rs.first()) {

				rs.close();
				
				ResultSet rs2 = st.executeQuery(searchOwnerQuery);
				
				if (!rs2.first()) {

					rs2.close();
				
					st.executeUpdate(insertQuery);

					return true;
				}
			} else {
				
				return false;
				
			}
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
		return false;
    }
}
