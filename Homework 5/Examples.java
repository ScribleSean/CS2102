
import static org.junit.Assert.*;
import org.junit.Test;
import java.io.*;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.LinkedList;



public class Examples {

    // Survey name = new Survey(rank, downloads)
    Survey s1 = new Survey(1, 1); // high rank low dl
    Survey s2 = new Survey(1, 60000); // high rank high dl
    Survey s3 = new Survey(600, 1000000); // low rank high dl
    Survey s4 = new Survey(300, 1); // low rank low dl




    GregorianCalendar date1;
    {date1 = new GregorianCalendar(2004, 3, 1);}
    GregorianCalendar date2;
    { date2 = new GregorianCalendar(2004, 3, 2);}
    GregorianCalendar date3;
    { date3 = new GregorianCalendar(2004, 3, 3);}


    GregorianCalendar oct1;
    {oct1 = new GregorianCalendar(2004, 9, 1);}
    GregorianCalendar oct2;
    { oct2 = new GregorianCalendar(2004, 9, 2);}
    GregorianCalendar oct3;
    { oct3 = new GregorianCalendar(2004, 9, 3);}

    GregorianCalendar jan1;
    {jan1 = new GregorianCalendar(2004, 0, 1);}
    GregorianCalendar jan2;
    { jan2 = new GregorianCalendar(2004, 0, 2);}
    GregorianCalendar jan3;
    { jan3 = new GregorianCalendar(2004, 0, 3);}


    @Test
    public void baseTest(){
        assertEquals(2,2);
    }

    @Test
    public void todaysRatingLists(){
        LinkedList<Integer> rankListOne = new LinkedList<Integer>();
        LinkedList<Integer> dlListOne = new LinkedList<Integer>();
        rankListOne.add(1);
        rankListOne.add(2);
        rankListOne.add(3);

        dlListOne.add(400);
        dlListOne.add(600);
        dlListOne.add(300);

        TodaysRatings ratingDateOne = new TodaysRatings(date1, rankListOne, dlListOne);
        LinkedList<TodaysRatings> listTodayRatingsOne = new LinkedList<TodaysRatings>();
        listTodayRatingsOne.add(ratingDateOne);
        TodaysRatingsManager trmOne = new TodaysRatingsManager(listTodayRatingsOne);
        RadioStation rs1 = new RadioStation(date1, trmOne);

        assertEquals(rs1.bestRankThisMonth(), 1);


    }
    @Test
    public void todaysRatingListsTwo(){
        LinkedList<Integer> rankListTwo = new LinkedList<Integer>();
        LinkedList<Integer> dlListTwo = new LinkedList<Integer>();
        rankListTwo.add(9);
        rankListTwo.add(7);
        rankListTwo.add(3);

        dlListTwo.add(6000000);
        dlListTwo.add(4);
        dlListTwo.add(200);

        TodaysRatings ratingDateTwo = new TodaysRatings(oct1, rankListTwo, dlListTwo);
        LinkedList<TodaysRatings> listTodayRatingsTwo = new LinkedList<TodaysRatings>();
        listTodayRatingsTwo.add(ratingDateTwo);
        TodaysRatingsManager trmTwo = new TodaysRatingsManager(listTodayRatingsTwo);
        RadioStation rs2 = new RadioStation(oct1, trmTwo);

        assertEquals(rs2.bestRankThisMonth(), 3);
    }
    @Test
    public void todaysRatingListsThree(){
        LinkedList<Integer> rankListThree = new LinkedList<Integer>();
        LinkedList<Integer> dlListThree = new LinkedList<Integer>();
        rankListThree.add(300);
        rankListThree.add(600);
        rankListThree.add(100);

        dlListThree.add(40);
        dlListThree.add(10);
        dlListThree.add(50);

        TodaysRatings ratingDateThree = new TodaysRatings(jan1, rankListThree, dlListThree);
        LinkedList<TodaysRatings> listTodayRatingsThree = new LinkedList<TodaysRatings>();
        listTodayRatingsThree.add(ratingDateThree);
        TodaysRatingsManager trmThree = new TodaysRatingsManager(listTodayRatingsThree);
        RadioStation rs3 = new RadioStation(jan1, trmThree);

        assertEquals(rs3.bestRankThisMonth(), 100);
    }



