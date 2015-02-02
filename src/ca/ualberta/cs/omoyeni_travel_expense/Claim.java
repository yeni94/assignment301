package ca.ualberta.cs.omoyeni_travel_expense;

import java.util.ArrayList;
import java.util.Collection;

public class Claim {
	protected ArrayList<Expense> listOfExpenses;
	protected String name;
	protected Float total;
	
	
	public Claim(){
		this.listOfExpenses = new ArrayList<Expense>();
	}
	
	//public void setClaimName(String string) {
	public Claim(String string) {
		this.name = string;
	}
	
	public String getClaimName() {
		return name;
	}

	public Collection<Expense> getExpensesofClaim(){
		return listOfExpenses;
	}
	
	public void addExpense(Expense expense){
		listOfExpenses.add(expense);
	}
	
	public void deleteExpense(Expense expense){
		listOfExpenses.remove(expense);
	}
	
	public int size(){
		return listOfExpenses.size();
	}
	
	public void computeTotal(){
		//first separate the different types of currencies
		ArrayList<String> currlist = new ArrayList<String>(); //list to store currency type e.g CAD
		currlist.add(listOfExpenses.get(0).getCurrency());  //add the currency of the first expense of claim
		
		ArrayList<Float> totals = new ArrayList<Float>(); //list to store totals of expenses
		totals.add(listOfExpenses.get(0).getPrice());     //price of first expense added
		
		for(int i = 1; i < listOfExpenses.size(); i++){  //loop through arraylist of expenses
			for (int j = 0; j < currlist.size(); j++){   //loop through 
				if (listOfExpenses.get(i).getCurrency() == currlist.get(j)){
					Float calculate = totals.get(j);
					calculate += listOfExpenses.get(i).getPrice();
					totals.set(j, calculate);
				} else {
					currlist.add(listOfExpenses.get(i).getCurrency());
				}
			}
		}
	}

	public void addClaim(String claim2) {
		this.name = claim2;
		
	}
		

}
