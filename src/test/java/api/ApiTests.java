package api;

import core.builders.CreateLaunchBuilder;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ApiTests {
	private static final String BASE_URI = "http://rp.epam.com/api";
	private static String VALID_ID;
	private RestClient restClient;

	@BeforeTest
	public void setUp(){
		this.restClient = new RestClient(BASE_URI);
	}

	@Test(priority = 1)
	@Description("Post request must return 1 positive status code and 2 negative status codes")
	public void validateCreateLaunch(){
		String positiveRequestBody = new CreateLaunchBuilder()
						.withName("rp_launch")
						.withDescription("My first launch on RP")
						.withStartTime("1574423221000")
						.withMode("DEFAULT")
						.build();

		String firstNegativeRequestBody = new CreateLaunchBuilder()
						.withName("rp_launch")
						.withDescription("My first launch on RP")
						.withStartTime("1574423221000")
						.withMode("DEFAUL")
						.build();

		String secondNegativeRequestBody = new CreateLaunchBuilder()
						.withName("rp_launch")
						.withDescription("My first launch on RP")
						.withMode("DEFAULT")
						.build();

		Response positiveResponse = restClient.createLaunch(positiveRequestBody);
		Response firstNegativeResponse = restClient.createLaunch(firstNegativeRequestBody);
		Response secondNegativeResponse = restClient.createLaunch(secondNegativeRequestBody);
		VALID_ID = positiveResponse.body().jsonPath().get("id").toString();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(positiveResponse.getStatusCode(), 201);
		softAssert.assertEquals(firstNegativeResponse.getStatusCode(),400);
		softAssert.assertEquals(secondNegativeResponse.getStatusCode(),400);
		softAssert.assertAll();
	}

	@Test(priority = 2)
	@Description("Get request must return 1 positive status code and 1 negative status code")
	public void validateGetLaunches(){
		Response positiveResponse = restClient.getLaunchById(VALID_ID);
		Response negativeResponse = restClient.getLaunchById("5261225");;

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(positiveResponse.getStatusCode(), 200);
		softAssert.assertEquals(negativeResponse.getStatusCode(),403);
		softAssert.assertAll();
	}

	@Test(priority = 3)
	@Description("Put request must return 1 positive status code and 2 negative status codes")
	public void validateUpdateLaunch(){
		String positiveRequestBody = new CreateLaunchBuilder()
						.withMode("DEFAULT")
						.build();

		String firstNegativeRequestBody = new CreateLaunchBuilder()
						.withDescription("My first launch on RP1")
						.withMode("DEFAUL")
						.build();

		String secondNegativeRequestBody = new CreateLaunchBuilder()
						.withMode("DEFAULT")
						.build();

		Response positiveResponse = restClient.updateLaunch(positiveRequestBody, VALID_ID);
		Response firstNegativeResponse = restClient.updateLaunch(firstNegativeRequestBody, VALID_ID);
		Response secondNegativeResponse = restClient.updateLaunch(secondNegativeRequestBody, VALID_ID);

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(positiveResponse.getStatusCode(), 201);
		softAssert.assertEquals(firstNegativeResponse.getStatusCode(),400);
		softAssert.assertEquals(secondNegativeResponse.getStatusCode(),400);
		softAssert.assertAll();
	}

	@Test(priority = 4)
	@Description("Delete request must return 1 positive status code and 1 negative status codes")
	public void validateDeleteLaunch(){
		Response positiveResponse = restClient.deleteLaunch(VALID_ID);
		Response negativeResponse = restClient.deleteLaunch("85");

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(positiveResponse.getStatusCode(), 200);
		softAssert.assertEquals(negativeResponse.getStatusCode(),404);
		softAssert.assertAll();
	}
}
