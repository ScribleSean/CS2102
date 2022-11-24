import java.util.LinkedList;

class Snowfall2 {
  Snowfall2() {
  }

  // checks whether a datum is a date
  boolean isDate(double anum) {
    return (int) anum >= 101;
  } // Jan 1st

  // extracts the month from an 4-digit date
  int extractMonth(double dateNum) {
    return ((int) (dateNum / 100));
  }

  public LinkedList<MaxInchReport> dailyMaxForMonth(LinkedList<Double> data, int month)
  {
    LinkedList<MaxInchReport> finalMax = new LinkedList<MaxInchReport>();
    MaxInchReport aMaxInchReport = new MaxInchReport(0,0);
    double currentDate=0;
    for(Double aSensorRecording : data)
    {
      if(isDate(aSensorRecording))
      {
        currentDate=aSensorRecording;
        if(extractMonth(aSensorRecording)==month)
        {
          aMaxInchReport=new MaxInchReport(aSensorRecording, 0);
          finalMax.add(aMaxInchReport);
        }
      }
      else if(aSensorRecording>= aMaxInchReport.maxInches && aSensorRecording >= 0 && aMaxInchReport.date==currentDate)
      {
        aMaxInchReport.maxInches = aSensorRecording;
      }
    }
    return finalMax;
  }
}