package api.test;
 
import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SignupTest {
		
	@Test
	public void testSignup() {
		Faker faker = new Faker();
		String randommail = faker.name().username() + "123" + "@gmail.com";
		RestAssured.baseURI = "https://api-staging-builder.engineer.ai";
		String signupPayload = "{\"user\":{\"first_name\": \"acs\", \"email\": \"mail\","
				+ "\"phone_number\": \"+62-89635845000\", \"currency\": \"YEN\", \"password\": \"nananana88\"}}";
		String signupPayload2 = signupPayload.replace("$.mail", randommail);
		Response response = RestAssured.given().contentType("application/json").body(signupPayload2)
				.when().post("/users");
		assertEquals(response.getStatusCode(),200);
	}


}
