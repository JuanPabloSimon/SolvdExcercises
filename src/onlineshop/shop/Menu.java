package onlineshop.shop;

public class Menu {

    private String shopName;

    public Menu(String shopName) {
        this.shopName = shopName;
    }

    // methods section

    public static void mainMenu(String shopName) {
        System.out.println("------------------------");
        System.out.println("Welcome to " + shopName + "\n Pleas Log in to buy, otherwise you wouldn't be able to (Select a number)" +
                            "\n 1. Log In" + "\n 2. SignUp a new account" + "\n 3. Continue without Log In" +
                            "\n 4. Exit Page");
    }

    public static void loggedMenu(String name) {
        System.out.println("------------------------");
        System.out.println("Welcome " + name + ".\n What would you like to do? (Select a number)" +
                            "\n 1. Show products" + "\n 2. Show products in cart" + "\n 3. Finish Purhcase" + "\n 4. LogOut");
    }

    public static void productsMenu() {
        System.out.println("------------------------");
        System.out.println("1. Select Products" + "\n2. See products in the cart" +  "\n3. Go back to Menu" );
    }

    public static void cartMenu() {
        System.out.println("------------------------");
        System.out.println("1 Add more products" + "\n2. Delete product" + "\n3. Finish Purchase" + "\n4. Go back to Menu" );
    }
}
