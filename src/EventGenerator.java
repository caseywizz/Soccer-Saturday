import java.util.ArrayList;
import java.util.Random;


public class EventGenerator {

	ArrayList<String> possibleEventMethodNames = new ArrayList<String>();
	public static EventGenerator instance;

	public static EventGenerator getInstance()
	{
		if (instance == null) instance = new EventGenerator();
		return instance;
	}
	
	public EventGenerator()
	{
		//load the list of events
		possibleEventMethodNames.add("freekick");
		possibleEventMethodNames.add("penalty");
		possibleEventMethodNames.add("handball");
		possibleEventMethodNames.add("substitution");
	}
	
	public String generateEvent()
	{
	   Random randomGenerator = new Random();
	   int index = randomGenerator.nextInt(possibleEventMethodNames.size());
       return possibleEventMethodNames.get(index);
	}
}
