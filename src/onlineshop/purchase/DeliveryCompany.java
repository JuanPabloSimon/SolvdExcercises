package onlineshop.purchase;

import java.util.Objects;

public class DeliveryCompany {
	private String name;
	private int price; 
	private int timeToDeliver;
	private boolean available = true;
	
	// constructor section
		
	public DeliveryCompany(String name) {
		this.name = name;
		if (name == "Andreani") {
			this.price = 10;
			this.timeToDeliver = 5;
		} else if (name == "Correo Argentino") {
			this.price = 15;
			this.timeToDeliver = 3;
		} else {
			System.out.println("Elige entre 'Andreani' y 'Correo Argentino'");
			this.available = false;
		}
	}
	
	
	// end section
	
	// methods section
	
	public boolean isAvailable() {
		return this.available;
	}
	
	// end of section
	
	// getters and setters 
	
	public int getPrice() {
		return this.price;
	}
	
	// end of section


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		DeliveryCompany that = (DeliveryCompany) o;
		return price == that.price && timeToDeliver == that.timeToDeliver && name.equals(that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price, timeToDeliver);
	}

	@Override
	public String toString() {
		return "Delivery Name: " + this.name + " - price: $"
				+ this.price + " - Time to arrive: "
				+ this.timeToDeliver + " days.";
	}
}
