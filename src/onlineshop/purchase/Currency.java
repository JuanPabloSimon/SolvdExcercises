package onlineshop.purchase;

public class Currency {
	private String name;
	private boolean available = true;
	private String currencySymbol;
	
	
	
	// constructor section 
	public Currency(String name) {
		this.name = name; 
		if (name == "Dolar" || name == "Euro" || name == "ARS" || name == "Pounds") {
			System.out.println("You have selected " + this.name + " as the currency for this purchase");
		} else {
			System.out.println("Pleas select a valid currency \nOptions: Dolar, Euro, ARS, Pounds");
			this.available = false;
		}

		switch(name) {
			case "Dolar" : this.currencySymbol = "$";
			break;
			case "Euro" : this.currencySymbol = "€";
			break;
			case "ARS" : this.currencySymbol = "ARS$";
			break;
			case "Pounds" : this.currencySymbol = "£";
			break;
		}

	}
	// end of section
	
	// methods section 
	
	public boolean isAvailable() {
		return this.available;
	}

	public Double changeOfCurrency(double initialValue, String currencyFinal) {
		switch(currencyFinal) {
			case "Dolar": return initialValue;
			case "Euro" : return initialValue * 0.98;
			case "ARS"  : return initialValue * 163.18;
			case "Pounds": return initialValue * 0.85;
			default: return initialValue;
		}
	}
	
	//end of section
	
	// getters and setters	
	
	public String getName() {
		return this.name;
	}
	
	public String getSymbol() {
		return this.currencySymbol;
	}
	
	// end of section 
	
	 @Override 
	 public String toString() {
		 return this.name;
	 }
}
