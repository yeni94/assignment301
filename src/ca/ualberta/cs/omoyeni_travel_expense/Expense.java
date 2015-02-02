package ca.ualberta.cs.omoyeni_travel_expense;

public class Expense {
	protected String name;
	protected float price;
	protected String currency;
	

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	
	
	
}
