/*
 * Class PlayerParser
 * which accesses the teams xml file retrieving player info
 */
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class PlayerParser {
	
	Player player;
	public PlayerParser(Node playerNode)
	{
		if(playerNode != null && playerNode.getNodeType() == Node.ELEMENT_NODE)
		{
			NamedNodeMap attr = playerNode.getAttributes();
			String playerName = attr.getNamedItem("name").getTextContent(); 
			int playerNumber = Integer.parseInt(attr.getNamedItem("number").getTextContent());
			
		    player = new Player(playerName, playerNumber);
			
		    Element playerElement = (Element) playerNode;
			NodeList positionNodes = playerElement.getElementsByTagName("position");
			NodeList roleNodes = playerElement.getElementsByTagName("role");
						
			// Positions
			for(int i = 0; i < positionNodes.getLength(); i++)
			{
				Node node = positionNodes.item(i);
				String pos = node.getTextContent();
				
				Position position = Position.getPosition(pos);
				player.addPosition(position);
				//System.out.println("Position: " + pos + " name: " + playerName);
			}//for
			
			// Roles
			for(int i = 0; i < roleNodes.getLength(); i++)
			{
				Node node = roleNodes.item(i);
				String role = node.getTextContent();
				
				Role roleR = new Role(role);
				player.addRole(roleR);
			}//for
		}
	}
	
	public String toString()
	{
		return player.toString();
	}
}