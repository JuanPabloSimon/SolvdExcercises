package onlineshop;


import onlineshop.people.Costumer;
import onlineshop.products.Product;
import onlineshop.purchase.Currency;
import onlineshop.purchase.DeliveryCompany;
import onlineshop.purchase.PaymentMethod;
import onlineshop.shop.OnlineShop;
import onlineshop.shop.TechShop;

public class Main {
	public static void main(String[] args) {

		// Products instantiation 

		Product product1 = new Product("Iphone 14", 1500, "Some description", "SmartPhones", 0);
		Product product2 = new Product("Iphone 13", 1100, "Some description", "SmartPhones", 1);
		Product product3 = new Product("Iphone 12", 900, "Some description", "SmartPhones", 2);

		// Shop instantiation 

		OnlineShop shop = new TechShop("Apple", "Technology Shop");
		Costumer costumer = new Costumer("JohnS", "John", "Smith", 22, "john@mail.com", "Street 1 345");

		shop.addStoreProduct(product2);    // three products added to the store
		shop.addStoreProduct(product3);

		shop.signUpCostumer(costumer); // costumer logged in the page

		shop.mainMenu();

		// System.out.println(shop.getProduct(2));
		
				
		/*shop.addStoreProduct(product1);
		shop.addStoreProduct(product2);    // three products added to the store
		shop.addStoreProduct(product3);
		
		System.out.println(shop.getName());
		System.out.println("Products of the store: ");
		shop.listProducts(); 
		
		System.out.print("-------------------\n");*/
		
		/*// Costumer instantiation
		
		Costumer costumer = new Costumer("John_123", "John", "Smith", 22, "john@mail.com", "Street 1 345");
		
		shop.logInCostumer(costumer); // costumer logged in the page 
		
		costumer.selectProduct(shop.getProduct(product1));
		costumer.selectProduct(shop.getProduct(product2)); // two products selected from the cart
		costumer.deleteProduct(shop.getProduct(product2)); // one product eliminated from the cart
		System.out.println("Products Selected: "); 
		costumer.productsInCart();
		
		DeliveryCompany delivery = costumer.selectDelivery("Andreani"); // Delivery Company Selected
		
		if (delivery.isAvailable()) {
			System.out.println(delivery);	// only prints if it's a correct option
		}
		
		PaymentMethod payment = costumer.selectPayment("Debit"); // Payment Method Selected
		
		if (payment.isAvailable()) {
			System.out.println(payment);	// only prints if it's a correct option		
		}
		
		Currency currency = costumer.selectCurrency("ARS"); // Currency selected
		
		System.out.println("----------------------\nFinal Values");
		
		int total = costumer.checkPurchase(delivery, payment, currency); // Checks the values and return a total cost
		
		System.out.println("----------------------\n Order");
		
		shop.createOrder(delivery, payment, total, costumer.getProducts(), currency); // Create an order and save it in an array of orders proper of the Shop*/
	}
}
