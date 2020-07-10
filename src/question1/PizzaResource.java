package question1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.hsqldb.lib.Set;

@Path("/Pizza")
public class PizzaResource {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
	public List<Pizza> getAllPizza() throws ClassNotFoundException, SQLException{
		return PizzaDao.INSTANCE.getAllPizza();
	}
	
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
	@Path("{PizzaId}")
	public Pizza getPizza(@PathParam("PizzaId") String id) throws Exception{
		return PizzaDao.INSTANCE.getPizza(Integer.parseInt(id));
	}
//	@GET
//	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
//	@Path("{carName}")
//	public car getPizzabyname(@PathParam("carName") String name) throws ClassNotFoundException, SQLException {
//		return carDao.INSTANCE.getcarbyname(name);
//	}
	
	@POST
	@Produces({ MediaType.TEXT_HTML })
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	public void postcar(@FormParam("id") String id,
			@FormParam("name") String name,
			@FormParam("base") String base,
			@FormParam("topping") String topping,
			@Context HttpServletResponse servletResponse) throws IOException, ClassNotFoundException, SQLException {
		System.out.println("Inside POST id = " + id);
		System.out.println("Name = " + name);
		
		Pizza pizza = new Pizza();
		pizza.setId(Integer.parseInt(id));
		pizza.setName(name);
		pizza.setBase(base);
		pizza.setTopping(topping);
		
		PizzaDao.INSTANCE.insertPizza(pizza);
		servletResponse.sendRedirect("../createPizza.html");
		
	}
	
	@DELETE
	@Produces({ MediaType.TEXT_HTML })
	@Path("{PizzaId}")
	public void deletePizza(@PathParam("PizzaId") String id) throws IOException, NumberFormatException, ClassNotFoundException, SQLException {
		System.out.println("Delete id: " + id);
		PizzaDao.INSTANCE.deletePizza(Integer.parseInt(id));
	}
	
	@PUT
	@Produces({ MediaType.TEXT_HTML })
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Path("{PizzaId}")
	public static void putcar(@PathParam("PizzaId") String id,
			@FormParam("name") String name,
			@FormParam("base") String base,
			@FormParam("topping") String topping,
			@Context HttpServletResponse servletResponse) throws IOException, ClassNotFoundException, SQLException {
		System.out.println("PUT id = " + id);
		
		Pizza pizza = new Pizza();
		pizza.setId(Integer.parseInt(id));
		pizza.setName(name);
		pizza.setBase(base);
		pizza.setTopping(topping);		
		PizzaDao.INSTANCE.updatePizza(pizza);
	}
}

