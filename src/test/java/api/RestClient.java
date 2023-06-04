package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestClient {
	private static final String PROJECT_NAME = "aknurtazhibek_personal";
	private static final String LAUNCH_ENDPOINT = String.format("/v1/%s/launch", PROJECT_NAME);
	private static final String AUTHORIZATION_HEADER_VALUE = "bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE2ODU1ODQ2MTMsInVzZXJfbmFtZSI6ImFrbnVydGF6aGliZWsiLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiMzVhNmI3MmMtNDM0YS00NDg2LWI4YmUtNDYyM2NiNzQ3OWFmIiwiY2xpZW50X2lkIjoidWkiLCJzY29wZSI6WyJ1aSJdfQ.WOYfifyaiTHhOnq-92IZ87rVbr4NArPYu3AKw0VLTU0";
	private final String baseURI;

	public RestClient(String baseURI) {
		this.baseURI = baseURI;
		RestAssured.baseURI = baseURI;
	}

	public Response getLaunchById(String launchId) {
		return given()
						.pathParam("launchId", launchId)
						.header("Authorization", AUTHORIZATION_HEADER_VALUE)
						.when()
						.get(LAUNCH_ENDPOINT + "/{launchId}")
						.then()
						.extract()
						.response();
	}

	public Response createLaunch(String requestBody) {
		Response response = given()
						.contentType(ContentType.JSON)
						.header("Authorization", AUTHORIZATION_HEADER_VALUE)
						.body(requestBody)
						.when()
						.post(LAUNCH_ENDPOINT);

		if (response.getStatusCode() == 201) {
			return response;
		} else {
			String redirectedEndpoint = response.getHeader("Location");
			return RestAssured.given()
							.baseUri(baseURI)
							.contentType(ContentType.JSON)
							.header("Authorization", AUTHORIZATION_HEADER_VALUE)
							.body(requestBody)
							.when()
							.post(redirectedEndpoint);
		}
	}

	public Response updateLaunch(String launchId, String requestBody) {
		Response response = given()
						.pathParam("launchId", launchId)
						.contentType(ContentType.JSON)
						.header("Authorization", AUTHORIZATION_HEADER_VALUE)
						.body(requestBody)
						.when()
						.put(LAUNCH_ENDPOINT + "/{launchId}/update");

		if (response.getStatusCode() == 200) {
			return response;
		} else {
			String redirectedEndpoint = response.getHeader("Location");
			return RestAssured.given()
							.baseUri(baseURI)
							.contentType(ContentType.JSON)
							.header("Authorization", AUTHORIZATION_HEADER_VALUE)
							.body(requestBody)
							.when()
							.put(redirectedEndpoint);
		}
	}

	public Response deleteLaunch(String launchId) {
		Response response = given()
						.pathParam("launchId", launchId)
						.contentType(ContentType.JSON)
						.header("Authorization", AUTHORIZATION_HEADER_VALUE)
						.when()
						.delete(LAUNCH_ENDPOINT + "/{launchId}");

		if (response.getStatusCode() == 200) {
			return response;
		} else {
			String redirectedEndpoint = response.getHeader("Location");
			return RestAssured.given()
							.baseUri(baseURI)
							.contentType(ContentType.JSON)
							.header("Authorization", AUTHORIZATION_HEADER_VALUE)
							.when()
							.delete(redirectedEndpoint);
		}
	}
}
