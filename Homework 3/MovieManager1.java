import java.util.LinkedList;

class MovieManager1 {

	public Programme organizeMovies(LinkedList<Movie> movies)
	{
		LinkedList<Movie> matinee = new LinkedList<Movie>();
		LinkedList<Movie> soiree = new LinkedList<Movie>();
		LinkedList<Movie> primetime = new LinkedList<Movie>();

		for(Movie m: movies){
			if(m.simulcast == false){
				if((m.showtime >= 0700) && (m.showtime < 1200)){
					matinee.add(m);
				}
				else if((m.showtime >= 1200) && (m.showtime < 2000)){
					primetime.add(m);
				}
				else if((m.showtime >= 2000) || (m.showtime < 0200)){
					soiree.add(m);
				}

			}
		}

		Programme theProgramme = new Programme(matinee, primetime, soiree);
		return theProgramme;
	}
}
