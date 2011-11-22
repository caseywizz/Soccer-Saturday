import java.util.Date;

public class Freekick extends PriorityEvent 
{
	Player taker, culprit, fk_winner, goal_keeper;
	Team team_taking, team_conceeding;
	Date time;
	
	public Freekick(Match match) { 
		super(match);
		// TODO Auto-generated constructor stub
	}

	public Freekick(Match match, Player pk_winner, Player scorer, Player culprit, Player gk, Team team_scored, Team team_conceded, Date time_of_goal) { 
		super(match);
		this.fk_winner = pk_winner;
		this.taker = scorer;
		this.culprit = culprit;
		this.goal_keeper = gk;
		this.team_taking = team_scored;
		this.team_conceeding = team_conceded;
		this.time = time_of_goal;
		// TODO Auto-generated constructor stub
	}

	
	String occur(){ // implementation of a goal
		return "Freekick!!! taker: " + taker.playerName;
	}
}