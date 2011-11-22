
import java.util.Date;

/*
 * Abstract class containing all possible events (Priority && Ordinary)
 * */
public abstract class MatchEvent {
	Date eventTime;					// time of event
	Match match;					// current match

	abstract String occur();
	
	public MatchEvent(Match match)
	{
		this.match = match;
		
	}//MatchEvent

	public boolean executeCurrentEvent(String currentEvent)
	{
		return true;
	}
}
