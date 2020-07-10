
package question1;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Pizza")
@XmlType(propOrder = { "id", "name", "base", "topping"})
public class Pizza {
	

	private int id;
	private String name;
	private String base;
	private String topping;
	
	public Pizza() {}
	public Pizza(int id,String name, String base,String topping) {
		super();
		this.id =id;
		this.name = name;
		this.base = base;
		this.topping = topping;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getTopping() {
		return topping;
	}
	public void setTopping(String topping) {
		this.topping = topping;
	}
	
}
