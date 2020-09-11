package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import logic.model.Experience;
import logic.model.Review;

public class ExperienceDao {
	
	private static String name = "progettoFindit";
    private static String pass = "passwfindit2020";
    private static String url = "jdbc:mysql://localhost:3306/findit?useTimezone=true&serverTimezone=UTC";
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    
    private ExperienceDao() {
    	
    }
    
	public static Experience getExperience(String reviewTable, int index){
		
		String nameQuery = "select structure from " + reviewTable;
		String reviewQuery = "select review from " + reviewTable;
		String ratingQuery = "select stars from " + reviewTable;
		String dayInQuery = "select dateIn from " + reviewTable;
		String dayOutQuery = "select dateOut from " + reviewTable;

		Experience experience = new Experience();
		
		Connection experienceConn = null;
		Statement experienceSt = null;
		
		try {
		
			try {
	    		Class.forName(driverClassName);
	    		
				experienceConn = DriverManager.getConnection(url,name,pass);
				
				experienceSt = experienceConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
		                ResultSet.CONCUR_READ_ONLY);
			
				ResultSet rs = experienceSt.executeQuery(nameQuery);
				
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
				
				ResultSet rs3 = experienceSt.executeQuery(reviewQuery);
				rs3.first();
				for (int i=1; i<index; i++) {
					rs3.next();
				}
				String review = rs3.getNString("review");
				experience.setReview(review);
				rs3.close();
				
				ResultSet rs4 = experienceSt.executeQuery(ratingQuery);
				rs4.first();
				for (int i=1; i<index; i++) {
					rs4.next();
				}
				int rate = rs4.getInt("stars");
				experience.setRating(rate);
				rs4.close();
				
				ResultSet rs1 = experienceSt.executeQuery(dayInQuery);
				rs1.first();
				for (int i=1; i<index; i++) {
					rs1.next();
				}
				int dateIn = rs1.getInt("dateIn");
				experience.setDayIn(dateIn);
				rs1.close();
				
				ResultSet rs2 = experienceSt.executeQuery(dayOutQuery);
				rs2.first();
				for (int i=1; i<index; i++) {
					rs2.next();
				}
				int dateOut = rs2.getInt("dateOut");
				experience.setDayOut(dateOut);
				rs2.close();
				
	    	} finally {
        		
        		if (experienceSt != null) {
            		experienceSt.close();
        		}
        		
        		if (experienceConn != null) {
        			experienceConn.close();
        		}
				
	    	}
    	
		} catch(Exception e){
	        System.exit(1);
	    }
		return experience;
	}
	
	public static void setExperienceRow(String reviewTable, String experienceName, int dayIn, int dayOut){
        
    	Connection experienceConn = null;
		Statement experienceSt = null;
		
    	try {
        	try{
        		Class.forName(driverClassName);
    			experienceConn = DriverManager.getConnection(url,name,pass);
    			
    			experienceSt = experienceConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);
    			
    			String insertQuery = "insert into " + reviewTable + " value ('" + experienceName + "','','" + 0 + "','" + dayIn + "','" + dayOut + "')";
    				    	
    			experienceSt.executeUpdate(insertQuery);
    			
        	} finally {
        		
        		if (experienceSt != null) {
            		experienceSt.close();
        		}
        		
        		if (experienceConn != null) {
        			experienceConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
    }
	
	public static int getBooked(String reviewTable){
		
		Connection experienceConn = null;
		Statement experienceSt = null;
		
    	int i = 0;
		try {
			try {
            	Class.forName(driverClassName);
    			experienceConn = DriverManager.getConnection(url,name,pass);
    			
    			experienceSt = experienceConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);
    			
    			String numBookedQuery = "select count(*) from " + reviewTable;
    				    	
    			ResultSet bookedRs = experienceSt.executeQuery(numBookedQuery);
    			bookedRs.next();
    			i = bookedRs.getInt("count(*)");
    			bookedRs.close();
    			
        	} finally {
        		
        		if (experienceSt != null) {
            		experienceSt.close();
        		}
        		
        		if (experienceConn != null) {
        			experienceConn.close();
        		}
        		
        	}
			
		} catch(Exception e){
	        System.exit(1);
	    }
		return i;
	}
	
	public static int getReviewsNumber(String reviewTable){
		
		Connection experienceConn = null;
		Statement experienceSt = null;
		
    	int i = 0;
		try {
        	try {
            	Class.forName(driverClassName);
    			experienceConn = DriverManager.getConnection(url,name,pass);
    			
    			experienceSt = experienceConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);
    			
    			String numReviewsQuery = "select count(*) from " + reviewTable + " where review != ''";
    				    	
    			ResultSet reviewsRs = experienceSt.executeQuery(numReviewsQuery);
    			reviewsRs.next();
    			i = reviewsRs.getInt("count(*)");
    			reviewsRs.close();
    			
        	} finally {
        		
        		if (experienceSt != null) {
            		experienceSt.close();
        		}
        		
        		if (experienceConn != null) {
        			experienceConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
		
		return i;
	}
	
	public static void addReview(Review review, String structure, int dayIn, int dayOut, String table){

		Connection experienceConn = null;
		Statement experienceSt = null;
		
    	try {
        	try {
            	Class.forName(driverClassName);
    			experienceConn = DriverManager.getConnection(url,name,pass);
    			
    			experienceSt = experienceConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);

    			String insertReviewQuery = "update " + table + " set review = '" + review.getReviewText() + "' where structure = '" + structure + "' and dateIn = '" + dayIn + "' and dateOut = '" + dayOut + "'";
    			String insertStarsQuery = "update " + table + " set stars = '" + review.getReviewVote() + "' where structure = '" + structure + "' and dateIn = '" + dayIn + "' and dateOut = '" + dayOut + "'";

    			experienceSt.executeUpdate(insertReviewQuery);
    			experienceSt.executeUpdate(insertStarsQuery);
    			
        	} finally {
        		
        		if (experienceSt != null) {
            		experienceSt.close();
        		}
        		
        		if (experienceConn != null) {
        			experienceConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
	}
}
