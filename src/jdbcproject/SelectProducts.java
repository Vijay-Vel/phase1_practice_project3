package jdbcproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectProducts {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String dburl = "jdbc:mysql://localhost:3306/products_db";
		String username = "root";
		String password = "root";
		
		try {
		Connection con = DriverManager.getConnection(dburl, username, password);
		
		System.out.println("Successfully connected to Database");
		
		String query = "select * from products where product_ID = 106";
		
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		
			
		while(rs.next()) {
			System.out.print(("Product_ID: ") + rs.getString("Product_ID") + "\t");  
			System.out.print(("Product_Name: ")+rs.getString("Product_Name") + "\t");  
			System.out.println(("Amount: ")+rs.getString("Amount"));
		
		}
		
		con.close();
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		

	}
}
