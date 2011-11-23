import java.util.Date;

public class Handball extends PriorityEvent 
{
	Player handler;
	Date time_of_handball;
	Freekick resultsinfreekick;
	Penalty resultsinpenalty;
	
	public Handball(Match match) { 
		super(match);
	}

	public Handball(Match match, Player handler, Date time_of_handball) { 
		super(match);
		this.handler = handler;
		this.time_of_handball = time_of_handball;
	}

	public Freekick resultsinfreekick()
	{
		return resultsinfreekick;
	}
	
	public Penalty resultsinpenalty()
	{
		return resultsinpenalty;
	}
	
	String occur(){ // implementation of a goal
		return "It's a Handball!!  handler: " + handler.playerName;
	}
}