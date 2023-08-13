package api.endpoints;

import static io.restassured.RestAssured.given;


import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class  UserEndPoints {
	
	
	// POST REQUEST
	public static Response creteUser(User payload) {
		
		Response response = given()
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.body(payload)
					.when()
						.post(routes.post_url);
		
		return response;
	}
	
	// GET REQUEST
	public static Response readUser() {
		
		Response response = given()
						.contentType(ContentType.JSON)
						
						
					.when()
						.get(routes.base_url);
		
		return response;
	}
	
	// PUT REQUEST
	public static Response updateUser(String userName, User payload) {
		
		Response response = given()
						.contentType(ContentType.JSON)
						.accept(ContentType.JSON)
						.pathParam("username", userName)
						.body(payload)
						
					.when()
						.put(routes.update_url);
		
		return response;
	}
	
	// DELETE REQUEST
		public static Response deleteUser(String userName) {
			
			Response response = given()
							.pathParam("username", userName)
							
						.when()
							.delete(routes.delete_url);
			
			return response;
		
		}
	
	

}
