import java.util.GregorianCalendar;
import java.util.LinkedList;
public class RadioStation extends RatingHelperFunctions
{
    private GregorianCalendar today;
    private TodaysRatingsManager aCollection;

    public RadioStation(GregorianCalendar today, TodaysRatingsManager aCollection)
    {
        this.today=today;
        this.aCollection=aCollection;
    }


    /*
     * This method exists to produce the smallest rank given in this month.
     *  There are no parameters in this function.
     *  @return   int    		Returns the smallest rank (lower = better) in the current month.
     */

    public int bestRankThisMonth()
    {
        int year = today.get(GregorianCalendar.YEAR);
        int month = today.get(GregorianCalendar.MONTH);
        int bestRank = 1000;
        int placeHolder;
        if (!aCollection.isRatingEmpty())
        {
            for (int incr = 0; incr < aCollection.getSize(); incr++)
            {
                TodaysRatings todRatings = aCollection.getInstance(incr);
                if (monthsEqual(todRatings, month) && yearsEqual(todRatings, year))
                {
                    if (todRatings.rankingsFromSurveys.size() == 0)
                    {
                        continue;
                    }
                    else
                        for (int count = 0; count < todRatings.rankingsFromSurveys.size(); count++)
                        {
                            placeHolder = todRatings.rankingsFromSurveys.get(count);
                            if (placeHolder < bestRank)
                            {
                                bestRank = placeHolder;
                            }
                        }
                }
            }
        }
        if (bestRank == 1000)
        {
            return -1;
        }
        else
            return bestRank;
    }


    /*
     * This method exists to find the total number of song downloads over every day in a given month.
     *  @param    aMonth			A given month.
     *  @param    aYear			A given year.
     *  @return   int    		Returns the total number of song downloads over a given month.
     */

    public int totalSongDownloads(int aMonth, int aYear)
    {
        int totalFromDown = 0;
        int finalSum = 0;
        LinkedList<Integer> allDownloads = new LinkedList<Integer>();
        if (!aCollection.isRatingEmpty())
        {
            for(int i =0; i<aCollection.getSize();i++)
            {
                TodaysRatings aRating = aCollection.getInstance(i);
                {
                    if(monthsEqual(aRating,aMonth)&&yearsEqual(aRating, aYear))
                    {
                        totalFromDown=sumOfList(aRating.downloadsFromSurveys);
                        finalSum+=totalFromDown;
                    }
                }
            }
            return finalSum;
        }
        return 0;
    }


    /*
     * This method exists to
     *  @param    aListOfSurveys	A list of surveys.
     *  @return   void    		Constructs a TodaysRatings for the current date and saves it, then adds one day to the current date.
     */

    public void addTodaysSurveys(LinkedList<Survey> aListOfSurveys)
    {
        today.add(GregorianCalendar.DAY_OF_YEAR, 1);
        GregorianCalendar todaysDate = new GregorianCalendar(
                today.get(GregorianCalendar.YEAR),
                today.get(GregorianCalendar.MONTH),
                today.get(GregorianCalendar.DAY_OF_MONTH));
        TodaysRatings aRating = new TodaysRatings(todaysDate, listOfRankFromSurveys(aListOfSurveys), listOfDownFromSurveys(aListOfSurveys));
        this.aCollection.getSum(aRating);
    }

    /*
    Q. What might be a better data structure than a LinkedList<TodaysRatings> to encapsulate? Why?

    A. It might be better to use an Array to encapsulate. As a data structure, an array has a few properties that make it better to use than a
       linked list. It is easier to traverse and edit an array than it is a linked list. You can change the value of any item in array using its
       index position. It also improves overall time for the program to run as it's faster to access items in an array.

    Q. If you implemented a class to encapsulate that data structure as a field, how would that class implement the methods of the interface you designed?
       Do you think it is possible to implement that class without modifying the interface? Why or why not?

    A. Yes, it is possible to implement that class without modifying the interface. This is shown in our attempt for the extra credit in the
       Extra Credit class. An Interface exists to improve connections between different classes. They need not be modified to work with other classes.
       They set the background for other classes but this does not force the class to behave or execute these methods in the same way.
     */
}
