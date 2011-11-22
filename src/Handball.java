import java.util.Date;

public class Handball extends PriorityEvent 
{
	Player handler;
	Date time_of_handball;
	
	public Handball(Match match) { 
		super(match);
	}

	public Handball(Match match, Player handler, Date time_of_handball) { 
		super(match);
		this.handler = handler;
		this.time_of_handball = time_of_handball;
	}

	
	String occur(){ // implementation of a goal
		return "It's a Handball!!  handler: " + handler.playerName;
	}
}