    @Test
    public void todaysDownloadListsOne(){
        LinkedList<Integer> rankListOne = new LinkedList<Integer>();
        LinkedList<Integer> dlListOne = new LinkedList<Integer>();
        rankListOne.add(1);
        rankListOne.add(2);
        rankListOne.add(3);

        dlListOne.add(400);
        dlListOne.add(600);
        dlListOne.add(300);

        TodaysRatings ratingDateOne = new TodaysRatings(date1, rankListOne, dlListOne);
        LinkedList<TodaysRatings> listTodayRatingsOne = new LinkedList<TodaysRatings>();
        listTodayRatingsOne.add(ratingDateOne);
        TodaysRatingsManager trmOne = new TodaysRatingsManager(listTodayRatingsOne);
        RadioStation rs1 = new RadioStation(date1, trmOne);

        assertEquals(rs1.totalSongDownloads(3, 2004), 1300);


    }
    @Test
    public void todaysDownloadsListsTwo(){
        LinkedList<Integer> rankListTwo = new LinkedList<Integer>();
        LinkedList<Integer> dlListTwo = new LinkedList<Integer>();

        rankListTwo.add(9);
        rankListTwo.add(7);
        rankListTwo.add(3);

        dlListTwo.add(6000000);
        dlListTwo.add(4);
        dlListTwo.add(200);

        TodaysRatings ratingDateTwo = new TodaysRatings(oct1, rankListTwo, dlListTwo);
        LinkedList<TodaysRatings> listTodayRatingsTwo = new LinkedList<TodaysRatings>();
        listTodayRatingsTwo.add(ratingDateTwo);
        TodaysRatingsManager trmTwo = new TodaysRatingsManager(listTodayRatingsTwo);
        RadioStation rs2 = new RadioStation(oct1, trmTwo);

        assertEquals(rs2.totalSongDownloads(9, 2004), 6000204);
    }
    @Test
    public void todaysDownloadsListsThree(){
            LinkedList<Integer> rankListThree = new LinkedList<Integer>();
            LinkedList<Integer> dlListThree = new LinkedList<Integer>();
            rankListThree.add(300);
            rankListThree.add(600);
            rankListThree.add(100);

            dlListThree.add(40);
            dlListThree.add(10);
            dlListThree.add(50);

            TodaysRatings ratingDateThree = new TodaysRatings(jan1, rankListThree, dlListThree);
            LinkedList<TodaysRatings> listTodayRatingsThree = new LinkedList<TodaysRatings>();
            listTodayRatingsThree.add(ratingDateThree);
            TodaysRatingsManager trmThree = new TodaysRatingsManager(listTodayRatingsThree);
            RadioStation rs3 = new RadioStation(jan1, trmThree);


        assertEquals(rs3.totalSongDownloads(0, 2004), 100);
    }


    // no data in this month returns -1
    @Test
    public void todaysDownloadsListsFour(){
        LinkedList<Integer> rankListThree = new LinkedList<Integer>();
        LinkedList<Integer> dlListThree = new LinkedList<Integer>();

        TodaysRatings ratingDateThree = new TodaysRatings(jan1, rankListThree, dlListThree);
        LinkedList<TodaysRatings> listTodayRatingsThree = new LinkedList<TodaysRatings>();
        listTodayRatingsThree.add(ratingDateThree);
        TodaysRatingsManager trmThree = new TodaysRatingsManager(listTodayRatingsThree);
        RadioStation rs3 = new RadioStation(jan1, trmThree);

        assertEquals(rs3.bestRankThisMonth(), -1);
    }


    // NOTDONE
    @Test
    public void addTodaysSurveysOne(){
        LinkedList<Survey> sl1 = new LinkedList<Survey>();
        sl1.add(s1);
        sl1.add(s2);
        sl1.add(s3);
        sl1.add(s4);

      //???

    }

