import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;


public class Test {

	public static void main(String[] args) {
		  
	      Singleton singleton = Singleton.getInstance();
      try {
    	      
    	      File file = new File("src/teams.xml");
			  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			  DocumentBuilder db = dbf.newDocumentBuilder();
			  Document doc = db.parse(file);
			  doc.getDocumentElement().normalize();
			  
			  System.out.println("Root element " + doc.getDocumentElement().getNodeName());
			  NodeList nodeLst = doc.getElementsByTagName("club");
			  System.out.println("Information of all teams");

			    for (int s = 0; s < nodeLst.getLength(); s++) 
			    {
				  Team team = new Team(nodeLst.item(s));	
				
				  //add the team to the instance
				  singleton.addTeam(team);
			      //System.out.println(team);			   
			    }
			  } catch (Exception e) {
			    e.printStackTrace();
			  } 

		try 
		{
			  File file = new File("src/seasondata.xml");
			  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			  DocumentBuilder db = dbf.newDocumentBuilder();
			  Document doc = db.parse(file);
			  doc.getDocumentElement().normalize();
			  
			  System.out.println("Root element " + doc.getDocumentElement().getNodeName());
			  NodeList nodeLst = doc.getElementsByTagName("Match");
			  System.out.println("Information of all matches");

			  for (int s = 0; s < nodeLst.getLength(); s++) 
			  {
				MatchDay matchday = new MatchDay(nodeLst.item(s));			
				// Add the match
				singleton.addMatch(matchday);
			    //System.out.println(matchday);			   
			  }
			  } catch (Exception e) {
			    e.printStackTrace();
			  } 
		
		
		     // Run the events in the background
		     /* From matchday 1 to matchday 38 */
		     for (int i =1; i < 39; i++)
		     {
		    	 //System.out.println("MatchDay: " + i);
		    	 ArrayList<MatchDay> matchday = Singleton.getInstance().getMatches(i);
		    	 for (int j = 0; j < matchday.size(); j++)
		    	 {
		    		 //It is from 1 to 10 
		    		 //MatchDay match = Singleton.getInstance().getMatchDay(i);
		    		 MatchDay match = matchday.get(j);
		    	     match.getMatch().playmatch();
		    		 
		    	 }
		     }
	}

}
