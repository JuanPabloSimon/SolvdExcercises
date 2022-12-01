package onlineshop.people;

public class Person {
	private String name;
	private int age;
	private String email;
	private String address;
	
	// constructor section
	public Person(String firstName, String lastName, int age, String email, String address) {
		this.name = firstName + ' ' + lastName;
		this.age = age;
		this.email = email;
		this.address = address;
	}
	
	// end of section
	
	// setters and getters section
	public String getName() {
		return this.name;
	}
	public String getAddress() {
		return this.address;
	}
	// end of section 
}
