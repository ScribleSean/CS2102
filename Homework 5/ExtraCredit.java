public class ExtraCredit implements IMusicRatings
{
    TodaysRatings[] anArray;
    ExtraCredit(TodaysRatings[] anArray)
    {
        this.anArray = anArray;
    }

    public boolean isRatingEmpty()
    {
        return anArray.length == 0;
    }
    public int getSize()
    {
        return anArray.length;
    }

    public TodaysRatings getInstance(int i)
    {
        return anArray[i];
    }
    public void getSum(TodaysRatings aRating)
    {
        int arraySize = anArray.length;
        TodaysRatings newArray[] = new TodaysRatings[arraySize + 1];
        for (int i = 0; i < arraySize; i++)
        {
            newArray[i] = anArray[i];
        }
        newArray[arraySize] = aRating;
        anArray=newArray;
    }
}
