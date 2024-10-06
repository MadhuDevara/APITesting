// How to Validate Error Responses in API Testing?

// Validating error responses is a critical part of API testing, as it ensures the API behaves correctly
// under erroneous or invalid conditions. Error responses can occur due to invalid inputs, incorrect
// requests, unauthorized access, or system errors.

//Steps to Validate Error Responses:
//  1. Identify the Error Scenarios:
//      o Identify possible scenarios that can lead to an error, such as sending invalid data,
//      accessing unauthorized endpoints, or using unsupported HTTP methods.
//  2. Trigger the Error Condition:
//      o Craft a request that is expected to fail. For example, sending a request with a
//      missing required field or using an invalid endpoint.
//  3. Check the HTTP Status Code:
//      o Verify that the API returns the appropriate HTTP status code (e.g., 400 Bad
//      Request, 401 Unauthorized, 404 Not Found, 500 Internal Server Error).
//  4. Validate the Error Message:
//      o Ensure the error message in the response is clear, descriptive, and informative. It
//      should provide enough details to understand the issue.
//  5. Validate the Structure of the Error Response:
//      o Confirm that the error response follows the expected schema (e.g., it contains
//      fields like error, message, timestamp, etc.).

//Programming Example:

//Let's consider a scenario where you are testing an API that returns user information. You want
//to validate that an invalid user ID returns a 404 Not Found error.

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.containsString;

import io.restassured.response.Response;

public class ErrorResponseValidation2 {
    public static void main(String[] args) {
        // Define the base URI
        String baseURI = "https://saucedemo.com"; // Ensure this is the correct API URI

        // Define the endpoint
        String endpoint = "/users/{userId}";

        // Step to capture the response
        Response response = given()
                .baseUri(baseURI)
                .basePath(endpoint)
                .pathParam("userId", 9999)
                .header("Accept", "application/json") // Ensure JSON response
                .when()
                .get()
                .andReturn();

        // Print diagnostics
        System.out.println("Requested URL: " + baseURI + endpoint.replace("{userId}", "9999"));
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Content-Type: " + response.getContentType());

        // Print the response content for debugging
        String responseBody = response.getBody().asString();
        System.out.println("Response: " + responseBody);

        // Validate the response if it's JSON
        if (response.getContentType().contains("application/json")) {
            response.then()
                    .assertThat()
                    .statusCode(404) // Validate the status code is 404
                    .body("error", equalTo("Not Found")) // Check if 'error' field equals "Not Found"
                    .body("message", containsString("user not found")); // Check if 'message' field contains "user not found"
        } else {
            System.out.println("Received unexpected content-type: " + response.getContentType());
        }
    }
}