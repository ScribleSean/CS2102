//Abbey Kratman and Sean Arackal
//aekratman@wpi.edu and sarackal@wpi.edu

import static org.junit.Assert.*;
import org.junit.Test;


public class Examples {

	BooksRead number1 = new BooksRead(11.7);
	BooksRead number2 = new BooksRead(42.3);
	BooksRead number3 = new BooksRead(64.2);
	BooksRead number4 = new BooksRead(76.8);
	BooksRead number5 = new BooksRead(119.2);
	
	ReadingResult rr1 = new ReadingResult(1, number1, number2);
	ReadingResult rr2 = new ReadingResult(2, number2, number4);
	ReadingResult rr3 = new ReadingResult(3, number3, number4);
	
	WritingResult wr1 = new WritingResult(332.1, 1);
	WritingResult wr2 = new WritingResult(332.1, 10);
	WritingResult wr3 = new WritingResult(332.1, 30);
	
	ChallengeResult cr1 = new ChallengeResult(rr1, wr1);
	ChallengeResult cr2 = new ChallengeResult(rr2, wr2);
	ChallengeResult cr3 = new ChallengeResult(rr3, wr3);
	
	Literarian l1 = new Literarian(cr1);
	Literarian l2 = new Literarian(cr2);
	Literarian l3 = new Literarian(cr3);
	
	
	
	public Examples() {}
	
	
	//Test Cases for ReadingResult
	
	@Test
	public void ReadingResultCheck1() {
		assertEquals(number1, this.rr1.ficBooks);
	}
	@Test
	public void averagePerDayCheck1() {
		assertEquals(1.74, this.rr1.averagePerDay(),0.01);
	}
	@Test
	public void averagePerDayCheck2() {
		assertEquals(3.84, this.rr2.averagePerDay(),0.01);
	}
	@Test
	public void differenceFromGoalCheck1() {
		assertEquals(0, this.rr1.differenceFromGoal(),0.01);
	}
	@Test
	public void differenceFromGoalCheck2() {
		assertEquals(0, this.rr2.differenceFromGoal(),0.01);
	}
	
	
	//Test Cases for WritingResult
	
	@Test
	public void WritingResultCheck1() {
		assertEquals(10, this.wr2.dayofNovLastUpdate);
	}
	@Test
	public void averagePerDayCheck3() {
		assertEquals(332.1, this.wr1.averagePerDay(),0.01);
	}
	@Test
	public void averagePerDayCheck4() {
		assertEquals(33.21, this.wr2.averagePerDay(),0.01);
	}
	@Test
	public void differenceFromGoalCheck3() {
		assertEquals(1773.85, this.wr1.differenceFromGoal(),0.01);
	}
	@Test
	public void differenceFromGoalCheck4() {
		assertEquals(2614.1, this.wr2.differenceFromGoal(),0.01);
	}
	
	
	//Test Cases for howClose() in class ChallengeResult
	
	@Test
	public void howCloseCheck1() {
		assertEquals(1773.85, cr1.howClose(),0.01);
	}
	@Test
	public void howCloseCheck2() {
		assertEquals(2614.1, cr2.howClose(),0.01);
	}
	@Test
	public void howCloseCheck3() {
		assertEquals(0, cr3.howClose(),0.01);
	}
	
	
	//Test Cases for betterBookworm in class Literarian
	
	@Test
	public void betterBookwormCheck1() {
		assertTrue(this.l1.betterBookworm(l1));
	}
	@Test
	public void betterBookwormCheck2() {
		assertTrue(this.l1.betterBookworm(l2));
	}
	@Test
	public void betterBookwormCheck3() {
		assertTrue(this.l3.betterBookworm(l3));
	}
	
	
	//Test Cases for wittierWordsmith in class Literarian
	
	@Test
	public void wittierWordsmithCheck1() {
		assertFalse(this.l1.wittierWordsmith(l1));
	}
	@Test
	public void wittierWordsmithCheck2() {
		assertFalse(this.l1.wittierWordsmith(l2));
	}
	@Test
	public void wittierWordsmithCheck3() {
		assertFalse(this.l3.wittierWordsmith(l3));
	}
	
	
	//Test Cases for successfulScholar in class Literarian
	
	@Test
	public void successfulScholarCheck1() {
		assertTrue(this.l1.successfulScholar(l1));
	}
	@Test
	public void successfulScholarCheck2() {
		assertTrue(this.l1.successfulScholar(l2));
	}
	@Test
	public void successfulScholarCheck3() {
		assertTrue(this.l3.successfulScholar(l3));
	}

}
