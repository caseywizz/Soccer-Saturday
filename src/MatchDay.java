//import java.util.ArrayList;

//import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;

/*
 * Class simulating one Match Day
 * */
public class MatchDay {
		
    //ArrayList<MatchParser> matches = new ArrayList<MatchParser>();
	MatchParser match;
	public Match getMatch() {
		return match.match;
	}

	public int matchNo;
	public int matchDay;
	
	public MatchDay(int matchday) {
		this.matchDay = matchday;
	}

	public MatchDay(Node matchNode)
	{   
	
		if (matchNode != null && matchNode.getNodeType() == Node.ELEMENT_NODE) {
			NamedNodeMap attr = matchNode.getAttributes();

			matchNo = Integer.parseInt(attr.getNamedItem("MatchNo").getTextContent());
			matchDay = Integer.parseInt(attr.getNamedItem("Matchday").getTextContent());
			
			// Add the matches
			//matches.add(new MatchParser(matchNode));	
			match = new MatchParser(matchNode);
			/*			
			final Element matchElement = (Element) matchNode;
			NodeList detNodes = matchElement.getElementsByTagName("Match");
		
			for(int i = 0; i < detNodes.getLength(); i++) 
			{
				matches.add(new MatchParser(detNodes.item(i)));

			}//for
			*/
		}
		
	} // Match(Node)
	

	public String toString()
	{
		return "\nMatch Day: " + matchDay +
				"\nMatch No: " + matchNo +
				match;
	}
/*	
	ArrayList<MatchParser> matches;// = new ArrayList<Matches>();
	
	public MatchDay(String saturday){
		this.matchday = saturday;
	}
	
	public MatchDay(Node matchdayNode){
		if (matchdayNode != null && matchdayNode.getNodeType() == Node.ELEMENT_NODE) {
			NamedNodeMap attr = matchdayNode.getAttributes();
			matchday = attr.getNamedItem("Match").getTextContent(); 
			
			final Element matchdayElement = (Element) matchdayNode;
			NodeList gameNode = matchdayElement.getElementsByTagName("Match");
		
			for(int i = 0; i < gameNode.getLength(); i++)
				matches.add(new MatchParser(gameNode.item(i)));
		}
	}
	
	public String toString()
	{
		return "Match Day: " + matchday;
	}
	public String getMatches(){
		for(int i = 0; i < matches.size(); i++)
			System.out.println("The Matches played today are: " + i);
		return null;
	} */
}
