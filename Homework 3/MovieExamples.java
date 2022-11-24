import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class MovieExamples
{

	/* Subtasks for MovieManager 1 and 2
	The function in both MovieManager 1 and 2 is called organizeMovies
	It consumes a list of movies and sorts them appropriately into the fields of Programme
	It goes through the list of movies provided with a for loop
	It then checks if the movie in the list is not a simulcast and adds it to a list of manitee/sioree/primetime in the field of a programme
	It does so by using if statements

	MovieManager 1 and 2 are different in the way they handle the original list of movies and how they add it to the field lists
	MovieManager 1 has one for loop that goes through the whole list and then adds items as needed
	MovieManager 2 has multiple for loops, the first is to create a new list of movies that are not simul casts
	and then individually move through that to add movies to their required section appropriately
	 */
	MovieManager1 mm1 = new MovieManager1();
	MovieManager2 mm2 = new MovieManager2();
	LinkedList<Movie> movies = new LinkedList<Movie>();
	LinkedList<Movie>allMovies = new LinkedList<Movie>();
	Programme programme1 = new Programme();
	Programme programme3 = new Programme();

	Movie starTrek = new Movie("Star Trek Into Darkness", 1400, 132, false);
	Movie pinicchio = new Movie("GUILLERMO DEL TORO'S PINOCCHIO", 945, 114, false);
	Movie swampThing = new Movie("RiffTrax Live: The Return of Swamp Thing", 2030, 118, true);
	Movie sevenSamurai = new Movie("Seven Samurai", 0, 207, false);



	// our own movies!
	Movie saw = new Movie ("Saw", 2300, 120, false);
	Movie nightmare = new Movie ("A Nightmare on Elm Street", 0, 120, false);
	Movie rogueone = new Movie ("Rogue One", 1400, 120, false);

	Movie oneMovie1 = new Movie ("Movie Number One", 700, 144, false);
	Movie twoMovie1 = new Movie ("Movie Number Two", 1200, 144, false);
	Movie threeMovie1 = new Movie ("Movie Number Three", 2000, 144, false);
	Movie fourMovie1 = new Movie ("Movie Number Four", 200, 144, false);
	Movie fiveMovie1 = new Movie ("Movie Number Five", 0, 144, false);



	public MovieExamples()
	{
		movies.add(starTrek);
		programme1.primetime.add(starTrek);

		movies.add(pinicchio);
		programme1.matinee.add(pinicchio);

		movies.add(swampThing);
		programme1.soiree.add(swampThing);

		movies.add(sevenSamurai);
		programme1.soiree.add(sevenSamurai);

		allMovies.add(oneMovie1);allMovies.add(twoMovie1);allMovies.add(threeMovie1);
		allMovies.add(fourMovie1);allMovies.add(fiveMovie1);

		programme3.matinee.add(oneMovie1);
		programme3.primetime.add(twoMovie1);
		programme3.soiree.add(threeMovie1);
		programme3.soiree.add(fiveMovie1);
	}
	@Test
	public void instructorTestProgramme_EmptyReport() {
		Programme report2 = new Programme();
		assertFalse(programme1.equals(report2));
	}


	@Test
	public void instructorTestProgramme_WrongOrder() {
		Programme programme2 = new Programme();

		programme2.primetime.add(starTrek);
		programme2.matinee.add(pinicchio);
		programme2.soiree.add(sevenSamurai);
		programme2.soiree.add(swampThing);


		assertFalse(programme1.equals(programme2));
	}

	@Test
	public void instructorTestProgramme_DifferentInstances() {
		Programme programme2 = new Programme();

		Movie starTrek2 = new Movie("Star Trek Into Darkness", 1400, 132, false);
		Movie pinocchio2 = new Movie("GUILLERMO DEL TORO'S PINOCCHIO", 945, 114, false);
		Movie swampThing2 = new Movie("RiffTrax Live: The Return of Swamp Thing", 2030, 118, true);
		Movie sevenSamurai2 = new Movie("Seven Samurai", 0, 207, false);

		programme2.primetime.add(starTrek2);
		programme2.matinee.add(pinocchio2);
		programme2.soiree.add(swampThing2);
		programme2.soiree.add(sevenSamurai2);

		assertTrue(programme1.equals(programme2));
	}

	@Test
	public void instructorTestProgramme_SameInstances() {
		Programme programme2 = programme1;
		assertTrue(programme1.equals(programme2));
	}


	@Test
	public void instructorTestOrganizeMovies()
	{
		Programme programme2 = mm1.organizeMovies(movies);
		programme1.soiree.remove(swampThing); //it's a simulcast
		assertEquals(programme1, programme2);
	}



	@Test
	public void ourTestProgramme_SameInstances() {
		Programme programme2 = programme3;
		assertTrue(programme3.equals(programme2));
	}


	//MovieManager2 Test for instructor cases
	@Test
	public void mm2TestOrganizeMovies()
	{
		Programme programme2 = mm2.organizeMovies(movies);
		programme1.soiree.remove(swampThing); //it's a simulcast

		assertEquals(programme1, programme2);
	}

	//MovieManager1 Test for edge cases of sorting movies in allMovies
	@Test
	public void firstTestOrganizeMovies()
	{
		Programme programme2 = mm1.organizeMovies(allMovies);
		assertEquals(programme3, programme2);
	}

	//MovieManager2 Test for edge cases of sorting movies in allMovies
	@Test
	public void secondTestOrganizeMovies()
	{
		Programme programme2 = mm2.organizeMovies(allMovies);
		assertEquals(programme3, programme2);
	}




}
