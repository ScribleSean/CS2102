import java.util.LinkedList;

class Snowfall1 {
  Snowfall1() {
  }

  // checks whether a datum is a date
  boolean isDate(double anum) {
    return (int) anum >= 101;
  } // Jan 1st

  // extracts the month from an 4-digit date
  int extractMonth(double dateNum) {
    return ((int) (dateNum / 100));
  }

  /*
   * This method exists to produce a list of reports that give the greatest snowfall result for every day in a given month.
   *  @param    data			A list of doubles representing sensor data.
   *  @param    int				An integer representing a month (between 1-12).
   *  @return   LinkedList<MaxInchReport>     A list of the maximum inches of snowfall on each day of a given month.
   */
  public LinkedList<MaxInchReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
    LinkedList<MaxInchReport> finalMax = new LinkedList<MaxInchReport>();
    for (int i = 0; i < data.size(); i++)
    {
      double currentDate = data.get(i);
      if (extractMonth(data.get(i)) == month)
      {
        double currentMaxValue = data.get(i+1);
        for (int j = i+1; ((data.get(j) <= 99)&&(j<data.size()-1)); j++)
        {
          if (currentMaxValue < data.get(j+1)&&currentMaxValue>0&&data.get(j+1)<=99)
          {
            currentMaxValue = data.get(j+1);
          }
        }
        MaxInchReport maxInch = new MaxInchReport (currentDate, currentMaxValue);
        finalMax.add(maxInch);
      }
    }
    return finalMax;
  }

}


