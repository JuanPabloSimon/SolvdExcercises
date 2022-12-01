package onlineshop.shop;
import onlineshop.products.Product;

import java.util.ArrayList;
import java.util.Random;

public class Cart {
	private ArrayList<Product> productsInCart = new ArrayList<>();
	private int cartId;
	Random rand = new Random();
	
	// constructor section 
	public Cart() {
		this.cartId = rand.nextInt(1000);
	}

	// end section
	
	
	// methods section
	
	public void addProduct(Product product) {
		productsInCart.add(product);
	}

	public void deleteProduct(Product product) {
		int findProductId = productsInCart.indexOf(product);
		if (findProductId >= 0) {
			productsInCart.remove(findProductId);
		} else {
			System.out.println("Product not found");
		}
	}
	
	public void listProducts() {
		System.out.println("Products In Cart:");
		for(Product prod : productsInCart) {
			System.out.println("Product: " + prod.getName());
		}
	}
	
	public ArrayList<Product> getProducts() {
		return productsInCart;
	}
	
	// end of section
}

