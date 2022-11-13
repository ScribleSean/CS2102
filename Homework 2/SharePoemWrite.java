package Homework2;

import java.util.LinkedList;
public abstract class SharePoemWrite
{
	double runningSum = 0;
	
    public abstract double averagePerDay();
    
    /*
     * This method exists to compile every number in a given list.
     *  @param 	  aListOfDouble			A ListOfDouble.
     *  @return   double	 			Returns a double representing the number of doubles in a list.
    */
    
    public double getRunningSum(LinkedList<Double> aListOfDouble)
    {
        double getRunningSumAcc=0;
        for(Double n : aListOfDouble)
        {
            getRunningSumAcc+=n;
        }
        return getRunningSumAcc;
    }
}
