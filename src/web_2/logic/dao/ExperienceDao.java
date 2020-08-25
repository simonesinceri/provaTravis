package web_2.logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import web_2.logic.model.Experience;
import web_2.logic.model.Review;
import web_2.logic.model.User;
import web_2.logic.model.UserWeb;

public class ExperienceDao {
	
	private static String name = "progettoFindit";
    private static String pass = "passwfindit2020";
    private static String url = "jdbc:mysql://localhost:3306/findit?useTimezone=true&serverTimezone=UTC";
    private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    
	public static Experience getExperience(String reviewTable, int index) throws Exception{
		
		String nameQuery = "select structure from " + reviewTable;
		String reviewQuery = "select review from " + reviewTable;
		String ratingQuery = "select stars from " + reviewTable;
		String dayInQuery = "select dateIn from " + reviewTable;
		String dayOutQuery = "select dateOut from " + reviewTable;

		Experience experience = new Experience();
		
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
			
			// CHECK SE NON C'E'
			if (!rs.first()) {
				return experience;
			}
			
			for (int i=1; i<index; i++) {
				if (!rs.next()) {
					return experience;
				}
			}
			
			String nome = rs.getNString("structure");
			experience.setName(nome);
			rs.close();
			
			ResultSet rs3 = st.executeQuery(reviewQuery);
			rs3.first();
			for (int i=1; i<index; i++) {
				rs3.next();
			}
			String review = rs3.getNString("review");
			experience.setReview(review);
			rs3.close();
			
			ResultSet rs4 = st.executeQuery(ratingQuery);
			rs4.first();
			for (int i=1; i<index; i++) {
				rs4.next();
			}
			int rate = rs4.getInt("stars");
			experience.setRating(rate);
			rs4.close();
			
			ResultSet rs1 = st.executeQuery(dayInQuery);
			rs1.first();
			for (int i=1; i<index; i++) {
				rs1.next();
			}
			int dateIn = rs1.getInt("dateIn");
			experience.setDayIn(dateIn);
			rs1.close();
			
			ResultSet rs2 = st.executeQuery(dayOutQuery);
			rs2.first();
			for (int i=1; i<index; i++) {
				rs2.next();
			}
			int dateOut = rs2.getInt("dateOut");
			experience.setDayOut(dateOut);
			rs2.close();
			
    	} finally {
    		
    		st.close();
    		con.close();
			
    	}
		return experience;
	}
	
	public static void setExperienceRow(String reviewTable, String experienceName, int dayIn, int dayOut) throws Exception{
        
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
			
			String insertQuery = "insert into " + reviewTable + " value ('" + experienceName + "','','" + 0 + "','" + dayIn + "','" + dayOut + "')";
				    	
			st.executeUpdate(insertQuery);
			
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
    }
	
	public static int getBooked(String reviewTable) throws Exception {
		
		String numQuery = "select count(*) from " + reviewTable;
		
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
	
	public static int getReviewsNumber(String reviewTable) throws Exception {
		
		String numQuery = "select count(*) from " + reviewTable + " where review != ''";
		
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
	
	
	// problema qui con user singleton
	//public static void addReview(Review review, String structure, int dayIn, int dayOut) throws Exception {
	//public static void addReview(Review review, String structure, int dayIn, int dayOut, String table) throws Exception {
		//devo modificare questo...passare come argomento l'user o la stringa della tabella??
		//String table = User.getIstance().getReviewsTable();

		public static void addReview(Review review, String structure, int dayIn, int dayOut, String table){
			
			//String table = User.getIstance().getReviewsTable();

			String insertReviewQuery = "update " + table + " set review = '" + review.getReview() + "' where structure = '" + structure + "' and dateIn = '" + dayIn + "' and dateOut = '" + dayOut + "'";
			String insertStarsQuery = "update " + table + " set stars = '" + review.getVote() + "' where structure = '" + structure + "' and dateIn = '" + dayIn + "' and dateOut = '" + dayOut + "'";

			Connection con = null;
			Statement st = null;
			
	    	try {
	        	try {
	            	Class.forName(driverClassName);
	    			con = DriverManager.getConnection(url,name,pass);
	    			
	    			st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
	    	                ResultSet.CONCUR_READ_ONLY);

	    			st.executeUpdate(insertReviewQuery);
	    			st.executeUpdate(insertStarsQuery);
	    			
	        	} finally {
	        		
	        		st.close();
	        		con.close();
	        		
	        	}
			} catch(Exception e){
		        System.exit(1);
		    }
		}
}
