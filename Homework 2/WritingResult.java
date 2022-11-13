package Homework2;
import java.util.LinkedList;
public class WritingResult extends SharePoemWrite implements IChallenge
{
    // 1a. Instantiation & 1b. changing the constructor
    int dayofNovLastUpdate;
    LinkedList<Double> writingList = new LinkedList<Double>();    
    
    
    /*
     * This method exists to show the total of all the doubles in a given list.
     *  There are no parameters.
     *  @return   double	 			Returns the final sum of all the doubles in the list
     *  								writingList.
    */
    public double getRunningSum()
    {
        double getRunningSumAcc=0;
        for(Double n : writingList)
        {
            getRunningSumAcc+=n;
        }
        return getRunningSumAcc;
    }
 
    public WritingResult (double writingResDoub, int dayofNovLastUpdate)
    {
    	this.dayofNovLastUpdate = dayofNovLastUpdate;
    	writingList.add(writingResDoub);
    }

    /*
     * This method exists to add a new double (the number of words) to a writingList.
     *  @param	  newDouble				A new double representing the number of words written.
     *  @return   WritingResult	 		Returns the WritingResult with the object added.
     *  
    */
    
    public WritingResult nextChapter(double newDouble)
    {
        this.writingList.add(newDouble);
        return this;
    }
    
    
 // No Javadocs required.
    public double averagePerDay()
    {
        runningSum = getRunningSum(writingList);
        return (runningSum/dayofNovLastUpdate);
    }
    
    // No Javadocs required.
    public double differenceFromGoal()
    {
        runningSum = getRunningSum(writingList); 
        return ((50000/dayofNovLastUpdate) - (runningSum/dayofNovLastUpdate));
    }
    }


