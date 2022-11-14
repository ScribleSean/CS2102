import java.util.LinkedList;

class Programme {
	
	LinkedList<Movie> matinee;
	LinkedList<Movie> primetime;
	LinkedList<Movie> soiree;
	
	Programme()
	{
		this.matinee = new LinkedList<Movie>();
		this.primetime = new LinkedList<Movie>();
		this.soiree = new LinkedList<Movie>();
	}
	
	Programme(LinkedList<Movie> matinee, LinkedList<Movie> primetime, LinkedList<Movie> soiree)
	{
		this.matinee = matinee;
		this.primetime = primetime;
		this.soiree = soiree;
	}


}
