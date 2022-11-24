import java.util.LinkedList;

class MovieManager2 {

	MovieManager2() {
	}

	/*
	 * This method exists to produce a new programme from a given list of movies that contains all the
	 * movies (matinee/primetime/soiree showings) which ARE NOT SIMULCASTS. This is different from MovieManager1 because
	 * we used separate for loops to build lists for the different types of movie based on showtimes.
	 *  @param    movies		A list of movies.
	 *  @return   Programme	    A programme containing the list of movies, discounting the movies which include
	 * simulcasts.
	 */

	public Programme organizeMovies(LinkedList<Movie> movies) {
		LinkedList<Movie> notSimul = new LinkedList<Movie>();
		LinkedList<Movie> matinee = new LinkedList<Movie>();
		LinkedList<Movie> soiree = new LinkedList<Movie>();
		LinkedList<Movie> primetime = new LinkedList<Movie>();


		for (Movie n : movies) {
			if (!n.simulcast) {
				notSimul.add(n);

				for (Movie m : notSimul) {
					if ((m.showtime >= 700) && (m.showtime < 1200)) {
						matinee.add(m);
						notSimul.remove(m);
					}
				}


				for (Movie p : notSimul) {
					if ((p.showtime >= 1200) && (p.showtime < 2000)) {
						primetime.add(p);
						notSimul.remove(p);
					}
				}


				for (Movie s : notSimul) {
					if ((s.showtime >= 2000) || (s.showtime < 200)) {
						soiree.add(s);
						notSimul.remove(s);
					}
				}

			}
		}
		Programme finalProgramme = new Programme(matinee, primetime, soiree);
		return finalProgramme;
	}
}


