package onlineshop.purchase;

import onlineshop.people.Costumer;
import onlineshop.products.Product;

import java.util.ArrayList;

public class Order {
	private DeliveryCompany deliveryCompany;
	private PaymentMethod payMethod;
	private int totalValue;
	private ArrayList<Product> products = new ArrayList<>();
	private Costumer costumer;
	private Currency currency;
	
	// constructor section
		
	public Order(Costumer costumer, DeliveryCompany deliveryCompany, PaymentMethod payMethod, int totalValue, ArrayList<Product> products, Currency currency) {
		this.deliveryCompany = deliveryCompany;
		this.costumer = costumer;
		this.payMethod = payMethod;
		this.totalValue = totalValue ;
		this.products = products;
		this.currency = currency;
		}
	
	// end of section
	
	// methods section
	
	public void listProducts() {
		for(Product prod : products) {
			System.out.println("Product: " + prod.getName());
		}
	}
	
	// end of section 
	
	// getters and setters 
	
	public Order getOrder() {
		return this;
	}
	
	public int getTotal() {
		return this.totalValue;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	// end of section
	
	@Override 
	public String toString() {
		return "Costumer Name: " + costumer.getName() + "\nCostumer adress: " + costumer.getAddress()
				+ "\n Products: " + products + "\n Delivery Company: " + deliveryCompany + "\n Payment: "
				+ payMethod + "\n Currency selected: " + this.currency.getName() + "\n Total Value in the selected currency: " + currency.getSymbol() + totalValue;
	}
	
	
}
