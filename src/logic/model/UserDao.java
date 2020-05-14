package logic.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDao {
	private static String name = "root";
    private static String pass = "Pier1997";
    private static String url = "jdbc:mysql://localhost:3306/adc";
    private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    
    /*
    public static void main(String[] args) {
    	User user = new User();
    	
    	try {
			user = getUser("Pippo");
			user = setUser("Tozzo", "tozzo");
			user = setUser("Pippo", "pippo");
			
			System.out.println("--- Username: " + user.username);
			System.out.println("--- Password: " + user.password);
			
		} catch (Exception e) {
	        System.out.println("# DB error! #");
	        System.out.println(e);
		}
    }
    */
    
	public static User getUser(String username) throws Exception{
    	
    	String nameQuery = "select name from student where name = '" + username + "'";
    	String psswQuery = "select pssw from student where name = '" + username + "'";
    	
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
		
			ResultSet rs = st.executeQuery(nameQuery);
		
			rs.next();
			
			// CHECK SE NON C'E' L'UTENTE
			if (!rs.first()) {
				//System.out.println("# Utente non presente nel database! #");
				return user;
			}
		
			String nome = rs.getNString("name");
			
			//System.out.println("Username: " + nome);
			user.setUsername(nome);
			
			rs.close();
			
			ResultSet rs1 = st.executeQuery(psswQuery);
		
			rs1.next();
		
			String pssw = rs1.getNString("pssw");
			//System.out.println("Password: " + pssw);
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
    	
    	String insertQuery = "insert into student value ('" + username + "','" + password + "')";
    	String searchQuery = "select name from student where name = '" + username + "'";
    	
    	//User user = new User();
    	
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
				
				st.executeUpdate(insertQuery);
				//System.out.println("# Abilitato alla registrazione! #");
				//User.username = username;
				//User.password = password;
				return true;
			} else {
				//System.out.println("# Utente già registrato! #");
				//User.username = username;
				//User.password = password;
				return false;
			}
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
    }
}
