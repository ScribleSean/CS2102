package Homework2;

import java.util.LinkedList;
import static org.junit.Assert.*;
import org.junit.Test;

//Abbey Kratman and Sean Arackal
//aekratman@wpi.edu and sarackal@wpi.edu

public class Examples {
	
	
	BooksRead b1 = new BooksRead(0.0, "Fantasy", true);
	BooksRead b2 = new BooksRead(0.0, "Sci-Fi", false);
	BooksRead b3 = new BooksRead(2.53, "Horror", true);
	BooksRead b4 = new BooksRead(6.74, "Historical Fiction", false);
	BooksRead b5 = new BooksRead(1.91, "Fantasy", true);
	BooksRead b6 = new BooksRead(9.912, "Sci-Fi", false);
	BooksRead b7 = new BooksRead(11.331, "Horror", true);
	BooksRead b8 = new BooksRead(4.131, "Historical Fiction", false);
	BooksRead b9 = new BooksRead(7.231, "Fantasy", true);
	BooksRead b10 = new BooksRead(1.321, "Sci-Fi", false);
	BooksRead b11 = new BooksRead(8.231, "Horror", true);
	BooksRead b12 = new BooksRead(9.593, "Historical Fiction", false);
	BooksRead b13 = new BooksRead(1.912, "Fantasy", true);
	BooksRead b14 = new BooksRead(3.571, "Fantasy", false);
	BooksRead b15 = new BooksRead(6.821, "Fantasy", false);
	
	ReadingResult r1 = new ReadingResult(1, b1, b2);
	ReadingResult r2 = new ReadingResult(3, b3, b4);
	ReadingResult r3 = new ReadingResult(2, b4, b5);
	ReadingResult r4 = new ReadingResult(2, b6, b7);
	ReadingResult r5 = new ReadingResult(1, b8, b9);
	ReadingResult r6 = new ReadingResult(3, b10, b11);
	ReadingResult r7 = new ReadingResult(2, b12, b13);
	ReadingResult r8 = new ReadingResult(2, b14, b15);
	
	WritingResult w1 = new WritingResult(50000, 1);
	WritingResult w2 = new WritingResult(21309.012, 30);
	WritingResult w3 = new WritingResult(70002.323, 5);
	WritingResult w4 = new WritingResult(50120.201, 17);
	WritingResult w5 = new WritingResult(54604.923, 12);
	WritingResult w6 = new WritingResult(82340.95, 9);
	WritingResult w7 = new WritingResult(34122.2, 19);
	WritingResult w8 = new WritingResult(124254.44, 24);
	
	ChallengeResult c1 = new ChallengeResult(r1, w1);
	ChallengeResult c2 = new ChallengeResult(r2, w2);
	ChallengeResult c3 = new ChallengeResult(r3, w3);
	ChallengeResult c4 = new ChallengeResult(r4, w4);
	ChallengeResult c5 = new ChallengeResult(r5, w5);
	ChallengeResult c6 = new ChallengeResult(r6, w6);
	ChallengeResult c7 = new ChallengeResult(r7, w7);
	ChallengeResult c8 = new ChallengeResult(r8, w8);

	Literarian l1 = new Literarian("Sean", c1);
	Literarian l2 = new Literarian("Abbey", c2);
	Literarian l3 = new Literarian("Luke", c3);
	Literarian l4 = new Literarian("Leia", c4);
	Literarian l5 = new Literarian("Han", c5);
	Literarian l6 = new Literarian("Rey", c6);
	Literarian l7 = new Literarian("Finn", c7);
	Literarian l8 = new Literarian("Poe", c8);
	
	PoemResult p1 = new PoemResult(0.0, 14, 3);
	PoemResult p2 = new PoemResult(2000.0, 15, 2);
	PoemResult p3 = new PoemResult(3000.0, 16, 1);
	PoemResult p4 = new PoemResult(4000.0, 17, 4);

	/*
	 LinkedList<Literarian> csDuoList = new LinkedList<Literarian>();
	 csDuoList.add(l1);
	 csDuoList.add(l2);
     LitJam csDuo = new LitJam(2, csDuoList);
	
	 LinkedList<Literarian> originalTrioList = new LinkedList<Literarian>();
	 originalTrioList.add(l3);
	 originalTrioList.add(l4);
	 originalTrioList.add(l5);
     LitJam originalTrio = new LitJam(3, originalTrioList);
     
	 LinkedList<Literarian> newTrioList = new LinkedList<Literarian>();
	 newTrioList.add(l6);
	 newTrioList.add(l7);
	 newTrioList.add(l8);
     LitJam newTrio = new LitJam(1, newTrioList);
     
*/

	
	// Edge Cases for averagePerDay in WritingResult
	@Test
	public void averagePerDayWRTestOne() {
		assertEquals(w1.averagePerDay(), 50000.0, 0.1);
	}

	@Test
	public void averagePerDayWRTestTwo()
	{
		assertEquals(w2.averagePerDay(),710.3004, 0.1 );
	}

	// Other Cases for averagePerDay in WritingResult
	@Test
	public void averagePerDayWRTestThree()
	{
		assertEquals(w3.averagePerDay(),14000.46, 0.1 );
	}
	@Test
	public void averagePerDayWRTestFour()
	{
		assertEquals(w4.averagePerDay(),2948.24, 0.1 );
	}
	@Test
	public void averagePerDayWRTestFive()
	{
		assertEquals(w5.averagePerDay(),4550.41, 0.1 );
	}
	
