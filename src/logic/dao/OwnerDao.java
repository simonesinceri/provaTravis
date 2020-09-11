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
import logic.exceptions.ExistingOwnerException;
import logic.model.Owner;
import logic.model.OwnerWeb;

public class OwnerDao {
	private static String name = "progettoFindit";
    private static String pass = "passwfindit2020";
    private static String url = "jdbc:mysql://localhost:3306/findit?useTimezone=true&serverTimezone=UTC";
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    
    private OwnerDao() {
    	
    }
    
    public static Owner getOwner(String username){
    	
    	Owner owner = Owner.getIstance();
    	
    	OwnerWeb ownerApp = getOwnerWeb(username) ;
    	
    	if(ownerApp.getUsername() != null) {
    		owner.setOwnerUsername(ownerApp.getUsername());
    		owner.setOwnerPassword(ownerApp.getPassword());
    		owner.setOwnerImage(ownerApp.getImage());
    		owner.setOwnerStructures(ownerApp.getStructures());
    		owner.setOwnerLogged(true);
    	}
    	
    	return owner;
    }
    
    public static OwnerWeb getOwnerWeb(String username){
    	
    	String nameOwnerQuery = "select name from owners where name = '" + username + "'";
    	String psswOwnerQuery = "select pssw from owners where name = '" + username + "'";
    	String structuresOwnerQuery = "select structures from owners where name = '" + username + "'";
    	String imageUserQuery = "select photo from owners where name = '" + username + "'";
    	
    	OwnerWeb owner = new OwnerWeb();
    	
    	Connection ownerConn = null;
		Statement ownerSt = null;
		
    	try {
        	try {
            	Class.forName(driverClassName);
    			ownerConn = DriverManager.getConnection(url,name,pass);
    			
    			ownerSt = ownerConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);
    		
    			ResultSet rs = ownerSt.executeQuery(nameOwnerQuery);
    		
    			rs.next();
    		
    			if (!rs.first()) {
    				return owner;
    			}
    		
    			String nome = rs.getNString("name");
    			
    			owner.setUsername(nome);
    			
    			rs.close();
    			
    			ResultSet rs1 = ownerSt.executeQuery(psswOwnerQuery);
    		
    			rs1.next();
    		
    			String pssw = rs1.getNString("pssw");

    			owner.setPassword(pssw);
    		
    			rs1.close();
    			
    			ResultSet rs2 = ownerSt.executeQuery(structuresOwnerQuery);
    			
    			rs2.next();
    		
    			String structures = rs2.getNString("structures");

    			owner.setStructures(structures);
    		
    			rs2.close();
    			
    			ResultSet rs3 = ownerSt.executeQuery(imageUserQuery);
    			
    			rs3.next();
    			
    			Blob blobOwner = rs3.getBlob("photo");
    			
    			if (blobOwner.length() > 4) {

    				Image imgOwner = getImage(blobOwner);
    				
    				owner.setImage(imgOwner);
    				
    			} else {
    				owner.setImage(null);
    			}
    		
    			rs3.close();
        		
    			owner.setLogged(true);
        
        	} finally {
        		
        		if (ownerSt != null) {
        			ownerSt.close();
        		}
        		
        		if (ownerConn != null) {
        			ownerConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
    	
		return owner;
    }
	
	public static boolean setOwner(String username, String password) throws ExistingOwnerException{
		
		String structuresTable = (username + "Structures").replaceAll("\\s+","");

    	String searchOwnerQuery = "select name from owners where name = '" + username + "'";
    	String searchUserQuery = "select name from users where name = '" + username + "'";
    	
    	Connection ownerConn = null;
		Statement ownerSt = null;
		
    	try {
        	try {
            	Class.forName(driverClassName);
    			ownerConn = DriverManager.getConnection(url,name,pass);
    			
    			ownerSt = ownerConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);
    		
    			ResultSet rs = ownerSt.executeQuery(searchOwnerQuery);

    			if (!rs.first()) {

    				rs.close();
    				
    				ResultSet rs2 = ownerSt.executeQuery(searchUserQuery);
    				
    				if (!rs2.first()) {

    					rs2.close();
    					
    					java.sql.DatabaseMetaData meta = ownerConn.getMetaData();

    					String variableStructuresTable = structuresTable;
    					
    					boolean exist = true;
    					
    					int i=0;
    					
    					while (exist) {
    						ResultSet res = meta.getTables(null, null, variableStructuresTable, null);
    						if (res.next()) {
    							variableStructuresTable = structuresTable + i;
    							i++;
    						} else {
    							exist = false;
    							structuresTable = variableStructuresTable;

    					    	String insertQuery = "insert into owners value ('" + username + "','" + password + "','" + structuresTable + "','" + null + "')";
    					    	String createStructureQuery = "create table " + structuresTable + " (name varchar(20))";
    							
    							ownerSt.executeUpdate(insertQuery);

    							ownerSt.executeUpdate(createStructureQuery);
    						}
    					}					
    					return true;
    				} else {
            			
        				throw new ExistingOwnerException("owner");
        			}
    			} else {
    			
    				throw new ExistingOwnerException("owner");
    			}
        	} finally {
        		
        		finalCloseOwner(ownerConn, ownerSt);
        		
        	}
    	}catch(ExistingOwnerException e) {
    		throw e;
    	} catch(Exception a){
	        System.exit(1);
	    }
		return false;
    }
	
	private static void finalCloseOwner(Connection ownerConn, Statement ownerSt) {
		
		if (ownerSt != null) {
			try {
				ownerSt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (ownerConn != null) {
			try {
				ownerConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void setImage(String username, FileInputStream image){
		
		Connection ownerConn = null;
		PreparedStatement ps = null;
		
    	try {
        	try {
            	Class.forName(driverClassName);
    			ownerConn = DriverManager.getConnection(url,name,pass);
    			
    	    	String insertQuery = "UPDATE owners SET photo = ? WHERE name = '" + username + "'";
    			
        		ownerConn.setAutoCommit(false);
        		
        		ps = ownerConn.prepareStatement(insertQuery);
        		
        		ps.setBinaryStream(1, image);
        		
        		ps.executeUpdate();
        		
        		ownerConn.commit();
        		
        	} finally {
        		
        		if (ps != null) {
        			ps.close();
        		}
        		
        		if (ownerConn != null) {
        			ownerConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
	}
	
	public static void setStructure(String username, String structure){
		
		Connection ownerConn = null;
		Statement ownerSt = null;
		
    	try {
        	try {
            	Class.forName(driverClassName);
    			ownerConn = DriverManager.getConnection(url,name,pass);

        		ownerSt = ownerConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);
        		
        		String table = (username + "Structures").replaceAll("\\s+","");
        		
            	String insertQuery = "insert into " + table + " value ('" + structure + "')";
            	
            	String searchQuery = "select name from " + table + " where name = '" + structure + "'";
    		
            	ResultSet rs = ownerSt.executeQuery(searchQuery);
    			
    			if (!rs.first()) {

    				rs.close();
            	
    				ownerSt.executeUpdate(insertQuery);
    			}
    			
        	} finally {
        		
        		if (ownerSt != null) {
        			ownerSt.close();
        		}
        		
        		if (ownerConn != null) {
        			ownerConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
	}
	
	private static Image getImage(Blob blobOwner) {
		
		byte[] imageByteOwner = null;
		Image imgOwner = null;
		
		try {
			imageByteOwner = blobOwner.getBytes(1, (int) blobOwner.length());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try (InputStream userBinaryStreamOwner = new ByteArrayInputStream(imageByteOwner)){

			BufferedImage bfOwner = ImageIO.read(userBinaryStreamOwner);
			
			imgOwner = SwingFXUtils.toFXImage(bfOwner, null);
			
		} catch(Exception e){
	        System.exit(1);
	    }
		
		return imgOwner;
	}
}
