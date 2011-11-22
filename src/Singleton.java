import java.util.ArrayList;
import java.util.Calendar;


public class Singleton {

	public static Singleton instance;
	
	public ArrayList<Team> teams = new ArrayList<Team>();
	public ArrayList<MatchDay> matches = new ArrayList<MatchDay>();
	public int maxTimeInMinutesBetweenEvents = 4;
	public long maxTimeBetweenEventsInMillis = 2;
	public long getMaxTimeBetweenEventsInMillis() {
		return maxTimeBetweenEventsInMillis;
	}

	public Singleton() {
		//code to generate random timestamp between morning 6 to evening 8 pm
	    Calendar cdr = Calendar.getInstance();
		cdr.set(Calendar.HOUR_OF_DAY, 15);
		cdr.set(Calendar.MINUTE, 0);
		cdr.set(Calendar.SECOND, 0);
		long val1=cdr.getTimeInMillis();

		cdr.set(Calendar.HOUR_OF_DAY, 15);
		cdr.set(Calendar.MINUTE, maxTimeInMinutesBetweenEvents);
		cdr.set(Calendar.SECOND, 0);
		long val2=cdr.getTimeInMillis();
		
		maxTimeBetweenEventsInMillis = val2 - val1;
	}
	
	public static Singleton getInstance()
	{
		if (instance == null)
		{
		   instance = new Singleton();
		}
		return instance;
	}
	
	public void addTeam(Team team)
	{
		teams.add(team);
	}//addTeam
	
	public void addMatch(MatchDay match)
	{
		matches.add(match);
	}//addTeam
    
	public Team getTeam(String team)
	{
		for (int i = 0; i < teams.size(); i++)
		{
			Team t = teams.get(i);
			if (t.getTeamName().equalsIgnoreCase(team))
			{
				return t;
			}
		}
		return null;
	}
	
	public ArrayList<MatchDay> getMatches(int matchday)
	{
		ArrayList<MatchDay> result = new ArrayList<MatchDay>();
		for (int i = 0; i < matches.size(); i++)
		{
			MatchDay t = matches.get(i);
			if (t.matchDay == matchday)
			{
				result.add(t);
			}
		}
		return result;
	}
	
	public MatchDay getMatch(int matchday, int matchno)
	{
		// Get the list of matches on the "matchday"
		ArrayList<MatchDay> result = getMatches(matchday);
		for (int i = 0; i < result.size(); i++)
		{
			// Get the specific match on the "matchday"
			MatchDay t = result.get(i);
			if (t.matchNo == matchno)
			{
				return t;
			}
		}
		return null;
	}
}