	// Edge Case for averagePerDay in ReadingResult
	@Test
	public void averagePerDayRRTestOne() {
		assertEquals(r1.averagePerDay(), 0.0, 0.1);
	}

	// Other Cases for averagePerDay in ReadingResult
	@Test
	public void averagePerDayRRTestTwo() {
		assertEquals(r2.averagePerDay(), 0.29, 0.1);
	}
	@Test
	public void averagePerDayRRTestThree() {
		assertEquals(r3.averagePerDay(), 0.27, 0.1);
	}
	@Test
	public void averagePerDayRRTestFour() {
		assertEquals(r4.averagePerDay(), 0.685, 0.1);
	}
	@Test
	public void averagePerDayRRTestFive() {
		assertEquals(r5.averagePerDay(), 0.366, 0.1);
	}
	
	// Edge Case for averagePerDay in PoemResult
	@Test
	public void averagePerDayPRTestOne() {
		assertEquals(p1.averagePerDay(), 0, 0.1);
	}

	// Other Cases for averagePerDay in PoemResult
	@Test
	public void averagePerDayPRTestTwo() {
		assertEquals(p2.averagePerDay(), 133.3, 0.1);
	}
	@Test
	public void averagePerDayPRTestThree() {
		assertEquals(p3.averagePerDay(), 187.5, 0.1);
	}
	@Test
	public void averagePerDayPRTestFour() {
		assertEquals(p4.averagePerDay(), 235.29, 0.1);
	}


	// Edge Case genreByType in ReadingResult
	@Test
	public void genreByTypeTestOne() {
		assertEquals(r1.bestGenreByType(true), "Sci-Fi");
	}
	@Test
	public void genreByTypeTestTwo() {
			assertEquals(r1.bestGenreByType(false), "Sci-Fi");
	}
	@Test
	public void genreByTypeTestThree() {
		assertEquals(r2.bestGenreByType(true), "Historical Fiction");
	}
	@Test
	public void genreByTypeTestFour() {
		assertEquals(r2.bestGenreByType(false), "Historical Fiction");
	}

	// Edge Case
	@Test
	public void readingDNFTestOne() {
		LinkedList<Literarian> csDuoList = new LinkedList<Literarian>();
		 csDuoList.add(l1);
		 csDuoList.add(l2);
	     LitJam csDuo = new LitJam(3, csDuoList);
		assertEquals(csDuo.readingDNF().size(), 2);
	}
	public void readingDNFTestTwo() {
		LinkedList<Literarian> csDuoList = new LinkedList<Literarian>();
		csDuoList.add(l1);
		csDuoList.add(l2);
		LitJam csDuo = new LitJam(3, csDuoList);
		assertEquals(csDuo.readingDNF().size(), 2);
	}
	 
	@Test
	public void finalScoreTestOne() {
		LinkedList<Literarian> csDuoList = new LinkedList<Literarian>();
		 csDuoList.add(l1);
		 csDuoList.add(l2);
	     LitJam csDuo = new LitJam(3, csDuoList);
		assertEquals(csDuo.finalScoreForLiterarian("Sean"), 170);
	}
	
	@Test
	public void finalScoreTestTwo() {
		LinkedList<Literarian> originalTrioList = new LinkedList<Literarian>();
		originalTrioList.add(l3);
		originalTrioList.add(l4);
		originalTrioList.add(l5);
		LitJam originalTrio = new LitJam(3, originalTrioList);
		assertEquals(originalTrio.finalScoreForLiterarian("Luke"), 183);
	}
	@Test
	public void finalScoreTestThree() {
		LinkedList<Literarian> originalTrioList = new LinkedList<Literarian>();
		originalTrioList.add(l3);
		originalTrioList.add(l4);
		originalTrioList.add(l5);
		LitJam originalTrio = new LitJam(3, originalTrioList);
		assertEquals(originalTrio.finalScoreForLiterarian("Leia"), 139);
	}

	@Test
	public void finalScoreTestFour() {
		LinkedList<Literarian> newTrioList = new LinkedList<Literarian>();
		newTrioList.add(l6);
		newTrioList.add(l7);
		newTrioList.add(l8);
		LitJam newTrio = new LitJam(1, newTrioList);
		assertEquals(newTrio.finalScoreForLiterarian("Poe"), 131);
	}
	
	@Test
	public void anyImprovementTestOne() {
		
		LinkedList<Literarian> csDuoList = new LinkedList<Literarian>();
		 csDuoList.add(l1);
		 csDuoList.add(l2);
	     LitJam csDuo = new LitJam(3, csDuoList);
	     

		 LinkedList<Literarian> originalTrioList = new LinkedList<Literarian>();
		 originalTrioList.add(l3);
		 originalTrioList.add(l4);
		 originalTrioList.add(l5);
	     LitJam originalTrio = new LitJam(3, originalTrioList);
	     
		assertTrue(csDuo.anyImprovement(originalTrio));
	}
	@Test
	public void anyImprovementTestTwo() {

		LinkedList<Literarian> csDuoList = new LinkedList<Literarian>();
		csDuoList.add(l1);
		csDuoList.add(l2);
		LitJam csDuo = new LitJam(3, csDuoList);


		LinkedList<Literarian> originalTrioList = new LinkedList<Literarian>();
		originalTrioList.add(l3);
		originalTrioList.add(l4);
		originalTrioList.add(l5);
		LitJam originalTrio = new LitJam(3, originalTrioList);

		assertFalse(originalTrio.anyImprovement(csDuo));
	}
	 
	 
	 


	 
	 
}


