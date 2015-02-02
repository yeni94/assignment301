package ca.ualberta.cs.omoyeni_travel_expense;

public class ClaimsListController {
	private static ClaimsList claimList = null;
	static public ClaimsList getClaimsList(){
		if (claimList == null){
			claimList = new ClaimsList();
		}
		return claimList;
	}
	
	public void addClaim(Claim claim2) {
		getClaimsList().addClaim(claim2);
		
		
	}

	
	
}
