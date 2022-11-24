import java.util.LinkedList;

class MovieManager1 {


	/*
	 * This method exists to produce a new programme from a given list of movies that contains all the
	 * movies (matinee/primetime/soiree showings) which ARE NOT SIMULCASTS.
	 *  @param    movies		A list of movies.
	 *  @return   Programme	    A programme containing the list of movies, discounting the movies which include
	 * simulcasts.
	 */

	public Programme organizeMovies(LinkedList<Movie> movies)
	{
		LinkedList<Movie> matinee = new LinkedList<Movie>();
		LinkedList<Movie> soiree = new LinkedList<Movie>();
		LinkedList<Movie> primetime = new LinkedList<Movie>();

		for(Movie m: movies){
			if(!m.simulcast){
				if((m.showtime >= 700) && (m.showtime < 1200)){
					matinee.add(m);
				}
				else if((m.showtime >= 1200) && (m.showtime < 2000)){
					primetime.add(m);
				}
				else if((m.showtime >= 2000) || (m.showtime < 200)){
					soiree.add(m);
				}

			}
		}

		Programme theProgramme = new Programme(matinee, primetime, soiree);
		return theProgramme;
	}
}
