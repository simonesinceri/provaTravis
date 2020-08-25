package web_2.logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import web_2.logic.model.Structure;

public class StructureDao {
	
	private static String name = "progettoFindit";
    private static String pass = "passwfindit2020";
    private static String url = "jdbc:mysql://localhost:3306/findit?useTimezone=true&serverTimezone=UTC";
    private static String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    /*
    public static void main(String[] args) {
    	
    	Structure structure = new Structure();
    	
    	try {
    		
			setStructure("ownerStructures", "Tor Vergata1", "hotel");
			setStructure("ownerStructures", "Tor Vergata2", "hotel");
			setStructure("ownerStructures", "Tor Vergata3", "hotel");
			setStructure("ownerStructures", "Tor Vergata4", "hotel");
			setStructure("ownerStructures", "Tor Vergata6", "hotel");
			setStructure("ownerStructures", "Tor Vergata7", "hotel");
			setStructure("ownerStructures", "Tor Vergata8", "hotel");
			setStructure("ownerStructures", "Tor Vergata9", "hotel");
			setStructure("ownerStructures", "Tor Vergata10", "hotel");
			setStructure("ownerStructures", "Tor Vergata11", "hotel");
			setStructure("ownerStructures", "Tor Vergata12", "hotel");
			setStructure("ownerStructures", "Tor Vergata13", "hotel");
			setStructure("ownerStructures", "Tor Vergata14", "hotel");
			setStructure("ownerStructures", "Tor Vergata15", "hotel");
			setStructure("ownerStructures", "Tor Vergata16", "hotel");
			setStructure("ownerStructures", "Tor Vergata17", "hotel");
			
			structure = getStructure("ownerStructures", 3);
    		
    		System.out.println("--- " + structure.getName());
    		
		} catch (Exception e) {
	        System.out.println("# DB error! #");
	        System.out.println(e);
		}
    }
    */
    public static Structure getStructure(String structureTable, int index) throws Exception{

		String nameQuery = "select name from " + structureTable;


		Structure structure = new Structure();
		
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
				return structure;
			}
			
			for (int i=1; i<index; i++) {
				if (!rs.next()) {
					return structure;
				}
			}
		
			String nome = rs.getNString("name");
			structure.setName(nome);
			rs.close();
			
    	} finally {
    		
    		st.close();
    		con.close();
			
    	}
		return structure;
	}
	
	public static void setStructure(String structureTable, String structureName, String type) throws Exception{
        
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
			
			String insertQuery = "insert into " + structureTable + " value ('" + structureName + "','" + type + "')";
				    	
			st.executeUpdate(insertQuery);
			
    	} finally {
    		
    		st.close();
    		con.close();
    		
    	}
    }
	
	public static int getStructures(String structureTable) throws Exception {
		
		String numQuery = "select count(*) from " + structureTable;
		
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
}
