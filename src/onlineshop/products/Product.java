package onlineshop.products;

public class Product {
	private String name;
	private int price;
	private String categorie;
	private String description;
	private int productID;
	
	// constructor section
	public Product(String name, int price, String description, String categorie, int productID) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.categorie = categorie;
		this.productID = productID;
	}
	
	// setters and getters section
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}

	public int getProductID() {
		return this.productID;
	}
	
	// end of section
	
	@Override
	public String toString() {
		return "name: " + this.name + " - price: $" + this.price 
				+ " - id: " + this.productID;
	}
}
