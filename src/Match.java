import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/*
 * Class simulating a Match (game)
 * containing home team, away team, referee and stadium.
 * Generating random events through out the course of the game
 * */
public class Match {
	
	public ArrayList<MatchEvent> matchEvents = new ArrayList<MatchEvent>();
	Calendar startTime, startTimeClone;
	Calendar currentTime;
	public Team homeTeam;
	public Team awayTeam;
	public Referee referee;
	public String stadium;
	public int matchNo;
	public int matchDay;
	
	int homeHT;
	int awayHT;
	String halftimeResult; /* "H D R" */
	int homeFT;
	int awayFT;				
	String fulltimeResult;
	
	
	public Match(Team homeTeam, Team awayTeam, Referee ref, String stadium, int matchNo, int matchDay) {
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.referee = ref;
		this.stadium = stadium;
		this.matchNo = matchNo;
		this.matchDay = matchDay;
		
		// set the start time of the games
		startTime = Calendar.getInstance();
		startTimeClone = Calendar.getInstance();
		startTime.set(Calendar.HOUR_OF_DAY, 15);
		startTime.set(Calendar.MINUTE, 0);
		startTime.set(Calendar.SECOND, 0);
				
		// set the start time clone, which will change
		startTimeClone.set(Calendar.HOUR_OF_DAY, 15);
		startTimeClone.set(Calendar.MINUTE, 0);
		startTimeClone.set(Calendar.SECOND, 0);
	}
	
	public void addResult(int homeHT, int awayHT, String htResult, int homeFT, int awayFT, String ftResult)
	{
		this.homeHT = homeHT;
		this.awayHT = awayHT;
		this.halftimeResult = htResult;
		this.homeFT = homeFT;
		this.awayFT = awayFT;
		this.fulltimeResult = ftResult;
	}

    void playmatch() // main function simulating a match
    {	
    	currentTime = startTimeClone;
    	String currentEvent = "";
    	
 	    RandomTimeGenerator timeGen = RandomTimeGenerator.getInstance();
 	    EventGenerator eventGen = EventGenerator.getInstance();
 	    
    	System.out.println("Simulating Game" + "\n" + this);    	
    	boolean isPastHalfTime = false;
    	boolean isPastFullTime = false;
    	while (!isPastFullTime)
    	{ 	
    	   // Random events
    	   Date date = timeGen.generateTimeAfterDate(currentTime);
    	
    	   currentTime.setTime(date); 	     	   
    	   long difference = timeGen.getTimeDifferenceMillis(startTime, currentTime);
    	   if (isPastHalfTime == false && difference > timeGen.generateHTMillis())
    	   {
    		  {
    			  currentTime.set(Calendar.HOUR_OF_DAY, 16);
    			  currentTime.set(Calendar.MINUTE, 0);
    			  currentTime.set(Calendar.SECOND, 0);
    			  isPastHalfTime = true;
    			  
    			  System.out.println("HALF TIME");
    		  }//if
    	   }//if
    	   else if (isPastHalfTime == true && difference > (timeGen.generateHTMillis() * 7 / 3)) // to accomodate for the 15 minute pause
    	   {
    		   isPastFullTime = true;
    		   System.out.println("FULL TIME");
    	   }
    	   else // Here events get generated
    	   {
    		   currentEvent = eventGen.generateEvent();  
    		   
    		   if (currentEvent.equalsIgnoreCase("goal"))
    		   {
    				
    		   }//if
    	   }//else
    	   System.out.println("\nStartTime: " + startTime.getTime() + "\nEvent should occur at " + date
    			   + "\nisPastHalfTime: " + isPastHalfTime + ", " + "isPastFullTime: " + isPastFullTime 
    			   + "\nCurrentEvent: " + currentEvent);    	   
    	}//while   
	}
	
	public String toString()
	{
		return "\nMatchDay: " + matchDay + " MatchNo: " + matchNo +
				"\nHome Team: " + homeTeam.getTeamName() + 
				"\nAwayTeam: " + awayTeam.getTeamName()
				+
				"\nStadium: " + stadium + referee 
		        + "\nResults: (homeHT: " + homeHT + ", awayHT " + awayHT + ", halftimeResult: " + halftimeResult 
		        + ", homeFT: " + homeFT + ", awayFT: " + awayFT + " fulltimeResult: " + fulltimeResult + ")";
	}
	
	/*
	public int getMatchScores(Match m){ // retrieve number of goals in current game
		// implementation
		return match_scores;
	}
	
	
	public static void main(String[]args){
		playmatch(teamA, teamB);
	}
	*/
}
