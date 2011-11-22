/*
 * Abstract Class Position 
 * containing possible player positions (serves as a super class to specific player positions
 */
public abstract class Position {

    enum GoalKeeperPos {  GK; }
    enum DefenderPos {  DF; }
    enum MidfielderPos {  MF; }
    enum ForwardPos {  FW; }
    
	public static Position getPosition(String pos)
	{
		Position finalPosition = null;
		//System.out.println(" The position is " + pos);
		
		// Goal Keeper
		for (GoalKeeperPos position : GoalKeeperPos.values()) {
  	         if (position.toString().equalsIgnoreCase(pos))
  	         {
  	        	 finalPosition = new GoalKeeper(position);
  	         }
		} 
		
		// Midfield
		for (MidfielderPos position : MidfielderPos.values()) {
 	         if (position.toString().equalsIgnoreCase(pos))
 	         {
 	        	 finalPosition = new Midfielder(position);
 	         }
		} 
		
	   //Defence
		for (DefenderPos position : DefenderPos.values()) {
 	         if (position.toString().equalsIgnoreCase(pos))
 	         {
 	        	 finalPosition = new Defender(position);
 	         }
		} 
		
		//Forward
		for (ForwardPos position : ForwardPos.values()) {
 	         if (position.toString().equalsIgnoreCase(pos))
 	         {
 	        	 finalPosition = new Forward(position);
 	         }
		} 
		
  	    return finalPosition;
	}
	
	public String toString()
	{
		if (this instanceof GoalKeeper)
			return ((GoalKeeper) this).position.toString();
		
		else if (this instanceof Midfielder)
			return ((Midfielder) this).position.toString();
		
		else if (this instanceof Forward)
			return ((Forward) this).position.toString();
		
		else if (this instanceof Defender)
			return ((Defender) this).position.toString();
		else return "Underfined Position";
	}
}
