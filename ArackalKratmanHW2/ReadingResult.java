package homeworkTwo;
import java.util.LinkedList;


public class ReadingResult implements IChallenge {
    int booksPerDay;
    BooksRead ficBooks;
    BooksRead nonFicBooks;
    LinkedList<BooksRead> readList;
    
    
    double runningSum = 0;
   
    
    public ReadingResult(int booksPerDay, BooksRead ficBooks, BooksRead nonFicBooks) {
        this.booksPerDay = booksPerDay;
        this.ficBooks = ficBooks;
        this.nonFicBooks = nonFicBooks;
        
       
		readList = new LinkedList<BooksRead>();
		readList.add(ficBooks);
		readList.add(nonFicBooks);
        
    } 

    /*
     * This method exists to show how many books are in a given list.
     *  There are no parameters.
     *  @return   double	 			Returns the final sum of all the books in the list
     *  								readList.
    */
  
    public double runnerSum() {
        for (BooksRead n : readList) {
            runningSum = runningSum + n.books;
        }
        return runningSum;

    }
    
    // No JavaDocs required.
    public double averagePerDay()
    {
    	if(readList.size() == 0) {
    		return 0.0;
    	}
    		
        double readingResultAPDsum = 0;
        for (BooksRead n : readList)
        {
            readingResultAPDsum = readingResultAPDsum + n.books;
        }
        
        return (readingResultAPDsum/31);
            }

    // No JavaDocs required.
    public double differenceFromGoal() {
        if (booksPerDay - averagePerDay() > 0)
            return (booksPerDay - averagePerDay());
        else
            return 0;
    }

    
    /*
     * This method exists to add a new BooksRead to a ReadingResult.
     *  @param	  object				A BooksRead.
     *  @return   ReadingResult	 		Returns the ReadingList with the object added.
     *  
    */
    
    public ReadingResult readSomeBooks(BooksRead object) {
        this.readList.add(object);
        return this;

    }

    /*
     * This method returns the genre of the best books in the reading list, according to 
     * whether the reading of the books were invested and how many books in each genre were read.
     *  @param	  invested				Returns true if the reading done was invested.
     *  @return   String	 			Returns a string of the genre chosen by the method.
     *  
    */
    
    public String bestGenreByType(boolean invested)
    {
        String investedGenre = null;
        double highestBooksRead=0;
        if (invested)
        {
            for (BooksRead n : readList)
            {
                if (n.skimmed == false && n.books >= highestBooksRead)
                {
                    highestBooksRead= n.books;
                    investedGenre= n.genre;
                }
            }
        }
        else
            for (BooksRead n : readList)
            {
                highestBooksRead= n.books;
                investedGenre= n.genre;
            }

        return investedGenre;
    }
}

// Initialize the list with the two BooksRead objects from the constructor 
// (with the genres of "fiction" and "non-fiction" added). 
// Specific spelling of the genres does not matter.
