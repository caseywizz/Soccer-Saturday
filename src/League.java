import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*
 * Class representing the EPL
 * */
public class League {
	static final private String LEAGUE_NAME = "Barclays English Premier League";
	static final private int NO_OF_TEAMS = 20;
	static final private int NO_OF_MATCH_DAYS = (NO_OF_TEAMS - 1) * 2;
	static final private int TOTAL_NO_OF_MATCHES = (NO_OF_TEAMS * NO_OF_MATCH_DAYS) / 2;

	private Team[] teams;
	private MatchDay[] matchdays; // = new MatchDay[NO_OF_MATCH_DAYS]; // array of match
															// days

	private League() { // league constructor
		read_teamsXML();
		read_seasondataXML();
	}

	private void read_teamsXML() {
		NodeList clubs = null;
		FileInputStream file = null;
		try {
			file = new FileInputStream("teams.xml");
			final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			try {
				final DocumentBuilder db = dbf.newDocumentBuilder();
				try {
					final Document doc = db.parse(file);
					clubs = doc.getElementsByTagName("club");
				} catch (SAXException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} // catch
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} // catch
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (file != null)
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				} // catch
		} // finally
		// continue...
		if(clubs == null)
			return;
		
		teams= new Team[clubs.getLength()];
		for (int i = 0; i < teams.length; i++){
			teams[i] = new Team(clubs.item(i));
		} // for
	
	} // read_teamsXML
	
	private void read_seasondataXML() {
		NodeList matchdaysList = null;
		FileInputStream file = null;
		try {
			file = new FileInputStream("seasondata.xml");
			final DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			try {
				final DocumentBuilder db = dbf.newDocumentBuilder();
				try {
					final Document doc = db.parse(file);
					matchdaysList = doc.getElementsByTagName("Match");
				} catch (SAXException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} // catch
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} // catch
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (file != null)
				try {
					file.close();
				} catch (IOException e) {
					e.printStackTrace();
				} // catch
		} // finally
		// continue...
		if(matchdays == null)
			return;
		
		matchdays = new MatchDay[matchdaysList.getLength()];
		for (int i = 0; i < teams.length; i++){
			teams[i] = new Team(matchdaysList.item(i));
		} // for
		
	} // read_seasondataXML


	public String getLeagueName() {
		return LEAGUE_NAME;
	}

	public int getNumberOfMatches() {
		return TOTAL_NO_OF_MATCHES;
	}
}
