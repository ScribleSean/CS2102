package homeworkTwo;

import java.util.LinkedList;

public class PoemResult extends SharePoemWrite implements IChallenge
{
    LinkedList<Double> numWordsWrit = new LinkedList<Double>();
    int daysOfAugLastUpdate;
    int weeksOfSubmit;
   
    PoemResult (double doubleNum, int daysOfAugLastUpdate, int weeksOfSubmit) {
        this.numWordsWrit.add(doubleNum);
        this.daysOfAugLastUpdate = daysOfAugLastUpdate;
        this.weeksOfSubmit = weeksOfSubmit;

    }
    
    /*
     * This method exists to compile every number in a given list.
     *  There are no parameters.
     *  @return   double	 			Returns the final sum of all the doubles in the list
     *  								numWordsWrit.
    */
    
    public double getRunningSum(){
        double getRunningSumAcc=0;
        for(Double n : numWordsWrit)
        {
            getRunningSumAcc+=n;
        }
        return getRunningSumAcc;
    }
    

    /*
     * This method exists to add a poem's number of words to the list numWordsWrit.
     *  @param	  numWords				The number of words in a poem.
     *  @param	  newPoem				Returns true if a new poem was submitted.
     *  @return   PoemResult	 		Returns that PoemResult.
    */

    public PoemResult nextPoem(double numWords, boolean newPoem) {
        this.numWordsWrit.add(numWords);
        if(newPoem)
        {
            this.weeksOfSubmit ++;
        }
        return this;
    }       
    
    /*
     * This method exists to calculate the average number of words written per day.
     *  There are no parameters.
     *  @return   double	 		Returns the average number of words written per day.
    */

        public double averagePerDay()
        {
        	 double runningSum = 0;
            runningSum = getRunningSum(numWordsWrit);
            return (runningSum/daysOfAugLastUpdate);
        }

        
        /*
         * This method exists to calculate the average number of words the 
         *  					Literarian needs to increase by daily 
         *  					to meet the challenge's goal.
         *  There are no parameters.
         *  @return   double	The average number of words the 
         *  					Literarian needs to increase by daily 
         *  					to meet the challenge's goal.
        */
        
        public double differenceFromGoal()
        {
        	double finalVal = 0;
        	double runningSum = 0;
            runningSum = getRunningSum(numWordsWrit); 
            if(weeksOfSubmit > 0) {
            	finalVal = (runningSum/weeksOfSubmit);
            } else {
            	finalVal = runningSum;
            }
            finalVal = (4 - weeksOfSubmit) * finalVal;
            finalVal = finalVal/(31 - (daysOfAugLastUpdate + 1));
            return finalVal;
        }
}
