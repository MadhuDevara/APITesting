
//Simple Example of API Testing with RestAssured

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class SimpleAPITest {
    public static void main(String[] args) {
        // Define the base URI and basePath
        RestAssured.baseURI = "https://www.saucedemo.com";
        RestAssured.basePath = "/users";

        try {
            // Try accessing the endpoint
            Response response = RestAssured.get("/123");

            // Log status code and response body
            System.out.println("Status Code: " + response.getStatusCode());
            System.out.println("Response Body: " + response.getBody().asString());

            if (response.getStatusCode() == 404) {
                System.out.println("Resource not found. Trying a different endpoint...");
                Response testResponse = RestAssured.get("/test-endpoint"); // Replace with a valid test endpoint
                handleResponse(testResponse);
            } else {
                handleResponse(response);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private static void handleResponse(Response response) {
        if (response.getStatusCode() != 404) {
            response.then()
                    .statusCode(200)
                    .body("id", equalTo(123))
                    .body("name", equalTo("John Deo"))
                    .body("email", equalTo("john.doe@example.com"))
                    .extract().response();
        } else {
            System.out.println("Failed to find a valid endpoint.");
        }
    }
}



// What is API Testing?

//API Testing involves directly testing APIs as part of integration testing to determine if they meet
//expectations for functionality, reliability, performance, and security.

//Key Aspects of API Testing:
//  • Validation of Endpoints: Ensuring that the endpoints return the expected results for
//  various inputs.
//  • Data Validation: Verifying that the API processes and returns the correct data.
//  • Response Validation: Checking the structure, content, and status codes of the API
//  responses.
//  • Performance Checks: Assessing the speed, stability, and scalability of the API.
//  • Security Verification: Testing for vulnerabilities like SQL injection, cross-site scripting,
//  and data exposure.

//Explanation:

//  • statusCode(200): Verifies that the API returns a 200 OK status, indicating a successful
//  request.
//  • body("id", equalTo(123)): Ensures that the id field in the response matches the
//  expected value 123.
//  • body("name", equalTo("John Doe")): Checks that the name field in the response is
//  "John Doe".
//  • body("email", equalTo("john.doe@example.com")): Confirms that the email field
//  contains the correct email address.
//  This example demonstrates a basic API test where the expected output is validated against the
//  actual API response.