package api.model;

import java.util.List;
import java.util.Map;

// Created to Map the fields of the JSON
public class ResponseMapper {
		
	    Integer queryCost;
	    Double latitude;
	    Double longitude;
	    String resolvedAddress;
	    String address;
	    String timezone;
	    Double tzoffset;
	    String description;
	    
	    List<Map<String, Object>> days;
	    
	    List alerts;
	    
	    Map<String, Map<String, Object>> stations;
	    
	    Map<String, Object> currentConditions;

}


