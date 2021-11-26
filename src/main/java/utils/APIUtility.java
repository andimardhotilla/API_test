package utils;

import io.restassured.response.Response;

public class APIUtility {
	
//	verified status code, apakah berhasil di 200 OK
	public static boolean verifyStatusCodeSuccess(Response response) {
		return response.getStatusCode() == 200;
	}
	
//	get body data
	public static <T> T getBodyDataUsingJsonPath(Response response, String JsonPath) { 	//<T> untuk panggil smua type data boolean int string etc
		return response.jsonPath().get(JsonPath);
	}

}
