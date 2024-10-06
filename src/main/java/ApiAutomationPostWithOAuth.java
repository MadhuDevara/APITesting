//

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import static org.hamcrest.Matchers.equalTo;

public class ApiAutomationPostWithOAuth {
    public static void main(String[] args) {
        // Base URI for the API
        RestAssured.baseURI = "https://reqres.in";

        // Create a JSON object for the POST request payload
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "John Doe");
        requestParams.put("job", "Software Engineer");

        // Automated POST request without OAuth 2.0 authentication
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestParams.toString()) // Attach the JSON payload
                .when()
                .post("/api/users"); // Note: Including 'api' in endpoint as per reqres.in API documentation

        // Log the actual status code
        System.out.println("Actual Status Code: " + response.getStatusCode());

        // Verify the response
        response.then()
                .assertThat()
                .statusCode(201) // Verify status code for successful POST creation
                .body("name", equalTo("John Doe")) // Verify name field in response body
                .body("job", equalTo("Software Engineer")); // Verify job field

        printResponseBody(response);
    }

    private static void printResponseBody(Response response) {
        System.out.println("Response Body: " + response.getBody().asString());
    }
}


/*

        Explanation:
        1. Base URI: The base URI (https://api.example.com) is set for the API. Replace this with
        the actual base URL of your API.
        2. OAuth 2.0 Token:
        o The accessToken variable holds the OAuth 2.0 access token required to
        authenticate the request. This token is typically obtained via an OAuth 2.0 flow,
        such as authorization code flow, client credentials flow, etc.
        3. JSON Object Creation:
        o A JSONObject is created to represent the request payload with fields such as
        name, email, and age.
        4. POST Request with OAuth 2.0:
        o The given() method is used to set up the request.
        o auth().oauth2(accessToken): Adds the OAuth 2.0 token to the Authorization
        header.
        o header("Content-Type", "application/json"): Specifies that the request body is in
        JSON format.
        o body(requestParams.toString()): Attaches the JSON payload to the request.
        o post("/users"): Sends a POST request to the /users endpoint.
        5. Assertions:
        o statusCode(201): Verifies that the response status code is 201, indicating
        successful creation.
        o body("name", equalTo("John Doe")): Verifies that the name field in the response
        matches the input.
        o body("email", equalTo("john.doe@example.com")): Verifies that the email field
        matches the input.
        o body("age", equalTo(30)): Verifies that the age field matches the input.
        6. Response Extraction:
        o The response is extracted and printed to the console for further verification.
        Obtaining the OAuth 2.0 Token
        Before running this code, ensure you have a valid OAuth 2.0 access token. Typically, you would
        obtain this token by performing an OAuth 2.0 flow using an authentication server. This flow
        might involve exchanging a client ID, client secret, and authorization code for an access token.
        This example demonstrates how to automate a POST request with OAuth 2.0 authentication
        using Rest Assured, including setting up the request payload, sending the request, and verifying
        the response.

*/


