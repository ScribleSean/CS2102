public interface IMusicRatings
{

    /*
     * This method exists to check whether or not todaysRatings is empty.
     */
    boolean isRatingEmpty();

     /*
      * This method exists to determine the size of todaysRatings.
      */
    int getSize();

     /*
      * This method exists to get a given instance of todaysRatings.
      */
    TodaysRatings getInstance(int i);

     /*
      * This method exists to add a given rating to todaysRatings.
      */
    void getSum(TodaysRatings aRating);
}
