
import java.util.Date;


public class Goal extends PriorityEvent 
{
	Player scorer, assist, goal_keeper;
	Team team_scored, team_conceeded;
	Date time_of_goal;
	
	public Goal(Match match) { 
		super(match);
		// TODO Auto-generated constructor stub
	}

	public Goal(Match match, Player scorer, Player assist, Player gk, Team team_scored, Team team_conceded, Date time_of_goal) { 
		super(match);
		this.scorer = scorer;
		this.assist = assist;
		this.goal_keeper = gk;
		this.team_scored = team_scored;
		this.team_conceeded = team_conceded;
		this.time_of_goal = time_of_goal;
		// TODO Auto-generated constructor stub
	}

	
	String occur(){ // implementation of a goal
		return "Goal!!! scorer: " + scorer.playerName;
	}
}
