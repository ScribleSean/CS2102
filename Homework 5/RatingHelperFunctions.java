import java.util.GregorianCalendar;
import java.util.LinkedList;
public class RatingHelperFunctions
{

    /*
     * This method exists to produce a sum of every integer in a given list.
     *  @param    listOfNum		A given list.
     *  @return   int    		Returns the sum of every integer in listOfNum.
     */

    public int sumOfList(LinkedList<Integer> listOfNum)
    {
        int sum = 0;
        for(int num : listOfNum)
        {
            sum+=num;
        }
        return sum;
    }




    /*
     * This method exists to confirm the month of a given rating is equal to a given month.
     *  @param    aRating		A given rating.
     *  @param    month			A given month.
     *  @return   boolean    		Returns true if the rating’s month matches the given month, and false otherwise.
     */

    boolean monthsEqual(TodaysRatings aRating, int month)
    {
        if(aRating.date.get(GregorianCalendar.MONTH) == month)
            return true;
        else
            return false;
    }

    /*
     * This method exists to confirm the year of a given rating is equal to a given year.
     *  @param    aRating		A given rating.
     *  @param    year			A given year.
     *  @return   boolean    		Returns true if the rating’s year matches the given year, and false otherwise.
     */

    boolean yearsEqual(TodaysRatings aRating, int year)
    {
        if(aRating.date.get(GregorianCalendar.YEAR) == year)
            return true;
        else
            return false;
    }


    /*
     * This method exists to list out the number of rankings from a given survey.
     *  @param    listOfSurveys				A list of surveys.
     *  @return   LinkedList<Integer>    		Returns a list of integers, representing the number of rankings in each element in the given listOfSurveys.
     */

    LinkedList<Integer> listOfRankFromSurveys(LinkedList<Survey> listOfSurveys) {
        LinkedList<Integer> listOfRank = new LinkedList<Integer>();
        for(Survey aSurvey : listOfSurveys){
            int aRank = aSurvey.theRank;
            listOfRank.add(aRank);
        }
        return listOfRank;
    }


    /*
     * This method exists to list out the number of downloads from a given survey.
     *  @param    listOfSurveys				A list of surveys.
     *  @return   LinkedList<Integer>    		Returns a list of integers, representing the number of downloads in each element in the given listOfSurveys.
     */

    LinkedList<Integer> listOfDownFromSurveys(LinkedList<Survey> listOfSurveys) {
        LinkedList<Integer> listOfDown = new LinkedList<Integer>();
        for(Survey newSurvey : listOfSurveys) {
            int aDown = newSurvey.numberOfDownloads;
            listOfDown.add(aDown);
        }
        return listOfDown;
    }
}
