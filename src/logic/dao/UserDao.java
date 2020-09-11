package logic.dao;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import logic.exceptions.ExistingUsernameException;
import logic.model.User;

public class UserDao {
	private static String name = "progettoFindit";
    private static String pass = "passwfindit2020";
    private static String url = "jdbc:mysql://localhost:3306/findit?useTimezone=true&serverTimezone=UTC";
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    
    private UserDao() {
    	
    }
    
	public static User getUser(String username){
    	
    	User user = User.getIstance();
    	
    	Connection userConn = null;
		Statement userSt = null;
		
    	try {
        	try {
            	Class.forName(driverClassName);
    			userConn = DriverManager.getConnection(url,name,pass);
    			
    			userSt = userConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);
    	    	
    	    	String nameUserQuery = "select name from users where name = '" + username + "'";
    	    	String psswUserQuery = "select pssw from users where name = '" + username + "'";
    	    	String reviewsTableUserQuery = "select reviews from users where name = '" + username + "'";
    	    	String imageUserQuery = "select photo from users where name = '" + username + "'";
    		
    			ResultSet rs = userSt.executeQuery(nameUserQuery);
    		
    			rs.next();
    			
    			if (!rs.first()) {
    				
    				return user;
    			}
    		
    			String nome = rs.getNString("name");
    			
    			user.setUserName(nome);
    			
    			rs.close();
    			
    			ResultSet rs1 = userSt.executeQuery(psswUserQuery);
    		
    			rs1.next();
    		
    			String pssw = rs1.getNString("pssw");
    			
    			user.setUserPassword(pssw);
    		
    			rs1.close();
    			
    			ResultSet rs3 = userSt.executeQuery(reviewsTableUserQuery);
    		
    			rs3.next();
    		
    			String reviewsTable = rs3.getNString("reviews");
    			
    			user.setUserReviewsTable(reviewsTable);
    		
    			rs3.close();
    			
    			ResultSet rs2 = userSt.executeQuery(imageUserQuery);
    			
    			rs2.next();
    			
    			Blob blob = rs2.getBlob("photo");
    			
    			if (blob.length() > 4) {

    				Image img = getImage(blob);
        				
        			user.setUserImage(img);
    				
    			} else {
    				user.setUserImage(null);
    			}
    		
    			rs2.close();
        		
    			user.setUserLogged(true);
        
        	} finally {
        		
        		if (userSt != null) {
        			userSt.close();
        		}
        		
        		if (userConn != null) {
        			userConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
    	
		return user;
    }
	
	public static boolean setUser(String username, String password) throws ExistingUsernameException{
    	
    	
    	Connection userConn = null;
		Statement userSt = null;
		
    	try {
        	try{
            	Class.forName(driverClassName);
    			userConn = DriverManager.getConnection(url,name,pass);
    			
    			userSt = userConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);

    			String reviewsTable = (username + "Review").replaceAll("\\s+","");
    	    	String searchUserQuery = "select name from users where name = '" + username + "'";
    	    	String searchOwnerQuery = "select name from owners where name = '" + username + "'";
    		
    			ResultSet rs = userSt.executeQuery(searchUserQuery);
    			
    			if (!rs.first()) {

    				rs.close();
    				
    				ResultSet rs2 = userSt.executeQuery(searchOwnerQuery);
    				
    				if (!rs2.first()) {

    					rs2.close();
    					
    					java.sql.DatabaseMetaData meta = userConn.getMetaData();

    					String variableReviewsTable = reviewsTable;
    					
    					boolean exist = true;
    					
    					int i=0;
    					
    					while (exist) {
    						ResultSet res = meta.getTables(null, null, variableReviewsTable, null);
    						if (res.next()) {
    							variableReviewsTable = reviewsTable + i;
    							i++;
    						} else {
    							exist = false;
    							reviewsTable = variableReviewsTable;

    							String insertQuery = "insert into users value ('" + username + "','" + password + "','" + reviewsTable + "','" + null + "')";
    					    	String createReviewsQuery = "create table " + reviewsTable + " (structure varchar(20),review text,stars int,dateIn int,dateOut int)";
    				
    					    	userSt.executeUpdate(insertQuery);
    							userSt.executeUpdate(createReviewsQuery);
    						}
    					}

    					return true;
    				} else {
        				throw new ExistingUsernameException("user") ;
        			}
    			} else {
    				throw new ExistingUsernameException("user") ;
    			}
        	} finally {
        		
        		finalCloseUser(userConn, userSt);
        		
        	}
		} catch(ExistingUsernameException e){
			throw e;
	    }catch(Exception a) {
	    	System.exit(1);
	    }
		return false;
    }
	
	private static void finalCloseUser(Connection userConn, Statement userSt) {
		
		if (userSt != null) {
			try {
				userSt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (userConn != null) {
			try {
				userConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void setImage(String username, FileInputStream image){
		
		Connection userConn = null;
		PreparedStatement ps = null;
		
    	try {
        	try {
            	Class.forName(driverClassName);
    			userConn = DriverManager.getConnection(url,name,pass);
    			
    	    	String insertQuery = "UPDATE users SET photo = ? WHERE name = '" + username + "'";
    			
        		userConn.setAutoCommit(false);

        		ps = userConn.prepareStatement(insertQuery);
        		
        		ps.setBinaryStream(1, image);
        		
        		ps.executeUpdate();
        		
        		userConn.commit();
        		
        	} finally {
        		
        		if (userConn != null) {
        			userConn.close();
        		}
        		
        		if (ps != null) {
        			ps.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
	}
	
	private static Image getImage(Blob blob) {
		
		byte[] imageByte = null;
		Image img = null;
		
		try {
			imageByte = blob.getBytes(1, (int) blob.length());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try (InputStream userBinaryStream = new ByteArrayInputStream(imageByte)){

			BufferedImage bf = ImageIO.read(userBinaryStream);
			
			img = SwingFXUtils.toFXImage(bf, null);
			
		} catch(Exception e){
	        System.exit(1);
	    }
		
		return img;
	}
}
