package ca.ualberta.cs.omoyeni_travel_expense;

import java.util.ArrayList;
import java.util.Collection;

public class ClaimsList {
	
	protected ArrayList<Claim> claimList;
	protected ArrayList<Listener> listeners;
	
	public ClaimsList(){
		claimList = new ArrayList<Claim>();
		listeners = new ArrayList<Listener>();
	}

	public Collection<Claim> getClaims() {
		return claimList;
	}
	
	public void addClaim(Claim claim){
		claimList.add(claim);
		notifyListeners();
	}
	
	private void notifyListeners() {
		for (Listener listener: listeners){
			listener.update();
		}
		
	}

	public int size(){
		return claimList.size();
	}
	
	public void addListener(Listener l){
		listeners.add(l);
	}
	
	public void removeListener(Listener l){
	listeners.remove(l);
	}
}
