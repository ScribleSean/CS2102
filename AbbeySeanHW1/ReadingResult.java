
public class ReadingResult implements IChallenge {
	int booksPerDay;
	BooksRead ficBooks;
	BooksRead nonFicBooks;
	
	public ReadingResult(Integer booksPerDay, BooksRead ficBooks, BooksRead nonFicBooks) {
		this.booksPerDay=booksPerDay;
		this.ficBooks=ficBooks;
		this.nonFicBooks=nonFicBooks;
	}
	
	public double averagePerDay() {
		return ((this.ficBooks.books + this.nonFicBooks.books) /31);
		}

	public double differenceFromGoal() {
		if(booksPerDay - averagePerDay()>0)
			return (booksPerDay - averagePerDay());
		else
			return 0;
		}

}
