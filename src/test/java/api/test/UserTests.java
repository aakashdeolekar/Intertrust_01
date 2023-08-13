package api.test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Map;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.Utilities;
import io.restassured.response.Response;

public class UserTests{
	
	Faker faker;
	User userPayload;
	
	
	@BeforeClass
	public void setupData() {
		
		faker=new Faker();
		userPayload=new User();	
	}
	
	
	@Test(priority=1)
	public void testGetUserByName() {
		Response response= UserEndPoints.readUser();
		
		// Verifying Headers
		
		String currentTime = response.header("Date").substring(0, 16);
		Assert.assertEquals(currentTime,Utilities.getFormattedDate(Instant.now()));
		Assert.assertEquals(response.header("Content-Type"),"application/json");
		Assert.assertEquals(response.header("X-Powered-By"),"Visual Crossing Weather");
		Assert.assertEquals(response.header("Connection"), "keep-alive");
		Assert.assertEquals(response.getStatusCode(),200);
		
		//Verifying JSON body data : Maps helps to get the JSON in Key-Value Pair.
		
		Map<String, Object> responseMap = response.jsonPath().getMap("$");
		
		Assert.assertEquals(responseMap.get("queryCost"), 1);
		Assert.assertEquals(responseMap.get("latitude"),21.1571);
		Assert.assertEquals(responseMap.get("longitude"),"79.0822");
		Assert.assertEquals(responseMap.get("resolvedAddress"),"Nagpur, MH, India");
		Assert.assertEquals(responseMap.get("address"),"Nagpur");
		Assert.assertEquals(responseMap.get("timezone"),"Asia/Kolkata");
		Assert.assertEquals(responseMap.get("tzoffset"), "5.5");
		Assert.assertEquals(responseMap.get("description"),"Similar temperatures continuing with a chance of rain Monday, Tuesday & Wednesday.");
		
		//ArrayList bring up all the JSON data object, and thus we can perform the validation tasks
		
		ArrayList<Map<String, Object>> daysDataList = (ArrayList) responseMap.get("days");
		String datetime = (String) daysDataList.get(0).get("datetime");
		int datetimeEpoch = (Integer) daysDataList.get(0).get("datetimeEpoch");
		float tempmax = (float) daysDataList.get(0).get("tempmax");
		float snow = (float) daysDataList.get(0).get("snow");
		String conditions = (String) daysDataList.get(0).get("conditions");

		Assert.assertEquals(datetime,"2023-08-13");
		Assert.assertEquals(datetimeEpoch,1691778600);
		Assert.assertEquals(tempmax,33.0);
		Assert.assertEquals(snow,0.0);
		Assert.assertEquals(conditions,"Rain, Partially cloudy");
			
	}
		
}

	
	
	
	
	