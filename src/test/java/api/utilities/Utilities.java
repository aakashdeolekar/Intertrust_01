package api.utilities;

import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Utilities {
	
	// The date format needs a specific validation, so used a custom utility class
	public static String getFormattedDate(Instant instant) {
		ZonedDateTime gmtDateTime = instant.atZone(ZoneId.of("GMT"));
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE, d MMM yyyy");
	    String formattedDateTime = gmtDateTime.format(formatter);
	    return formattedDateTime;
	    
	}
	
	
	
	
	
	



}
