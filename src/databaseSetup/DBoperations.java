package databaseSetup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBoperations {

	public int createdata() throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "");
		Statement stmt = conn.createStatement();
		int res =0;
		
		try {
			stmt.executeUpdate("CREATE TABLE Pizza( Id INTEGER IDENTITY PRIMARY KEY, Name varchar(30) NOT NULL, Base varchar(30) NOT NULL, Topping varchar(30) NOT NULL)");
		    res =1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
      System.out.println("done");
	return res;
	}
	public int deldata() throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "");
		Statement stmt = conn.createStatement();
		int res =0;
		try {
			stmt.executeUpdate("DELETE FROM Pizza");
			res =1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
      System.out.println("done");
	return res;
	}
	public int filldata() throws Exception {
		Connection conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/oneDB", "SA", "");
		Statement stmt = conn.createStatement();
		int res =0;
		try {
			stmt.executeUpdate("INSERT INTO Pizza VALUES (NULL, 'Margherita', 'Cheese Burst' , 'Oregano')");
			stmt.executeUpdate("INSERT INTO Pizza VALUES (NULL, 'Pizza al Pesto', 'Thin Crust' , 'Extra Cheese')");
			stmt.executeUpdate("INSERT INTO Pizza VALUES (NULL, 'Mediterranea', 'Pan Base' , 'Popcorn Chicken')");
			stmt.executeUpdate("INSERT INTO Pizza VALUES (NULL, 'Vegetarian', 'Cheese Burst' , 'Olives')");
			stmt.executeUpdate("INSERT INTO Pizza VALUES (NULL, 'Chicken tikka', 'Cheese Burst' , 'Onion')");
			stmt.executeUpdate("INSERT INTO Pizza VALUES (NULL, 'Seafood', 'Thin Crust' , 'Oyester')");
			stmt.executeUpdate("INSERT INTO Pizza VALUES (NULL, 'Ham & Pineapple', 'Pan Base' , 'Chilli Flakes')");
			res =1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
      System.out.println("done");
      return res;
	}

}
