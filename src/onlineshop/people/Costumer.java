package onlineshop.people;

import onlineshop.shop.Cart;
import onlineshop.products.Product;
import onlineshop.purchase.Currency;
import onlineshop.purchase.DeliveryCompany;
import onlineshop.purchase.PaymentMethod;

import java.util.ArrayList;
import java.util.Objects;

public class Costumer extends Person {
	private String username;
	private Cart cart;

	private boolean isInStore = false;
	
	// constructor section
	
	public Costumer(String username, String firstname, String lastname, int age, String email, String address) {
		super(firstname, lastname, age, email, address);
		this.username = username;
		this.cart = new Cart();
	}
	
	// end of section 
	
	// methods section
	
	public void selectProduct(Product product) {
		this.cart.addProduct(product);
	}

	public void deleteProduct(Product product) { this.cart.deleteProduct(product);	}
	
	public void productsInCart() {
		this.cart.listProducts();
	}
	
	public DeliveryCompany selectDelivery(String name) {
		return new DeliveryCompany(name);
	}
	
	
	public PaymentMethod selectPayment(String method) {
		return new PaymentMethod(method);
	}
	
	public Currency selectCurrency(String currencyName) {
		return new Currency(currencyName);
	}


	public int checkPurchase(DeliveryCompany delivery, PaymentMethod method, Currency currency) {
		ArrayList<Product> products = this.cart.getProducts();
		
		if (products.size() > 0) {  // Check if there are products
			int subTotal = 0;
			
			for (Product prod : products) { // calculates the products total value
				int prodPrice = prod.getPrice();
				subTotal += prodPrice;
			}
			System.out.println("Total Products Value: " + currency.getSymbol() + currency.changeOfCurrency(subTotal, currency.getName()));
			
			if (delivery.getPrice() > 0) {  // calculates the delivery price if it was selected
				int deliveryPrice = delivery.getPrice();
				subTotal += deliveryPrice;
				System.out.println("Delivery Total: " + currency.getSymbol()  + currency.changeOfCurrency(deliveryPrice, currency.getName()));
				System.out.println("Subtotal: " + currency.getSymbol()  + currency.changeOfCurrency(subTotal, currency.getName()));
			} else {
				System.out.println("Select a Delivery method between Andreani or Correo Argentino");
			}
			
			if (currency.getName().length() > 0 && currency.isAvailable()) { // change of currency
				Double value = currency.changeOfCurrency(subTotal, currency.getName());
				subTotal = value.intValue();
			}  else {
				System.out.println("Pleas select a valid currency \nOptions: Dolar, Euro, ARS, Pounds");
			}
			
			if (method.getName() == "Debit") { // calculates a discount if it has to.
				int discount = method.getDiscount();
				int total = subTotal - (subTotal / discount);
				System.out.println("Total value: " + currency.getSymbol()  + total);
				return total;
			} else if (method.getName() == "Credit"){
				System.out.println("Total value: " + currency.getSymbol()  + subTotal);
				return subTotal;
			} else {
				System.out.println("Please select a payment method between Credit and Debit");		
				return 0;
			}
			
		} else {
			System.out.println("There are no Products added in the cart");
			return 0;
		}
	}
	// end of section
	
	// getters and setter section
	
	public ArrayList<Product> getProducts() {
		return this.cart.getProducts();
	}
	
	public void setIsInStore(boolean value) {
		this.isInStore = value;
	}

	public String getUsername() {
        return this.username;
    }
	
	// end of section

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Costumer costumer = (Costumer) o;
		return username.equals(costumer.username);
	}

	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public String toString() {
		return "Costumer{" +
				"username='" + this.username + '\'' +
				", cart products=" + this.cart.getProducts() +
				", address='" + getAddress() + '\'' +
				", isInStore='" + isInStore + '\'' +
				'}';
	}
}
