import java.util.Date;

public class Substitution extends PriorityEvent 
{
	Player old_player, new_player;
	Date time;
	
	public Substitution(Match match) { 
		super(match);
		// TODO Auto-generated constructor stub
	}

	public Substitution(Match match, Player old_player, Player new_player, Date time_of_goal) { 
		super(match);
		this.old_player = old_player;
		this.new_player = new_player;
		this.time = time_of_goal;
		// TODO Auto-generated constructor stub
	}

	
	String occur(){ // implementation of a goal
		return "Substitution!!! taker: " + new_player.playerName;
	}
}