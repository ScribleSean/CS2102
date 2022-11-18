import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class SnowfallExamples {
  Snowfall1 E1 = new Snowfall1();
  Snowfall2 E2 = new Snowfall2();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<MaxInchReport> DecReports = new LinkedList<MaxInchReport>();
  LinkedList<MaxInchReport> NovReports = new LinkedList<MaxInchReport>();
  
  public SnowfallExamples() {
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

    DecReports.add(new MaxInchReport(1201.0,6.0));
    NovReports.add(new MaxInchReport(1113.0,10.0));
    NovReports.add(new MaxInchReport(1120.0,5.0));

  }

  @Test
  public void instructorTestEQ() { 
    assertEquals(DecReports, E1.dailyMaxForMonth(threeDates, 12));
  }

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
}
