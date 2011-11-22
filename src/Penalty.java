/*
 * Class Penalty (a Priority Event) which extends a MatchEvent
 * implements the penalty event.
 */
import java.util.Date;

public class Penalty extends PriorityEvent 
{
	Player taker, culprit, pk_winner, goal_keeper;
	Team team_taking, team_conceeding;
	Date time_of_penalty;
	
	public Penalty(Match match) { 
		super(match);
	}

	public Penalty(Match match, Player pk_winner, Player taker, Player culprit, Player gk, Team team_taking, Team team_conceeding, Date time_of_penalty) { 
		super(match);
		this.pk_winner = pk_winner;
		this.taker = taker;
		this.culprit = culprit;
		this.goal_keeper = gk;
		this.team_taking = team_taking;
		this.team_conceeding = team_conceeding;
		this.time_of_penalty = time_of_penalty;
	}

	
	String occur(){ // implementation of a penalty
		return "Penalty!!! taker: " + taker.playerName;
	}
}