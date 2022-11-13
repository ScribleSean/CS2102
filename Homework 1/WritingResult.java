
public class WritingResult implements IChallenge {
	
	double numWordsWrit;
	int dayofNovLastUpdate;
	
	public WritingResult (Double numWordsWrit, Integer donlu) {
		this.numWordsWrit=numWordsWrit;
		this.dayofNovLastUpdate=donlu;
	}
	
	public double averagePerDay() {
		return (numWordsWrit / dayofNovLastUpdate);
	}
	
public double differenceFromGoal() {
	if((50000 - numWordsWrit) / (30 - (dayofNovLastUpdate + 1))>0)
		return (50000 - numWordsWrit) / (30 - (dayofNovLastUpdate + 1));
	else
		return 0;
	}
}
