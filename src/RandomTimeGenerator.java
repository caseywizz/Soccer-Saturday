import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class RandomTimeGenerator {

	public static RandomTimeGenerator instance;
	public Calendar cdr;
	long HTMillis = -1;
	public RandomTimeGenerator()
	{
		cdr = Calendar.getInstance();
	}
	public static RandomTimeGenerator getInstance()
	{
		if (instance == null) instance = new RandomTimeGenerator();
		return instance;
	}
	
	public Date generateTimeHT()
	{
		//code to generate random timestamp between 15:00 to 15:45 (1st Half)
		Calendar cdr = this.cdr;//Calendar.getInstance();
		cdr.set(Calendar.HOUR_OF_DAY, 15);
		cdr.set(Calendar.MINUTE, 0);
		cdr.set(Calendar.SECOND, 0);
		long val1=cdr.getTimeInMillis();

		cdr.set(Calendar.HOUR_OF_DAY, 15);
		cdr.set(Calendar.MINUTE, 45);
		cdr.set(Calendar.SECOND, 0);
		long val2=cdr.getTimeInMillis();

		Random r=new Random();
		long randomTS=(long)(r.nextDouble()*(val2-val1))+val1;
		Date d=new Date(randomTS);
		System.out.println(d.toString());
		return d;
	}

	// get time difference from start of match to halftime (HTMillis)
	public long generateHTMillis()
	{
		if (HTMillis < 0)
		{
		  Calendar cdr = Calendar.getInstance();
		  cdr.set(Calendar.HOUR_OF_DAY, 15);
		  cdr.set(Calendar.MINUTE, 0);
		  cdr.set(Calendar.SECOND, 0);
		  long val1=cdr.getTimeInMillis();

		  cdr.set(Calendar.HOUR_OF_DAY, 15);
		  cdr.set(Calendar.MINUTE, 45);
		  cdr.set(Calendar.SECOND, 0);
		  long val2=cdr.getTimeInMillis();

		  long diff = val2 - val1;
		  HTMillis = diff;
		}//if  
		return HTMillis;
	}
	
	
	public Date generateTimeFT()
	{
		//code to generate random timestamp between 16:00 to 16:45 (2nd Half)
		Calendar cdr = this.cdr;//Calendar.getInstance();
		cdr.set(Calendar.HOUR_OF_DAY, 16);
		cdr.set(Calendar.MINUTE, 0);
		cdr.set(Calendar.SECOND, 0);
		long val1=cdr.getTimeInMillis();

		cdr.set(Calendar.HOUR_OF_DAY, 16);
		cdr.set(Calendar.MINUTE, 45);
		cdr.set(Calendar.SECOND, 0);
		long val2=cdr.getTimeInMillis();

		Random r=new Random();
		long randomTS=(long)(r.nextDouble()*(val2-val1))+val1;
		Date d=new Date(randomTS);
		System.out.println(d.toString());
		return d;
	}
	
	public Date generateTimeBetweenDates(Calendar cdr, Calendar cdr2)
	{
		//code to generate random timestamp between event times		
		long val1=cdr.getTimeInMillis();
		long val2=cdr2.getTimeInMillis();

		Random r=new Random();
		long randomTS=(long)(r.nextDouble()*(val2-val1))+val1;
		Date d=new Date(randomTS);
		System.out.println(d.toString());
		return d;
	}
	
	// Max time between events is 4minutes
	public Date generateTimeAfterDate(Calendar currentTime)
	{
		//get currentTime
		long val1=currentTime.getTimeInMillis();

		// generate a time after the currenttime but not further than the allocated time limit between events
		long val2=val1 + Singleton.getInstance().getMaxTimeBetweenEventsInMillis();

		Random r=new Random();
		long randomTS=(long)(r.nextDouble()*(val2-val1))+val1;
		Date d=new Date(randomTS);
		//System.out.println(d.toString());
		return d;
	}
	
	// get time difference
		public long getTimeDifferenceMillis(Calendar time1, Calendar time2)
		{
			long val1=time1.getTimeInMillis();
			long val2=time2.getTimeInMillis();;
			return val2 - val1;
		}
}
