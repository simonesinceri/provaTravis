package web_2.logic.dao;

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
import web_2.logic.model.Owner;

public class OwnerDao {
	private static String name = "progettoFindit";
    private static String pass = "passwfindit2020";
    private static String url = "jdbc:mysql://localhost:3306/findit?useTimezone=true&serverTimezone=UTC";
    private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    
	public static Owner getOwner(String username) throws Exception{
    	
    	String nameOwnerQuery = "select name from owners where name = '" + username + "'";
    	String psswOwnerQuery = "select pssw from owners where name = '" + username + "'";
    	String structuresOwnerQuery = "select structures from owners where name = '" + username + "'";
    	String imageUserQuery = "select photo from owners where name = '" + username + "'";
    	
    	Owner owner = new Owner();
    	
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
		
			ResultSet rs = st.executeQuery(nameOwnerQuery);
		
			rs.next();
		
			// CHECK SE NON C'E' L'OWNER
			if (!rs.first()) {
				return owner;
			}
		
			String nome = rs.getNString("name");
			
			owner.setUsername(nome);
			
			rs.close();
			
			ResultSet rs1 = st.executeQuery(psswOwnerQuery);
		
			rs1.next();
		
			String pssw = rs1.getNString("pssw");

			owner.setPassword(pssw);
		
			rs1.close();
			
			ResultSet rs2 = st.executeQuery(structuresOwnerQuery);
			
			rs2.next();
		
			String structures = rs2.getNString("structures");

			owner.setStructures(structures);
		
			rs2.close();
			
			ResultSet rs3 = st.executeQuery(imageUserQuery);
			
			rs3.next();
			
			Blob blob = rs3.getBlob("photo");
			
			if (blob.length() > 4) {
				
				byte[] imageByte = blob.getBytes(1, (int) blob.length());
				
				InputStream binaryStream = new ByteArrayInputStream(imageByte);
				
				BufferedImage bf = ImageIO.read(binaryStream);
				
				Image  img = SwingFXUtils.toFXImage(bf, null);
				
				owner.setImage(img);
			} else {
				owner.setImage(null);
			}
		
			rs3.close();
    		
			owner.setLogged(true);
    
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
    	
		return owner;
    }
	
	public static boolean setOwner(String username, String password) throws Exception{
		
		String structuresTable = (username + "Structures").replaceAll("\\s+","");

    	String searchOwnerQuery = "select name from owners where name = '" + username + "'";
    	String searchUserQuery = "select name from users where name = '" + username + "'";
    	
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
		
			ResultSet rs = st.executeQuery(searchOwnerQuery);
			
			if (!rs.first()) {

				rs.close();
				
				ResultSet rs2 = st.executeQuery(searchUserQuery);
				
				if (!rs2.first()) {

					rs2.close();
					
					//CERCA NEL DB TABELLE PER ROOMS E AGENDA CON LO STESSO NOME
					java.sql.DatabaseMetaData meta = con.getMetaData();

					String variableStructuresTable = structuresTable;
					
					boolean exist = true;
					
					int i=0;
					
					while (exist == true) {
						ResultSet res = meta.getTables(null, null, variableStructuresTable, null);
						if (res.next()) {
							variableStructuresTable = structuresTable + i;
							i++;
						} else {
							exist = false;
							structuresTable = variableStructuresTable;

					    	String insertQuery = "insert into owners value ('" + username + "','" + password + "','" + structuresTable + "','" + null + "')";
					    	String createStructureQuery = "create table " + structuresTable + " (name varchar(20))";
							
							st.executeUpdate(insertQuery);

							st.executeUpdate(createStructureQuery);
						}
					}					
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
	
	public static void setImage(String username, FileInputStream image) throws Exception{
		
    	String insertQuery = "UPDATE owners SET photo = ? WHERE name = '" + username + "'";
		
		Connection con = null;
		
    	try {
    		Class.forName(DRIVER_CLASS_NAME);
    		try{
				con = DriverManager.getConnection(url,name,pass);
			} catch(SQLException e){
		        System.out.println("Couldn't connect: exit.");
		        System.exit(1);
		        }
			
    		con.setAutoCommit(false);
    		
    		PreparedStatement ps = con.prepareStatement(insertQuery);
    		
    		ps.setBinaryStream(1, image);
    		
    		ps.executeUpdate();
    		
    		con.commit();
    		
    	} finally {
    		
    		con.close();
    		
    	}
	}
	
	public static void setStructure(String username, String structure) throws Exception{
		
		String table = (username + "Structures").replaceAll("\\s+","");
		
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
    		
        	String insertQuery = "insert into " + table + " value ('" + structure + "')";
		
			st.executeUpdate(insertQuery);
			
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
	}
}
