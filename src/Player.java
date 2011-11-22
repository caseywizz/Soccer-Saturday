/*
 * Class Player 
 * handling a player, storing player attributes and holding ArrayLists of:
 * . player positions
 * . player roles
 * . player numbers
 * 
 */
import java.util.ArrayList;


public class Player {

	ArrayList<Position> positions = new ArrayList<Position>();
	ArrayList<Role> roles = new ArrayList<Role>();
	ArrayList<Number> numbers = new ArrayList<Number>();
	
	public String playerName;
	public int playerNumber;
	
	public Player(String name, int playerNumber) {
		this.playerName = name;
		this.playerNumber = playerNumber;
	}
	
	// addPosition
	public void addPosition(Position position)
	{
	    if (!positions.contains(position))
		positions.add(position);
	}
	
	// addRole 
	public void addRole(Role role)
	{
	    if (!roles.contains(role))
		roles.add(role);
	}

	// addNumber
	public void addNumber(int number)
	{
		if (!numbers.contains(number))
			numbers.add(number);
	}
	
	public String toString()
	{
		return "\nName: " + playerName +
				"\nNumber: " + playerNumber +
				"\nPositions: " + positions +
				"\nRoles: " + roles;
	}
}