    @Test
    public void sumOfListTest(){
        LinkedList<Integer> listOfIntOne = new LinkedList<Integer>();
        listOfIntOne.add(2);
        listOfIntOne.add(3);
        listOfIntOne.add(4);
        listOfIntOne.add(5);

        RatingHelperFunctions rhfoff = new RatingHelperFunctions();
        int ratingOne = rhfoff.sumOfList(listOfIntOne);
        assertEquals(ratingOne, 14);
    }

    @Test
    public void monthsEqualTest(){
        LinkedList<Integer> rankListThree = new LinkedList<Integer>();
        LinkedList<Integer> dlListThree = new LinkedList<Integer>();
        rankListThree.add(300);
        rankListThree.add(600);
        rankListThree.add(100);

        dlListThree.add(40);
        dlListThree.add(10);
        dlListThree.add(50);

        TodaysRatings ratingDateThree = new TodaysRatings(jan1, rankListThree, dlListThree);
        RatingHelperFunctions rhf2 = new RatingHelperFunctions();
        boolean monthsOne = rhf2.monthsEqual(ratingDateThree, 0);

        assertTrue(monthsOne);
    }

    @Test
    public void yearsEqualTest(){
        LinkedList<Integer> rankListThree = new LinkedList<Integer>();
        LinkedList<Integer> dlListThree = new LinkedList<Integer>();
        rankListThree.add(300);
        rankListThree.add(600);
        rankListThree.add(100);

        dlListThree.add(40);
        dlListThree.add(10);
        dlListThree.add(50);

        TodaysRatings ratingDateThree = new TodaysRatings(jan1, rankListThree, dlListThree);
        RatingHelperFunctions rhf2 = new RatingHelperFunctions();
        boolean yearsOne = rhf2.yearsEqual(ratingDateThree, 2004);

        assertTrue(yearsOne);
    }

    @Test
    public void listOfRankFromSurveysTest(){
        LinkedList<Survey> sl2 = new LinkedList<Survey>();
        sl2.add(s1);
        sl2.add(s2);

        RatingHelperFunctions rhf3 = new RatingHelperFunctions();
        LinkedList<Integer> ranksOf2 = rhf3.listOfRankFromSurveys(sl2);
        LinkedList<Integer> ranksManual = new LinkedList<Integer>();
        ranksManual.add(1);
        ranksManual.add(1);

        assertEquals(ranksOf2, ranksManual);
    }

    @Test
    public void listOfDownFromSurveysTest(){
        LinkedList<Survey> sl2 = new LinkedList<Survey>();
        sl2.add(s1);
        sl2.add(s2);

        RatingHelperFunctions rhf3 = new RatingHelperFunctions();
        LinkedList<Integer> downloadsOfTwo = rhf3.listOfDownFromSurveys(sl2);
        LinkedList<Integer> downloadsManual = new LinkedList<Integer>();
        downloadsManual.add(1);
        downloadsManual.add(60000);

        assertEquals(downloadsOfTwo, downloadsManual);
    }


    @Test
    public void isRatingEmptyTest(){
        LinkedList<Integer> rankListThree = new LinkedList<Integer>();
        LinkedList<Integer> dlListThree = new LinkedList<Integer>();
        rankListThree.add(300); rankListThree.add(600); rankListThree.add(100);

        dlListThree.add(40);dlListThree.add(10); dlListThree.add(50);

        TodaysRatings ratingDateThree = new TodaysRatings(jan1, rankListThree, dlListThree);
        LinkedList<TodaysRatings> tdList = new LinkedList<TodaysRatings>();
        tdList.add(ratingDateThree);

        TodaysRatingsManager tdm1 = new TodaysRatingsManager(tdList);
        boolean isEmpty = tdm1.isRatingEmpty();
        assertFalse(isEmpty);
    }

    @Test
    public void getSizeTest(){
        LinkedList<Integer> rankListThree = new LinkedList<Integer>();
        LinkedList<Integer> dlListThree = new LinkedList<Integer>();
        rankListThree.add(300); rankListThree.add(600); rankListThree.add(100);

        dlListThree.add(40);dlListThree.add(10); dlListThree.add(50);

        TodaysRatings ratingDateThree = new TodaysRatings(jan1, rankListThree, dlListThree);
        LinkedList<TodaysRatings> tdList = new LinkedList<TodaysRatings>();
        tdList.add(ratingDateThree);

        TodaysRatingsManager tdm1 = new TodaysRatingsManager(tdList);
        int whatSize = tdm1.getSize();
        assertEquals(whatSize, 1);
    }

