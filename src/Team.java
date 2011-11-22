
import java.util.ArrayList;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Team {
	private String teamName;
	public String getTeamName() {
		return teamName;
	}

	private String location;
	private String stadium;
	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	private String capacity;
	private String manager;
	
	ArrayList<PlayerParser> players = new ArrayList<PlayerParser>();

	public Team(final String name) {
		this.teamName = name;
	}
	
	public Team(Node clubNode) {
		//clubNode.getAttributes().getNamedItem("name");
		if (clubNode != null && clubNode.getNodeType() == Node.ELEMENT_NODE) {
			NamedNodeMap attr = clubNode.getAttributes();
			teamName = attr.getNamedItem("name").getTextContent(); 
			location = attr.getNamedItem("location").getTextContent();
			stadium = attr.getNamedItem("stadium").getTextContent();
			manager = attr.getNamedItem("manager").getTextContent();
			capacity = attr.getNamedItem("capacity").getTextContent();
			final Element clubElement = (Element) clubNode;
			NodeList playersNodes = clubElement.getElementsByTagName("players");
		
			for(int i = 0; i < playersNodes.getLength(); i++) 
			{
				NodeList playerNode = ((Element) playersNodes.item(i)).getElementsByTagName("player");
				
				for(int j = 0; j < playerNode.getLength(); j++)
					players.add(new PlayerParser(playerNode.item(j)));

			}//for	
		}
	} // Team(Node)
	
	public String toString()
	{
		return "\nTeam Name: " + teamName + "| Location: " + location +
				"| Stadium: " + stadium + "| Capacity: " + capacity + 
				"| Manager: " + manager +
				"\nPlayers: " + players;

	}

}
