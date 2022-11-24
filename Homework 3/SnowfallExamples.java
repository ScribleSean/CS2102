import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class SnowfallExamples {
  /* Subtasks for Snowfall 1 and 2
	The function in both MovieManager 1 and 2 is called dailyMaxForMonth
	It consumes a list of data recorded by a sensor and an integer representing the month. There are two things that a double in the list can represent
	a month and it's date, and the snowfall recordings on that date
	the function goes through the list of data
	reaches the point where the month in the data matches the month consumed
	it then goes through the data until it reaches another date and finds the maximum value for snowfall recorded in that day
	it then adds that maximum value and the day it was on to a MaxInchReport object which gets added to a list
	this list is then finally returned

	Snowfall 1 and 2 are different in the way they go through the sensor recordings in data
	Snowfall 1 uses a nested loop that finds a date and then goes through the data after that point to find a maximum value and stops when it finds another date
	Snowfall 2 uses only one loop and seperates the substasks of finding the max value and adding it to a list into two different if statements
	 */
  Snowfall1 E1 = new Snowfall1();
  Snowfall2 E2 = new Snowfall2();

  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();
  LinkedList<MaxInchReport> DecReports = new LinkedList<MaxInchReport>();
  LinkedList<MaxInchReport> NovReports = new LinkedList<MaxInchReport>();
  LinkedList<Double> ourOwnStuff = new LinkedList<Double>();
  LinkedList<MaxInchReport> OurReports = new LinkedList<MaxInchReport>();
  
  public SnowfallExamples() {


    ourOwnStuff.add(1102.0);
    ourOwnStuff.add(20.0);
    ourOwnStuff.add(99.0);

    ourOwnStuff.add(1118.0);
    ourOwnStuff.add(0.0);
    ourOwnStuff.add(-20.0);

    threeDates.add(1113.0);
    threeDates.add(10.0);
    threeDates.add(5.0);

    threeDates.add(1120.0);
    threeDates.add(4.0);
    threeDates.add(5.0);
    threeDates.add(4.5);

    threeDates.add(1201.0);
    threeDates.add(6.0);
    threeDates.add(-0.5);



    OurReports.add(new MaxInchReport(1102.0,99.0));
    OurReports.add(new MaxInchReport(1118.0,0.0));



    DecReports.add(new MaxInchReport(1201.0,6.0));
    NovReports.add(new MaxInchReport(1113.0,10.0));
    NovReports.add(new MaxInchReport(1120.0,5.0));

  }

  @Test
  public void instructorTestEQ() {
    assertEquals(DecReports,
            E1.dailyMaxForMonth(threeDates, 12));
  }

  //Editing instructor tests for Novemeber and testing both Snowfall 1 and 2
  @Test
  public void snowfallOneTest() {
    assertEquals(NovReports, E1.dailyMaxForMonth(threeDates, 11));
  }
  @Test
  public void snowfallTwoTest() {
    assertEquals(NovReports, E2.dailyMaxForMonth(threeDates, 11));
  }
  @Test
  public void snowfallTwoTest3() {
    assertEquals(DecReports, E2.dailyMaxForMonth(threeDates, 12));
  }


  // with Zero snowfall recordings
  @Test
  public void zeroTest() {
    assertEquals(OurReports, E1.dailyMaxForMonth(ourOwnStuff, 11));
  }


  @Test
  public void ninetyNineTest() {
    assertEquals(OurReports, E1.dailyMaxForMonth(ourOwnStuff, 11));
  }


}
