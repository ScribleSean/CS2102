
public class CompileCheck {

	public static void main(String[] args) {
		// dummy variables for assignment
        double x;
        boolean y;

        // test making BooksRead
        BooksRead booksRead1 = new BooksRead(1.0);
        BooksRead booksRead2 = new BooksRead(3.5);


        // test making each of the Result classes
        ReadingResult readingResult = new ReadingResult(2, booksRead1, booksRead2); //goal average books per day, fiction books read, non fiction books read.
        WritingResult writingResult = new WritingResult(25000.5, 15); //words written, last day novel was updated
        ChallengeResult challengeResult = new ChallengeResult(readingResult, writingResult);
        
        // test making athletes
        Literarian literarian1 = new Literarian(challengeResult);
        Literarian literarian2 = new Literarian(challengeResult);

        // test pointsEarned and getPenalties methods
        x = readingResult.averagePerDay();
        x = writingResult.averagePerDay();
        x = readingResult.differenceFromGoal();
        x = writingResult.differenceFromGoal();
        x = challengeResult.howClose();

        //test betterSkiier method
        y = literarian1.betterBookworm(literarian2);

        //test betterShooter method
        y = literarian1.wittierWordsmith(literarian2);
        
        //test hasBeaten method
        y = literarian1.successfulScholar(literarian2);
 
        System.out.println("Congrats! Your program compiled and ran!");

	}

}
