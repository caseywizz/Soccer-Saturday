
public class ScoreLine {
	
	private int[] scores = {0,1,2,3,4,5,6,7,8,9,10};
	private enum Result {H,D,A}

	private int homeHT = 0; 
	private int awayHT = 0; 
	private String resultHT = "D"; 
	private int homeFT = 0; 
	private int awayFT = 0;
	private String resultFT = "D";
	
	Match match;
	public ScoreLine(int homeHT, int awayHT, String resultHT, int homeFT, int awayFT, String resultFT) {
		this.homeHT = homeHT;
		this.awayHT = awayHT;
		this.resultHT = resultHT;
		this.homeFT = homeFT;
		this.awayFT = awayFT;
		this.resultFT = resultFT;
	} // ScoreLine Constructor
	
	public ScoreLine getfinalScoreLine(int homeFT, int awayFT, String resultFT)
	{
		ScoreLine finalScore = null;
		match.awayFT = awayFT;
		match.homeFT = homeFT;
		return finalScore;
	}
/*	
	public int halftimeScore()
	{
		
	} // halftimeScore
	
	public int fulltimeScore()
	{
		
	} // fulltimeScore
	
	/*
	public int getScores(int homeHT){
		if(homeHT <= scores.length)
			return homeHT;
	}
		if(awayHT <= scores.length)
			return awayHT;
		if(homeFT <= scores.length)
			return homeFT;
		if(awayFT <= scores.length)
			return awayFT;
		else 
			return 0;
	}
	*/
	
	Result result;
	public ScoreLine(Result result) {
		this.result = result;
	}
	
	public void results() {
		switch (result) {
			case H: System.out.println("Home Team Wins");
					break;
					
			case D: System.out.println("It is a Draw");
					break;
					     
			case A: System.out.println("Away Team Wins");
		     		break;
		}
	}
	
}
