package web_2.logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import web_2.logic.model.Review;

public class ReviewDao {
	
	private static String name = "progettoFindit";
    private static String pass = "passwfindit2020";
    private static String url = "jdbc:mysql://localhost:3306/findit?useTimezone=true&serverTimezone=UTC";
    private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    
	public static Review getReview(String reviewTable, int index) throws Exception{
		
		String userQuery = "select user from " + reviewTable;
		String reviewQuery = "select review from " + reviewTable;
		String ratingQuery = "select stars from " + reviewTable;

		Review review = new Review();
		
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
		
			ResultSet rs = st.executeQuery(userQuery);
			
			// CHECK SE NON C'E'
			if (!rs.first()) {
				return review;
			}
			
			for (int i=1; i<index; i++) {
				if (!rs.next()) {
					return review;
				}
			}
			
			String nome = rs.getNString("user");
			review.setUser(nome);
			rs.close();
			
			ResultSet rs3 = st.executeQuery(reviewQuery);
			rs3.first();
			for (int i=1; i<index; i++) {
				rs3.next();
			}
			String reviewText = rs3.getNString("review");
			review.setReview(reviewText);
			rs3.close();
			
			ResultSet rs4 = st.executeQuery(ratingQuery);
			rs4.first();
			for (int i=1; i<index; i++) {
				rs4.next();
			}
			int vote = rs4.getInt("stars");
			review.setVote(vote);
			rs4.close();
			
    	} finally {
    		
    		st.close();
    		con.close();
			
    	}
		return review;
	}
	
	public static int setReview(String review, int stars, String user, String table) throws Exception {
		
		String insertQuery = "insert into " + table + " value ('" + user + "','" + review + "','" + stars + "')";
		
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
    	
    	String avgQuery = "select AVG(stars) from " + table;

    	ResultSet rs = st.executeQuery(avgQuery);
    	rs.next();
    	int avg = rs.getInt("AVG(stars)");
		rs.close();
    	
		return avg;
			
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
	}
}
