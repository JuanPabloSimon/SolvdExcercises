package onlineshop.shop;
import onlineshop.products.Product;
import onlineshop.people.Costumer;
import onlineshop.purchase.Currency;
import onlineshop.purchase.DeliveryCompany;
import onlineshop.purchase.Order;
import onlineshop.purchase.PaymentMethod;

import java.util.ArrayList;
import java.util.Scanner;

abstract public class OnlineShop {
	private String name;
	private String storeType;
	private ArrayList<Product> shopProducts = new ArrayList<>();
	private ArrayList<Costumer> costumers = new ArrayList<>();
	private ArrayList<Order> orders = new ArrayList<>();
	private Scanner scanner = new Scanner(System.in);


	// constructor section 

	public OnlineShop(String name, String storeType) {
		this.name = name;
		this.storeType = storeType;
	}

	// end of section

	// methods section

	public void mainMenu() {
		boolean exit = false;
		while (!exit) {
			Menu.mainMenu(this.name);
			int choice = Integer.parseInt(scanner.next());
			switch (choice) {
				case 1:
					System.out.println("Please enter your username");
					String username = scanner.next();
					if (isLogged(username)) {
						logIn(username);
						loggedMenu(username);
					} else {
						System.out.println("First you need to Sign Up.");
						mainMenu();
					}
					break;
				case 2:
					System.out.println("Please enter an username");
					username = scanner.next();
					for (Costumer costumer : costumers) {
						if (costumer.getUsername().equals(username)) {
							System.out.println("You are already logged");
							mainMenu();
						}
					}
					System.out.println("Please enter your firstname");
					String firstName = scanner.next();
					System.out.println("Please enter your lastname");
					String lastName = scanner.next();
					System.out.println("Please enter your age");
					Integer age = scanner.nextInt();
					System.out.println("Please enter your email");
					String email = scanner.next();
					System.out.println("Please enter your address");
					String address = scanner.next();
					signUpCostumer(new Costumer(username, firstName, lastName, age, email, address));
					break;
				case 3:
					System.out.println(getCostumers());
					//DoSomething Here
					break;
				case 4:
					exit = true;
					break;
				default:
					System.out.println("Wrong input");
					break;
			}
		}
	}

	public void loggedMenu(String username) {
		Menu.loggedMenu(getCostumer(username).getName());
		int choice = Integer.parseInt(scanner.next());
		switch (choice) {
			case 1:
				productsMenu(username);
				break;
			case 2:
				cartMenu(username);
				break;
			case 3:
				// this.currentCostumer.checkPurchase();
				break;
			case 4:
				logOut(username);
				mainMenu();
				break;
			default:
				System.out.println("Wrong input");
				break;
		}
	}

	public void productsMenu(String username) {
		listProducts();
		Menu.productsMenu();
		int choice = Integer.parseInt(scanner.next());
		switch (choice) {
			case 1:
				System.out.println("Please write the id of the product");
				int id = Integer.parseInt(scanner.next());
				for (Costumer costumer : costumers) {
					if(costumer.getUsername().equals(username))
						costumer.selectProduct(getProduct(username, id));
						System.out.println("Product Added");
				}
				productsMenu(username);
				break;
			case 2:
				cartMenu(username);
				break;
			case 3:
				loggedMenu(username);
				break;
			default:
				System.out.println("Wrong input");
				break;
		}
	}

	public void cartMenu(String username) {
		ArrayList<Product> products = getCostumer(username).getProducts();
		if (products.size() > 0) {
			getCostumer(username).productsInCart();
		} else {
			System.out.println("No products added");
		}
		Menu.cartMenu();
		int choice = Integer.parseInt(scanner.next());
		switch (choice) {
			case 1:
				productsMenu(username);
				break;
			case 2:
				System.out.println("Please write the id of the product you'd like to delete");
                int id = Integer.parseInt(scanner.next());
				for (Costumer costumer : costumers) {
					if (costumer.getUsername().equals(username))
						costumer.deleteProduct(getProduct(username, id));
				}
				System.out.println("Product Deleted");
				cartMenu(username);
				break;
			case 3:
				// this.currentCostumer.checkPurchase();
				break;
			case 4:
				loggedMenu(username);
				break;
		}
	}


	public void signUpCostumer(Costumer costumer) {
		costumers.add(costumer);
		logIn(costumer.getUsername());
	} // Overload this method

	public void logIn(String username) {
		for ( Costumer costumer : costumers) {
			if(costumer.getUsername().equals(username))
				 costumer.setIsInStore(true);
		}
	}

	public void logOut(String username) {
		for ( Costumer costumer : costumers) {
			if (costumer.getUsername().equals(username))
				costumer.setIsInStore(false);
		}
	}
	
	public boolean isLogged(String username) {
		for ( Costumer costumer : costumers) {
			if (costumer.getUsername().equals(username)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public void addStoreProduct(Product product) {
			shopProducts.add(product);			
	}
	
	public void listProducts() {
		System.out.println("Products Available: ");
		for(Product prod : shopProducts) {
			System.out.println( " -" + prod);
		}	
	}
	
	/*public void createOrder(DeliveryCompany deliveryCompany, PaymentMethod payMethod, int totalValue, ArrayList<Product> products, Currency currency) {
		if (this.isLogged(this.currentCostumer.getUsername())) {
			Order order = new Order(this.currentCostumer, deliveryCompany, payMethod, totalValue, products, currency);
			orders.add(order);	
			System.out.println("Order Created and sent \n" + order.getOrder());
		} else {
			System.out.println("You need to be logged for this");
		}
	}*/
	
	// end of section 
	
	// getters and setters
	
	public String getName() {
		return this.name;
	}
	
	
	public Product getProduct(String username, int productID) {
		if (this.isLogged(username)) {
			for (Product product : shopProducts) {
				if(product.getProductID() == productID) {
					return product;
				}
			}
		}
		System.out.println("Please LogIn");
		return null;
	}
	
	public ArrayList<Costumer> getCostumers() {
		return costumers;
	}

	public Costumer getCostumer(String username) {
		for (Costumer costumer : costumers) {
			if(costumer.getUsername().equals(username))
				return costumer;
		}
		return null;
	}

	public ArrayList<Product> getShopProducts() {
		return shopProducts;

	}
	// end of section 
	
}
