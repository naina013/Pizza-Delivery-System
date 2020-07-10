package question1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hsqldb.lib.HashSet;
import org.hsqldb.lib.Set;

import databaseSetup.connection;

public enum PizzaDao {
  INSTANCE;
	
	connection conn = new connection();
	
	
	private PizzaDao() {
		
		
	}
	private Pizza extractPizzaFromResultSet(ResultSet rs) throws SQLException {

	    Pizza pizza = new Pizza();

	    pizza.setId( rs.getInt("id") );

	    pizza.setName( rs.getString("name") );

	    pizza.setBase( rs.getString("base") );

	    pizza.setTopping( rs.getString("topping") );

	    return pizza;

	}


	public Pizza getPizza(int id) throws ClassNotFoundException, SQLException {

	    Connection connection = conn.getConnection();

	    try {

	        Statement stmt = connection.createStatement();

	        ResultSet rs = stmt.executeQuery("SELECT * FROM Pizza WHERE Id=" + id);

	        if(rs.next())

	        {

	            return extractPizzaFromResultSet(rs);

	        }

	    } catch (SQLException ex) {

	        ex.printStackTrace();

	    }

	    return null;

	}
	
	public List<Pizza> getAllPizza() throws ClassNotFoundException, SQLException {

	   

	    Connection connection = conn.getConnection();

	    try {

	        Statement stmt = connection.createStatement();

	        ResultSet rs = stmt.executeQuery("SELECT * FROM Pizza");

	        List<Pizza> s = new ArrayList<Pizza>();

	        while(rs.next())

	        {

	            Pizza pizzas = extractPizzaFromResultSet(rs);

	            s.add(pizzas);

	        }

	        return s;

	    } catch (SQLException ex) {

	        ex.printStackTrace();

	    }

	    return null;

	}
	public boolean insertPizza(Pizza pizza) throws ClassNotFoundException, SQLException {

	    

	    Connection connection = conn.getConnection();

	    try {

	        PreparedStatement ps = connection.prepareStatement("INSERT INTO Pizza VALUES (NULL, ?, ?, ?)");

	        ps.setString(1, pizza.getName());

	        ps.setString(2, pizza.getBase());

	        ps.setString(3, pizza.getTopping());

	        int i = ps.executeUpdate();

	      if(i == 1) {

	        return true;

	      }

	    } catch (SQLException ex) {

	        ex.printStackTrace();

	    }

	    return false;

	}
	public boolean updatePizza(Pizza pizza) throws ClassNotFoundException, SQLException {



	    Connection connection = conn.getConnection();

	    try {

	        PreparedStatement ps = connection.prepareStatement("UPDATE Pizza SET Name=?, Base=?, Topping=? WHERE Id=?");

	        ps.setString(1, pizza.getName());

	        ps.setString(2, pizza.getBase());

	        ps.setString(3, pizza.getTopping());

	        ps.setInt(4, pizza.getId());

	        int i = ps.executeUpdate();

	      if(i == 1) {

	    return true;

	      }

	    } catch (SQLException ex) {

	        ex.printStackTrace();

	    }

	    return false;

	}
	public boolean deletePizza(int id) throws ClassNotFoundException, SQLException {



	    Connection connection = conn.getConnection();

	    try {

	        PreparedStatement stmt = connection.prepareStatement("DELETE FROM Pizza WHERE Id=" + id);

	        int i = stmt.executeUpdate();

	      if(i == 1) {

	    return true;

	      }

	    } catch (SQLException ex) {

	        ex.printStackTrace();

	    }

	    return false;

	}
	
	
	
}
