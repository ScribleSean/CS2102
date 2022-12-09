import java.util.LinkedList;
public class TodaysRatingsManager implements IMusicRatings
{
    LinkedList<TodaysRatings> todaysRatings = new LinkedList<TodaysRatings>();
    TodaysRatingsManager(LinkedList<TodaysRatings> todaysRatings)
    {
        this.todaysRatings = todaysRatings;
    }


    /*
     * This method exists to check whether or not todaysRatings is empty.
     *  There are no parameters in this function.
     *  @return   boolean    		Returns true if todaysRatings is empty, and false otherwise.
     */
    public boolean isRatingEmpty()
    {
        return todaysRatings.isEmpty();
    }

    /*
     * This method exists to determine the size of todaysRatings.
     *  There are no parameters in this function.
     *  @return   int    		Returns the size of todaysRatings.
     */
    public int getSize()
    {
        return todaysRatings.size();
    }

    /*
     * This method exists to get a given instance of todaysRatings.
     *  @param    i					an integer representing an element in todaysRatings.
     *  @return   TodaysRatings    		Returns a given instance of todaysRatings.
     */

    public TodaysRatings getInstance(int i)
    {
        return todaysRatings.get(i);
    }

    /*
     * This method exists to add a given rating to todaysRatings.
     *  @param    aRating			a given rating.
     *  @return   void    		Adds a given rating to todaysRating.
     */

    public void getSum(TodaysRatings aRating)
    {
        this.todaysRatings.add(aRating);
    }
}
