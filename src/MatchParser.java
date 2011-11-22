import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;


public class MatchParser {
	
	Match match;
	public MatchParser(Node matchdayNode)
	{
		if(matchdayNode != null && matchdayNode.getNodeType() == Node.ELEMENT_NODE)
		{
			NamedNodeMap attr = matchdayNode.getAttributes();
			int matchday = Integer.parseInt(attr.getNamedItem("Matchday").getTextContent());
			int matchNo = Integer.parseInt(attr.getNamedItem("MatchNo").getTextContent());
			String home = attr.getNamedItem("HomeTeam").getTextContent(); 
			String away = attr.getNamedItem("AwayTeam").getTextContent();
			String ref = attr.getNamedItem("Referee").getTextContent();

			// set home/away team and referee using Singleton
			Team hometeam = Singleton.getInstance().getTeam(home);
			Team awayteam = Singleton.getInstance().getTeam(away); 
			Referee referee = new Referee(ref);
			
		    Element matchElement = (Element) matchdayNode;
			String homeHTNodes = matchElement.getElementsByTagName("HT_HG").item(0).getTextContent();  
			String awayHTNodes = matchElement.getElementsByTagName("HT_AG").item(0).getTextContent();
			String halftimeResult = matchElement.getElementsByTagName("HT_R").item(0).getTextContent();				
			String homeFTNodes = matchElement.getElementsByTagName("FT_HG").item(0).getTextContent();
	      	String awayFTNodes = matchElement.getElementsByTagName("FT_AG").item(0).getTextContent();							
		    String fulltimeResult = matchElement.getElementsByTagName("FT_R").item(0).getTextContent();
				
		    // parse the args to create a new match
		   // try{
		    if(matchday > 0){
		    	match = new Match(hometeam, awayteam, referee, hometeam.getStadium(), matchNo, matchday); 
		    	// add the results of the match to the match
		    	match.addResult(Integer.parseInt(homeHTNodes), Integer.parseInt(awayHTNodes),
		    			halftimeResult, Integer.parseInt(homeFTNodes), Integer.parseInt(awayFTNodes), fulltimeResult);
		    	}
		    
			/*}
		    catch(NullPointerException e)
		    {
		    } */

		}
	}
	
	public String toString()
	{
		return match.toString();
	}
}