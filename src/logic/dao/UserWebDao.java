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
import logic.model.UserWeb;

public class UserWebDao {
	
	private static String name = "progettoFindit";
    private static String pass = "passwfindit2020";
    private static String url = "jdbc:mysql://localhost:3306/findit?useTimezone=true&serverTimezone=UTC";
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    
    private UserWebDao() {
    	
    }
	
    public static UserWeb getUserWeb(String username){
    	
    	String nameUserQuery = "select name from users where name = '" + username + "'";
    	String psswUserQuery = "select pssw from users where name = '" + username + "'";
    	String reviewsTableUserQuery = "select reviews from users where name = '" + username + "'";
    	String imageUserQuery = "select photo from users where name = '" + username + "'";
    	
    	UserWeb user = new UserWeb();
    	
    	Connection userWebConn = null;
		Statement userWebSt = null;
		
    	try {
        	try {
            	Class.forName(driverClassName);
    			userWebConn = DriverManager.getConnection(url,name,pass);
    			
    			userWebSt = userWebConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);
    		
    			ResultSet rs = userWebSt.executeQuery(nameUserQuery);
    		
    			rs.next();
    			
    			if (!rs.first()) {
    				
    				return user;
    			}
    		
    			String nome = rs.getNString("name");
    			
    			user.setUsername(nome);
    			
    			rs.close();
    			
    			ResultSet rs1 = userWebSt.executeQuery(psswUserQuery);
    		
    			rs1.next();
    		
    			String pssw = rs1.getNString("pssw");
    			
    			user.setPassword(pssw);
    		
    			rs1.close();
    			
    			ResultSet rs3 = userWebSt.executeQuery(reviewsTableUserQuery);
    		
    			rs3.next();
    		
    			String reviewsTable = rs3.getNString("reviews");
    			
    			user.setReviewsTable(reviewsTable);
    		
    			rs3.close();
    			
    			ResultSet rs2 = userWebSt.executeQuery(imageUserQuery);
    			
    			rs2.next();
    			
    			Blob blobWeb = rs2.getBlob("photo");
    			
    			if (blobWeb.length() > 4) {

    				Image imgWeb = getImage(blobWeb);
    				
    				user.setImage(imgWeb);
    				
    			} else {
    				user.setImage(null);
    			}
    		
    			rs2.close();
        		
    			user.setLogged(true);
        
        	} finally {
        		
        		if (userWebSt != null) {
        			userWebSt.close();
        		}
        		
        		if (userWebConn != null) {
        			userWebConn.close();
        		}
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
    	
		return user;
    }
	
	public static boolean setUser(String username, String password) throws ExistingUsernameException{

		String reviewsTableWeb = (username + "Reviews").replaceAll("\\s+","");
    	String searchUserQuery = "select name from users where name = '" + username + "'";
    	String searchOwnerQuery = "select name from owners where name = '" + username + "'";
    	
    	
    	Connection userWebConn = null;
		Statement userWebSt = null;
		
    	try {
        	try{
            	Class.forName(driverClassName);
    			userWebConn = DriverManager.getConnection(url,name,pass);
    			
    			userWebSt = userWebConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);
    		
    			ResultSet rs = userWebSt.executeQuery(searchUserQuery);
    			
    			if (!rs.first()) {

    				rs.close();
    				
    				ResultSet rs2 = userWebSt.executeQuery(searchOwnerQuery);
    				
    				if (!rs2.first()) {

    					rs2.close();
    					
    					java.sql.DatabaseMetaData meta = userWebConn.getMetaData();

    					String variableReviewsTableWeb = reviewsTableWeb;
    					
    					boolean existWeb = true;
    					
    					int iWeb=0;
    					
    					while (existWeb) {
    						ResultSet res = meta.getTables(null, null, variableReviewsTableWeb, null);
    						if (res.next()) {
    							variableReviewsTableWeb = reviewsTableWeb + iWeb;
    							iWeb++;
    						} else {
    							existWeb = false;
    							reviewsTableWeb = variableReviewsTableWeb;

    							String insertQueryWeb = "insert into users value ('" + username + "','" + password + "','" + reviewsTableWeb + "','" + null + "')";
    					    	String createReviewsQueryWeb = "create table " + reviewsTableWeb + " (structure varchar(20),review text,stars int,dateIn int,dateOut int)";
    				
    					    	userWebSt.executeUpdate(insertQueryWeb);
    							userWebSt.executeUpdate(createReviewsQueryWeb);
    						}
    					}

    					return true;
    				}
    			} else {
    				
    				throw new ExistingUsernameException();    				
    			}
        	} finally {
        		
        		finalCloseUserWeb(userWebConn, userWebSt);
        		
        	}
		} catch(ExistingUsernameException e){
			throw e;
	    }catch(Exception a) {
	    	System.exit(1);
	    }
		return false;
    }
	
	private static void finalCloseUserWeb(Connection userWebConn, Statement userWebSt) {
		
		if (userWebSt != null) {
			try {
				userWebSt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (userWebConn != null) {
			try {
				userWebConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void setImage(String username, FileInputStream image){
		
    	String insertQuery = "UPDATE users SET photo = ? WHERE name = '" + username + "'";
		
		Connection userWebConn = null;
		PreparedStatement ps = null;
		
    	try {
        	try {
            	Class.forName(driverClassName);
    			userWebConn = DriverManager.getConnection(url,name,pass);
    			
        		userWebConn.setAutoCommit(false);
        		
        		ps = userWebConn.prepareStatement(insertQuery);
        		
        		ps.setBinaryStream(1, image);
        		
        		ps.executeUpdate();
        		
        		userWebConn.commit();
        		
        	} finally {
        		
        		if (userWebConn != null) {
        			userWebConn.close();
        		}
        		
        		if (ps != null) {
        			ps.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
	}
	
	private static Image getImage(Blob blobWeb) {
		
		byte[] imageByteWeb = null;
		Image imgWeb = null;
		
		try {
			imageByteWeb = blobWeb.getBytes(1, (int) blobWeb.length());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try (InputStream userBinaryStreamWeb = new ByteArrayInputStream(imageByteWeb)){

			BufferedImage bfWeb = ImageIO.read(userBinaryStreamWeb);
			
			imgWeb = SwingFXUtils.toFXImage(bfWeb, null);
			
		} catch(Exception e){
	        System.exit(1);
	    }
		
		return imgWeb;
	}
}


