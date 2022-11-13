
public class Literarian {
	
	ChallengeResult challResult;
	
	public Literarian(ChallengeResult challResult) {
		this.challResult=challResult;
	}
	
	public boolean betterBookworm( Literarian lit) {
		if ((this.challResult.readResult.differenceFromGoal()) > (lit.challResult.readResult.differenceFromGoal())) {
			return false; 
		}
		else {
			return true; 
		}
	}

	public boolean wittierWordsmith( Literarian lit) {
		if ((this.challResult.writeResult.differenceFromGoal()) > (lit.challResult.writeResult.differenceFromGoal())) {
			return true; 
		}
		else {
			return false; 
		}
	}

	public boolean successfulScholar( Literarian lit) {
		if( this.wittierWordsmith(lit) || this.betterBookworm(lit)) {
			return true;   
		}
		else {
			return false; 
		}
	}

}
