
public class PriorityEvent extends MatchEvent {
	
	public PriorityEvent(Match match) {
		super(match);
		// TODO Auto-generated constructor stub
	}

	@Override
	String occur() {
		// TODO Auto-generated method stub	
		return "";
	}

	public MatchEvent goal()
	{
		//this = new Goal();
		return null;
	}
	
	public MatchEvent penalty()
	{
	    // this = new Penalty();	
		return null;
	}
	
	public MatchEvent freekick()
	{
		//this = new Freekick();
		return null;
	}
	
	public MatchEvent handball()
	{
		//this = new Handball();
		return null;
	}
	
	public MatchEvent substitution()
	{
		//this = new Substitution();
		return null;
	}
	
	public MatchEvent missedPenalty()
	{
		return null;
	}
	
	public MatchEvent injuredPlayer()
	{
		return null;
	}
	
	public MatchEvent equalizer()
	{
		return null;
	}
	
	public MatchEvent offTheLine()
	{
		return null;
	}
	
	public MatchEvent redCard()
	{
		return null;
	}
	
	public MatchEvent yellowCard()
	{
		return null;
	}
	
}