    @Test
    public void getInstanceTest(){
        LinkedList<Integer> rankListThree = new LinkedList<Integer>();
        LinkedList<Integer> dlListThree = new LinkedList<Integer>();
        rankListThree.add(300); rankListThree.add(600); rankListThree.add(100);

        dlListThree.add(40);dlListThree.add(10); dlListThree.add(50);

        TodaysRatings ratingDateThree = new TodaysRatings(jan1, rankListThree, dlListThree);

        LinkedList<Integer> rankListOne = new LinkedList<Integer>();
        LinkedList<Integer> dlListOne = new LinkedList<Integer>();
        rankListOne.add(1);rankListOne.add(2);rankListOne.add(3);

        dlListOne.add(400);dlListOne.add(600);dlListOne.add(300);

        TodaysRatings ratingDateOne = new TodaysRatings(date1, rankListOne, dlListOne);

        LinkedList<TodaysRatings> tdList = new LinkedList<TodaysRatings>();
        tdList.add(ratingDateOne);
        tdList.add(ratingDateThree);

        TodaysRatingsManager tdm1 = new TodaysRatingsManager(tdList);
        TodaysRatings listInd = tdm1.getInstance(1);
        assertEquals(listInd, ratingDateThree);
    }

    @Test
    public void getSumTest(){
        LinkedList<Integer> rankListThree = new LinkedList<Integer>();
        LinkedList<Integer> dlListThree = new LinkedList<Integer>();
        rankListThree.add(300); rankListThree.add(600); rankListThree.add(100);

        dlListThree.add(40);dlListThree.add(10); dlListThree.add(50);

        TodaysRatings ratingDateThree = new TodaysRatings(jan1, rankListThree, dlListThree);
        LinkedList<TodaysRatings> tdList = new LinkedList<TodaysRatings>();
        tdList.add(ratingDateThree);

        TodaysRatingsManager tdm1 = new TodaysRatingsManager(tdList);
        tdm1.getSum(ratingDateThree);
        int sizer = tdm1.todaysRatings.size();
        assertEquals(sizer, 2);
    }


    //Non-trivial example of a RadioStation created (using addTodaysSurveys)
    LinkedList<Integer> basicList = new LinkedList<Integer>(Arrays.asList(1,2,3));
    TodaysRatingsManager aRating = new TodaysRatingsManager(new LinkedList<TodaysRatings>(Arrays.asList(
            new TodaysRatings(new GregorianCalendar(2018, 1, 1), basicList, basicList),
            new TodaysRatings(new GregorianCalendar(2018, 1, 2), basicList, basicList),
            new TodaysRatings(new GregorianCalendar(2018, 1, 3), basicList, basicList)
    )));
    RadioStation rs = new RadioStation(new GregorianCalendar(2018, 1, 1),aRating);
    @Test
    public void nonTrvivial()
    {
        LinkedList<Survey> sl1 = new LinkedList<Survey>();
        sl1.add(s1); sl1.add(s2); sl1.add(s3); sl1.add(s4);

        LinkedList<Integer> rankListOne = new LinkedList<Integer>();
        LinkedList<Integer> dlListOne = new LinkedList<Integer>();
        rankListOne.add(1); rankListOne.add(2); rankListOne.add(3);
        dlListOne.add(400); dlListOne.add(600); dlListOne.add(300);

        TodaysRatings ratingDateOne = new TodaysRatings(date1, rankListOne, dlListOne);
        LinkedList<TodaysRatings> listTodayRatingsOne = new LinkedList<TodaysRatings>();
        listTodayRatingsOne.add(ratingDateOne);
        TodaysRatingsManager trmOne = new TodaysRatingsManager(listTodayRatingsOne);
        RadioStation rs1 = new RadioStation(date1, trmOne);

        rs1.addTodaysSurveys(sl1);

        assertEquals(rs1.bestRankThisMonth(), 1);
        //???
    }
}

