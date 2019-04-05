import java.time.*;

public class DateTimePractice{

	public static void main(String[] args){
		LocalDate date = LocalDate.of(2018, Month.MARCH, 5);
		System.out.println("Date: " + date); //prints 2013-03-05
		
		LocalTime time = LocalTime.of(2, 30, 14, 30);
		System.out.println("Time: " + time);
		
		LocalDateTime dt = LocalDateTime.of(date, time);
		System.out.println("Date AND Time: " + dt);
		
		System.out.println("Current Date AND Time: " + ZonedDateTime.now() + "\n");
		
		ZoneId zoneWC = ZoneId.of("America/Los_Angeles");
		ZoneId zoneEC = ZoneId.of("US/Eastern");
		ZoneId timeZoneZero = ZoneId.of("GMT");
		LocalDate d = LocalDate.of(2019, Month.APRIL, 5);
		LocalTime t = LocalTime.of(10, 20);
		ZonedDateTime zEC = ZonedDateTime.of(d, t, zoneEC);
		ZonedDateTime zWC = ZonedDateTime.of(d, t, zoneWC);
		ZonedDateTime zGMT = ZonedDateTime.of(d, t, timeZoneZero);
		System.out.println("East Coast: " + zEC);
		System.out.println("West Coast: " + zWC);
		System.out.println("GMT (TIME ZONE ZERO): " + zGMT + "\n");
		
		
		Period p = Period.of(2, 3, 14);
		System.out.println("Formatted String for every 2 years, 3 months, and 14 days: " + p + "\n");
		
		try{
			LocalDate dateInvalid = LocalDate.of(2018, Month.APRIL, 56); //this line throws DateTimeException because there is no April 56th
			System.out.println(dateInvalid);
		}
		catch(Exception e){
			System.out.println("Exception (because we tried to create a date of April 56th, 2018): " + e + "\n");	
		}
		
		LocalDate dateRev = LocalDate.of(2018, Month.OCTOBER, 12);
		System.out.println("This is a date: " + dateRev);
		System.out.println("This is the date (immediately above) plus four days: " + dateRev.plusDays(4));
		//dateRev = dateRev.plusDays(4);
		System.out.println("This is the original date because we did not store the result of the plusDays() method in a reference variable: " + dateRev);
	}
}