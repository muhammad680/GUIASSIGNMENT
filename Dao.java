package assign;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Dao {
	
	Connection connection;
	
	
	//connecting to the database
	public Dao(){
		
	
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			connection = DriverManager.getConnection("jdbc:odbc:database");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public ArrayList<Cothes> getAllProducts(){
		
		 
		ArrayList<Cothes> allProducts = new ArrayList<Cothes>(30);
			String sql = "SELECT * from clothes";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
			//storing the reuslts
		try {
			while (rs.next())
			{
				allProducts.add(new Cothes(rs.getString("type"), rs.getString("Name"), rs.getFloat("Price"), rs.getString("Imagepath")));
				
				
			}
		} 
		catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	
	
	
	
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Nothing to close"+e.getMessage());
			e.printStackTrace();
		}
		return allProducts;
		
		
	}

}
