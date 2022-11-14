import java.util.LinkedList;

class Snowfall1 {
  Snowfall1(){}

  // checks whether a datum is a date
  boolean isDate(double anum) { return (int)anum >= 101; } // Jan 1st
  // extracts the month from an 4-digit date
  int extractMonth(double dateNum) { return ((int)( dateNum / 100)); }
 
  public LinkedList<MaxInchReport> dailyMaxForMonth(LinkedList<Double> data,
                                                    int month) {
   return null;
  }
}  

