// Programming Example in Java Rest Assured - POST Request
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.json.JSONObject;

public class ApiAutomationPostExample2 {
    public static void main(String[] args){
        // Base URI for the API
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Create JSON object for the POST request payload
        JSONObject requestParams = new JSONObject();
        requestParams.put("title", "foo");
        requestParams.put("body", "bar");
        requestParams.put("userId", 1);

        // Automated POST request to verify status code and specific fields in the response
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestParams.toString()) // Attach the JSON payload
                .when()
                .post("/posts") // Ensure only the sub-path is specified here
                .then()
                .assertThat()
                .statusCode(201) // Verify the status code for successful POST creation
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar")) // Add this verification for the body field
                .body("userId", equalTo(1)) // Verify userId field in response body
                .extract()
                .response();

        // Print the response body
        System.out.println("Response Body: " + response.getBody().asString());
    }
}

/*
Explanation:
        1. Base URI: The base URI (https://jsonplaceholder.typicode.com) is set for the API.
        2. JSON Object Creation:
        o A JSONObject is created to represent the request payload.
        o The fields title, body, and userId are added to the JSON object.
                                           3. POST Request:
                                           o The given() method is used to set up the request.
o header("Content-Type", "application/json"): Specifies that the request body is in
JSON format.
o body(requestParams.toString()): Attaches the JSON payload to the request.
        o post("/posts"): Sends a POST request to the /posts endpoint.
        4. Assertions:
o statusCode(201): Verifies that the response status code is 201, indicating
successful creation.
o body("title", equalTo("foo")): Verifies that the title field in the response matches
the input.
o body("body", equalTo("bar")): Verifies that the body field in the response
matches the input.
        o body("userId", equalTo(1)): Verifies that the userId field in the response matches
the input.
        5. Response Extraction:
o The response is extracted and printed to the console for further verification.
This example demonstrates how to automate a POST request using Rest Assured, including
setting up the request payload, sending the request, and verifying the response.
*/
