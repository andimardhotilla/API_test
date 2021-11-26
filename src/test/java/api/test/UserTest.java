package api.test;
 
import static io.restassured.RestAssured.given; 
import org.testng.annotations.Test;
import io.restassured.response.Response;
import restassured.apis.APIEndpoints;
import utils.APIUtility;

public class UserTest extends UserTestNeeds{
		
	@Test
	public void testUser() {
		Response response = given().spec(loginJsonSpec).when().get(APIEndpoints.atashi);
		APIUtility.verifyStatusCodeSuccess(response);
	}


}
