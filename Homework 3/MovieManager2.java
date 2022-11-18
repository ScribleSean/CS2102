import java.util.LinkedList;

class MovieManager2 {

	MovieManager2() {
	}
	// for loop but each type of programme ex. matinee, soiree, primetime
	// all movies that dont have similcast (ex. noSimul)
	// then make another forloop -- based on showtimes

	public Programme organizeMovies(LinkedList<Movie> movies) {
		LinkedList<Movie> notSimul = new LinkedList<Movie>();
		LinkedList<Movie> matinee = new LinkedList<Movie>();
		LinkedList<Movie> soiree = new LinkedList<Movie>();
		LinkedList<Movie> primetime = new LinkedList<Movie>();


		for (Movie n : movies) {
			if (!n.simulcast) {
				notSimul.add(n);

				for (Movie m : notSimul) {
					if ((m.showtime >= 0700) && (m.showtime < 1200)) {
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
					if ((s.showtime >= 2000) || (s.showtime < 0200)) {
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


