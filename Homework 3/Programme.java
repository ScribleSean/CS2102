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

	public boolean equals(Object obj)
	{
		if(! (obj instanceof Programme))
			return false;
		Programme twoProg = (Programme) obj;

		int allConditionsMet=0;
		int innerConditionsMet=0;
		if(this.matinee.size()==twoProg.matinee.size())
		{
			for(int i=0; i<this.matinee.size();i++)
			{
				Movie a = this.matinee.get(i);
				Movie b = twoProg.matinee.get(i);
				if((a.title==b.title)&&(a.showtime == b.showtime))
				{
					innerConditionsMet++;
				}
			}
			if(innerConditionsMet==(this.matinee.size()))
			{
				allConditionsMet++;
			}
		}
		innerConditionsMet=0;
		if(this.primetime.size()==twoProg.primetime.size())
		{
			for(int i=0; i<this.primetime.size();i++)
			{
				Movie a = this.primetime.get(i);
				Movie b = twoProg.primetime.get(i);
				if((a.title==b.title)&&(a.showtime == b.showtime))
				{
					innerConditionsMet++;
				}
			}
			if(innerConditionsMet==(this.primetime.size()))
			{
				allConditionsMet++;
			}
		}
		innerConditionsMet=0;
		if(this.soiree.size()==twoProg.soiree.size())
		{
			for(int i=0; i<this.soiree.size();i++)
			{
				Movie a = this.soiree.get(i);
				Movie b = twoProg.soiree.get(i);
				if((a.title==b.title)&&(a.showtime == b.showtime))
				{
					innerConditionsMet++;
				}
			}
			if(innerConditionsMet==(this.soiree.size()))
			{
				allConditionsMet++;
			}
		}

		if(allConditionsMet==3) {
			return true;
		}
		else {
			return false;
		}
	}
}