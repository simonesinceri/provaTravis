package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import logic.model.Structure;

public class StructureDao {
	
	private static String name = "progettoFindit";
    private static String pass = "passwfindit2020";
    private static String url = "jdbc:mysql://localhost:3306/findit?useTimezone=true&serverTimezone=UTC";
    private static String driverClassName = "com.mysql.cj.jdbc.Driver";
    
    private StructureDao() {
    	
    }
    
    public static Structure getStructure(String structureTable, int index){

		Structure structure = new Structure();
		
		Connection structureConn = null;
		Statement structureSt = null;

    	try {
        	try{
            	Class.forName(driverClassName);
    			structureConn = DriverManager.getConnection(url,name,pass);
    			
    			structureSt = structureConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);

    			String nameQuery = "select name from " + structureTable;
    		
    			ResultSet rs = structureSt.executeQuery(nameQuery);
    			
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
        		
        		if (structureSt != null) {
        			structureSt.close();
        		}
        		
        		if (structureConn != null) {
        			structureConn.close();
        		}
    			
        	}
		} catch(Exception e){
	        System.exit(1);
	    }
		return structure;
	}
	
	public static void setStructure(String structureTable, String structureName, String type){
        
    	Connection structureConn = null;
		Statement structureSt = null;
		
    	try {
        	try{
            	Class.forName(driverClassName);
    			structureConn = DriverManager.getConnection(url,name,pass);
    			
    			structureSt = structureConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);
    			
    			String insertQuery = "insert into " + structureTable + " value ('" + structureName + "','" + type + "')";
    				    	
    			structureSt.executeUpdate(insertQuery);
    			
        	} finally {
        		
        		if (structureSt != null) {
        			structureSt.close();
        		}
        		
        		if (structureConn != null) {
        			structureConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	        }
    }
	
	public static int getStructures(String structureTable){
		
		Connection structureConn = null;
		Statement structureSt = null;
		
    	int i = 0;
		try {
        	try{
            	Class.forName(driverClassName);
    			structureConn = DriverManager.getConnection(url,name,pass);
    			
    			structureSt = structureConn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	                ResultSet.CONCUR_READ_ONLY);
    			
    			String numQuery = "select count(*) from " + structureTable;
    				    	
    			ResultSet rs = structureSt.executeQuery(numQuery);
    			rs.next();
    			i = rs.getInt("count(*)");
    			rs.close();
    			
        	} finally {
        		
        		if (structureSt != null) {
        			structureSt.close();
        		}
        		
        		if (structureConn != null) {
        			structureConn.close();
        		}
        		
        	}
		} catch(Exception e){
	        System.exit(1);
	        }
		
		return i;
	}
}
