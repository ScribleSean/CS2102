import java.util.GregorianCalendar;
import java.util.LinkedList;
public class TodaysRatings {
    GregorianCalendar date;
    LinkedList<Integer> rankingsFromSurveys;
    LinkedList<Integer> downloadsFromSurveys;

    TodaysRatings(GregorianCalendar date, LinkedList<Integer> rankingsFromSurveys, LinkedList<Integer> downloadsFromSurveys) {
        this.date = date;
        this.rankingsFromSurveys = rankingsFromSurveys;
        this.downloadsFromSurveys = downloadsFromSurveys;
    }


}
